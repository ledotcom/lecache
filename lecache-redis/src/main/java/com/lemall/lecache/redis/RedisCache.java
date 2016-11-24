package com.lemall.lecache.redis;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.lemall.lecache.cache.Cache;
import com.lemall.lecache.cache.CacheType;
import com.lemall.lecache.exception.CacheException;

/** 
 * @Description:
 * @author Dimmacro
 * @Comany:LETV
 * @Create time: 2016年9月14日下午9:29:52
 * 
 */
@CacheType(type="redis")
public class RedisCache implements Cache{

    /**
     * @Description:
     * @throws CacheException
     * @Author:denghong1 2016年9月14日下午9:30:08
     * @see com.lemall.lecache.cache.Cache#init()
     * @update1:
     * 
     */
    @Override
    public void init() throws CacheException {
        // TODO Auto-generated method stub
        
    }

    /**
     * @Description:
     * @param key
     * @param value
     * @throws CacheException
     * @Author:denghong1 2016年9月14日下午9:30:08
     * @see com.lemall.lecache.cache.Cache#set(java.lang.Object, java.lang.Object)
     * @update1:
     * 
     */
    @Override
    public void set(Object key, Object value) throws CacheException {
        // TODO Auto-generated method stub
        
    }

    /**
     * @Description:
     * @param objectMap
     * @throws CacheException
     * @Author:denghong1 2016年9月14日下午9:30:08
     * @see com.lemall.lecache.cache.Cache#mset(java.util.Map)
     * @update1:
     * 
     */
    @Override
    public void mset(Map<Object, Object> objectMap) throws CacheException {
        // TODO Auto-generated method stub
        
    }

    /**
     * @Description:
     * @param key
     * @return
     * @throws CacheException
     * @Author:denghong1 2016年9月14日下午9:30:08
     * @see com.lemall.lecache.cache.Cache#get(java.lang.Object)
     * @update1:
     * 
     */
    @Override
    public <T> T get(Object key) throws CacheException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @Description:
     * @param keys
     * @return
     * @throws CacheException
     * @Author:denghong1 2016年9月14日下午9:30:08
     * @see com.lemall.lecache.cache.Cache#mget(java.util.Collection)
     * @update1:
     * 
     */
    @Override
    public <T> Map<Object, T> mget(Collection<Object> keys) throws CacheException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @Description:
     * @param key
     * @return
     * @throws CacheException
     * @Author:denghong1 2016年9月14日下午9:30:08
     * @see com.lemall.lecache.cache.Cache#remove(java.lang.Object)
     * @update1:
     * 
     */
    @Override
    public <T> T remove(Object key) throws CacheException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @Description:
     * @param keys
     * @return
     * @throws CacheException
     * @Author:denghong1 2016年9月14日下午9:30:08
     * @see com.lemall.lecache.cache.Cache#mremove(java.util.Collection)
     * @update1:
     * 
     */
    @Override
    public <T> Map<Object, T> mremove(Collection<Object> keys) throws CacheException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @Description:
     * @return
     * @throws CacheException
     * @Author:denghong1 2016年9月14日下午9:30:08
     * @see com.lemall.lecache.cache.Cache#allKeys()
     * @update1:
     * 
     */
    @Override
    public List<Object> allKeys() throws CacheException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @Description:
     * @throws CacheException
     * @Author:denghong1 2016年9月14日下午9:30:08
     * @see com.lemall.lecache.cache.Cache#clear()
     * @update1:
     * 
     */
    @Override
    public void clear() throws CacheException {
        // TODO Auto-generated method stub
        
    }

    /**
     * @Description:
     * @throws CacheException
     * @Author:denghong1 2016年9月14日下午9:30:08
     * @see com.lemall.lecache.cache.Cache#destroy()
     * @update1:
     * 
     */
    @Override
    public void destroy() throws CacheException {
        // TODO Auto-generated method stub
        
    }

}
