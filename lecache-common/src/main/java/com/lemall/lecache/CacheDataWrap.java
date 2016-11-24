package com.lemall.lecache;

import java.io.Serializable;

/** 
 * @Description:
 * @author Dimmacro
 * @Comany:LETV
 * @Create time: 2016年9月12日上午11:20:43
 * cache原始对象的包装器
 */
public class CacheDataWrap<T> implements Serializable{
    private static final long serialVersionUID = 443681688124621995L;
    
    T sourceCacheData;
    long expireTimestamp; //此对象的过期时间戳
    
    public CacheDataWrap(T cacheData) {
        this.sourceCacheData = cacheData;
        this.expireTimestamp = -1L;
    }
    
    public CacheDataWrap(T cacheData ,long expireTimestamp) {
        this.sourceCacheData = cacheData;
        this.expireTimestamp = expireTimestamp;
    }
    
    public void setExpireTimestamp(long expireTimestamp){
        this.expireTimestamp = expireTimestamp;
    }
    
    public long getExpireTimestamp(){
        return this.expireTimestamp;
    }
    
    public T getCacheData(){
        if(-1L == this.expireTimestamp){
            return this.sourceCacheData;
        }
        if(System.currentTimeMillis() > expireTimestamp){
            return null;
        }
        return this.sourceCacheData;
    }

}
