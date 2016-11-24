package com.lemall.lecache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.lemall.lecache.config.Configuration;
import com.lemall.lecache.exception.CacheException;

/** 
 * @Description:
 * @author Dimmacro
 * @Comany:LETV
 * @Create time: 2016年9月14日下午9:33:14
 * 
 */
public class LeCacheManager {
    private static LeCacheManager instance;
    private Map<String, LeCache> leCacheMap; 
    
    private LeCacheManager(){
        leCacheMap = new HashMap<String, LeCache>();
        Configuration.getInstance().loadConfigFile(Configuration.DEFAULT_LECACHE_CONFIG_FILE);
    }
    
    public static LeCacheManager getInstance(){
        if(null == instance){
            synchronized(LeCacheManager.class){
                if(null == instance){
                    return new LeCacheManager();
                }
            }
            return instance;
        }
        return instance;
    }
    /**
     * 
     * @Description:
     * @return
     * @throws CacheException
     * @Author:denghong1 2016年9月14日下午9:34:52
     * @update1:
     *
     */
    public static LeCache getLeCache() throws CacheException{
        return getLeCache(Constants.DEFAULT_CACHE);
    }
    
    public static LeCache getLeCache(String cacheName) throws CacheException{
        // 加载缓存配置
        // 根据配置文件内容初始化LeCacheProxy
        LeCache leCache = instance.leCacheMap.get(cacheName);
        if(null == leCache){
            leCache = new LeCache(cacheName);
            instance.leCacheMap.put(cacheName, leCache);
        }
        return leCache;
    }
    
    public void reflushLeCache() throws CacheException{
        Iterator<String> iterator = leCacheMap.keySet().iterator();
        String cacheName;
        while(iterator.hasNext()){
            cacheName = iterator.next();
            LeCache oldCache = leCacheMap.put(cacheName, new LeCache(cacheName)); // new新的对象并替换掉之前的
            if(null != oldCache){
                oldCache.destroy(); // 把旧对象清理掉
            }
        }
    }
    
}
