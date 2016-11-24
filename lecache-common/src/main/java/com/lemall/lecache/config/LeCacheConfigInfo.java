package com.lemall.lecache.config;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.lemall.lecache.exception.CacheException;
import com.lemall.lecache.util.StringUtil;

/**
 * @Description:
 * @author Dimmacro
 * @Comany:LETV
 * @Create time: 2016年9月18日下午3:55:18
 * 
 */
public class LeCacheConfigInfo {
    private String leCacheName;
    private List<CacheConfigInfo> cacheConfigInfoList;

    // TODO

    public String getLeCacheName() {
        return leCacheName;
    }

    public void setLeCacheName(String leCacheName) {
        this.leCacheName = leCacheName;
    }

    public List<CacheConfigInfo> getCacheConfigInfoList() {
        return cacheConfigInfoList;
    }

    public void setCacheConfigInfoList(List<CacheConfigInfo> cacheConfigInfoList) {
        this.cacheConfigInfoList = cacheConfigInfoList;
        Collections.sort(cacheConfigInfoList, new Comparator<CacheConfigInfo>() {
            public int compare(CacheConfigInfo o1, CacheConfigInfo o2) {
                if(o1.getLevel() == o1.getLevel()){
                    throw new CacheException("cache level should not be the same");
                }
                return o1.getLevel() > o2.getLevel() ? -1 : 1; // 按照level进行排序的
            }
        });
    }

    public boolean isEmpty() {
        boolean checkIfEmpty = StringUtil.isEmpty(leCacheName);
        if(checkIfEmpty){
            return true;
        }
        checkIfEmpty = (null == cacheConfigInfoList || cacheConfigInfoList.isEmpty());
        if(checkIfEmpty){
            return true;
        }
        return false;
    }
}
