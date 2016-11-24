package com.lemall.lecache;

import java.util.HashMap;
import java.util.Map;

import com.lemall.lecache.cache.Cache;
import com.lemall.lecache.exception.CacheException;

/** 
 * @Description:
 * @author Dimmacro
 * @Comany:LeEco
 * @Create time: 2016年9月21日下午6:19:22
 * 
 */
public class CacheFactory {
    private static CacheFactory instance;
    private Map<String, Cache> cacheMap; 
    
    private CacheFactory(){
        cacheMap = new HashMap<String, Cache>();
    }

    public static CacheFactory getInstance(){
        if(null == instance){
            synchronized(CacheFactory.class){
                if(null == instance){
                    return new CacheFactory();
                }
            }
            return instance;
        }
        return instance;
    }
    
    
    /**
     * @Description:
     * @param type
     * @return
     * @Author:denghong1 2016年9月21日下午6:19:28
     * @update1:
     * 
     */
    public Cache buildCache(String cacheType) throws CacheException{
        Cache cache = cacheMap.get(cacheType);
        if(null == cache){
            // TODO 根据cacheType去查找class，根据class发射生成对象，调用init方法进行初始化工作。如果找到重复的cacheType，则报错
            
            //将生成的cache放入map，有可能有并发问题
            cacheMap.put(cacheType, cache);
        }
        return cache;
    }

}
