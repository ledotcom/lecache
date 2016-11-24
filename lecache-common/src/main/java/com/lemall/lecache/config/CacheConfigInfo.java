package com.lemall.lecache.config;

/** 
 * @Description:
 * @author Dimmacro
 * @Comany:LETV
 * @Create time: 2016年9月18日下午3:55:30
 * 
 */
public class CacheConfigInfo {
    private int level;
    private String name;
    private String type;
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
