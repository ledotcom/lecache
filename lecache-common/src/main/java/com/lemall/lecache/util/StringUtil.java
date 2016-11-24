package com.lemall.lecache.util;

/**
 * @Description:
 * @author Dimmacro
 * @Comany:LeEco
 * @Create time: 2016年9月18日下午4:51:14
 * 
 */
public class StringUtil {
    public static final String DEFAULT_CHARSET = "UTF-8";
    /**
     * @Description:
     * @param configFileFullPath
     * @return
     * @Author:denghong1 2016年9月18日下午4:51:39
     * @update1:
     * 
     */
    public static boolean isEmpty(String value) {
        if(null == value || "".equals(value.trim())){
            return true;
        }
        return false;
    }

}
