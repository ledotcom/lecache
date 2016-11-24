package com.lemall.lecache.cache;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.lemall.lecache.exception.CacheException;
/**
 * 
 * @Description:缓存接口类
 * @author Dimmacro
 * @Comany:LETV
 * @Create time: 2016年9月14日下午7:55:07
 *
 */
public interface Cache {
    
    /**
     * 
     * @Description:
     * @throws CacheException
     * @Author:denghong1 2016年9月14日下午9:00:04
     * @update1:
     *
     */
    public void init() throws CacheException;

    /**
     * 
     * @Description:
     * @param key
     * @param value
     * @throws CacheException
     * @Author:denghong1 2016年9月14日下午8:01:25
     * @update1:
     *
     */
    public void set(Object key, Object value) throws CacheException;
    
   /**
    * 
    * @Description:
    * @param objectMap
    * @throws CacheException
    * @Author:denghong1 2016年9月14日下午8:14:50
    * @update1:
    *
    */
    public void mset(Map<Object, Object> objectMap) throws CacheException;
    
	/**
	 * 
	 * @Description:
	 * @param key
	 * @return
	 * @throws CacheException
	 * @Author:denghong1 2016年9月14日下午8:08:41
	 * @update1:
	 *
	 */
	public <T> T get(Object key) throws CacheException;
	
	/**
	 * 
	 * @Description:需要支持模糊查询
	 * @param keys
	 * @return
	 * @throws CacheException
	 * @Author:denghong1 2016年9月14日下午8:41:04
	 * @update1:
	 *
	 */
	public <T> Map<Object, T> mget(Collection<Object> keys) throws CacheException;
	
	/**
	 * 
	 * @Description:
	 * @param key
	 * @throws CacheException
	 * @Author:denghong1 2016年9月14日下午8:47:10
	 * @update1:
	 *
	 */
	public <T> T remove(Object key) throws CacheException;
	
	/**
	 * 
	 * @Description:
	 * @param keys
	 * @return
	 * @throws CacheException
	 * @Author:denghong1 2016年9月14日下午8:50:19
	 * @update1:
	 *
	 */
	public <T> Map<Object, T> mremove(Collection<Object> keys) throws CacheException;
	
	/**
	 * 
	 * @Description:
	 * @return
	 * @throws CacheException
	 * @Author:denghong1 2016年9月14日下午8:41:54
	 * @update1:
	 *
	 */
	public List<Object> allKeys() throws CacheException ;
	
	
	/**
	 * 
	 * @Description:清空内容不删除缓存容器
	 * @throws CacheException
	 * @Author:denghong1 2016年9月14日下午8:53:39
	 * @update1:
	 *
	 */
	public void clear() throws CacheException;
	
	/**
	 * 
	 * @Description:彻底删除缓存容器
	 * @throws CacheException
	 * @Author:denghong1 2016年9月14日下午8:53:45
	 * @update1:
	 *
	 */
	public void destroy() throws CacheException;
	
}
