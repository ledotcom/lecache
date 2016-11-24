package com.lemall.lecache.common;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import org.junit.Before;
import org.junit.Test;

/**
 * @Description:
 * @author Dimmacro
 * @Comany:LeEco
 * @Create time: 2016年9月19日下午3:37:49
 * 
 */
public class WatchFileTest {

    /**
     * @Description:
     * @throws java.lang.Exception
     * @Author:denghong1 2016年9月19日下午3:37:49
     * @update1:
     * 
     */
    @Before
    public void setUp() throws Exception {}

    @Test
    public void test() {
        WatchService watcher = null;
        try{
            watcher = FileSystems.getDefault().newWatchService();
            Path dir = FileSystems.getDefault().getPath("E:\\");

            WatchKey key = dir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY);

            while(true){
                key = watcher.take();
                for(WatchEvent<?> event:key.pollEvents()){
                    System.out.println(event.kind().name());
                    System.out.println(event.context());
                    System.out.println(event.count()); // 大于1表示可重复的事件，1表示新增，删除等不可重复事件。
                }
                key.reset();
            }
        }catch(IOException e){
            e.printStackTrace();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}
