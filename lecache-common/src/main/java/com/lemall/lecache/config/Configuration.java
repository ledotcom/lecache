package com.lemall.lecache.config;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.lemall.lecache.LeCacheManager;
import com.lemall.lecache.exception.CacheException;
import com.lemall.lecache.util.StringUtil;
import com.lemall.lecache.util.XmlUtil;

/** 
 * @Description:全局配置文件，可监控文件内容变化，动态进行加载
 * @author Dimmacro
 * @Comany:LETV
 * @Create time: 2016年9月18日上午11:19:11
 * 
 */
public class Configuration {
    public static final String DEFAULT_LECACHE_CONFIG_FILE = "lecache.xml";
    
    private static Configuration instance ;
    
    
    private String configFileFullPath;
    
    private Properties configProperties;
    private Map<String,LeCacheConfigInfo> leCacheConfigMap;
    
    private Configuration(){
        leCacheConfigMap = new HashMap<String, LeCacheConfigInfo>();
    }
    
    public static Configuration getInstance(){
        if(null == instance){
            synchronized(Configuration.class){
                if(null == instance){
                    return new Configuration();
                }
            }
            return instance;
        }
        return instance;
    }
    
    public void loadConfigFile(String configFilePath){
        // TODO
        //根据文件路径加载配置xml文件，解析里面的内容，把配置信息加载到configProperties中，把cache的信息加载到leCacheConfigMap中
        try{
            File xmlFile = new File(Configuration.class.getClassLoader().getResource(configFilePath).toURI());
            Document document = XmlUtil.createDocument(xmlFile); 
            Properties configProperties = loadConfigProperties(document.getDocumentElement());
            Map<String,LeCacheConfigInfo> leCacheConfigMap = loadLeCacheConfigMap(document.getDocumentElement());
            
            Properties oldConfigProperties = this.configProperties;
            Map<String,LeCacheConfigInfo> oldLeCacheConfigMap= this.leCacheConfigMap;
            this.configProperties = configProperties;
            this.leCacheConfigMap = leCacheConfigMap;
            
            // clean old config 
            if(null != oldConfigProperties){
                oldConfigProperties.clear();
            }
            if(null != oldLeCacheConfigMap && !oldLeCacheConfigMap.isEmpty()){
                Iterator<String> keyIterator = oldLeCacheConfigMap.keySet().iterator();
                while(keyIterator.hasNext()){
                    oldLeCacheConfigMap.remove(keyIterator.next());
                }
            }
        }catch(Exception e){
            throw new CacheException("load config file error");
        }
        new Thread(new MonitorFileChange(FileSystems.getDefault().getPath(configFilePath))).start();
    }
    
    private Properties loadConfigProperties(Node configNode){
        return null; //TODO
    }
    
    private Map<String,LeCacheConfigInfo> loadLeCacheConfigMap(Node configNode){
        return null; //TODO
    }
    
    public void reloadConfigFile() throws CacheException{
        // TODO
        if(StringUtil.isEmpty(this.configFileFullPath)){
            throw new CacheException("reload lecache config file error:there is no configFileFullPath");
        }
        loadConfigFile(this.configFileFullPath);
    }
    
    
    public String getPropertyValue(String key){
        return configProperties.getProperty(key, "");
    }
    
    public LeCacheConfigInfo getLeCacheConfigInfo(String cacheName){
        return leCacheConfigMap.get(cacheName);
    }

    
    private class MonitorFileChange implements Runnable {
        private Path path;
        MonitorFileChange(Path path){
            this.path = path;
        }
        @Override
        public void run() {
            if(null == path || !path.toFile().exists() || path.toFile().isDirectory()){
                throw new CacheException("monitor file is null or just dir");
            }
            try{
                WatchService watchService = FileSystems.getDefault().newWatchService();
                path.getParent().register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
                while(true){
                    WatchKey key = watchService.take();
                    if(path.toFile().getName().equals(key.pollEvents().get(0).context())){
                        // 配置文件内容发生了变化
                        reloadConfigFile();
                        LeCacheManager.getInstance().reflushLeCache();
                    }
                    key.reset();
                }
            }catch(IOException | InterruptedException |CacheException e){
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }

    }
}
