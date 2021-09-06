package com.test.lyt.pool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author lyt
 * @description 线程池 ScheduledThreadPool
 * @date 2021/9/6 14:49
 */
public class ScheduleThreadPoolTest {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool= Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 2; i++) {
            scheduledThreadPool.scheduleAtFixedRate(new Task("task-"+i),0,2, TimeUnit.SECONDS);
        }
    }
}
class Task implements Runnable{
    private String name;

    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println("name="+name+",startTime="+new Date());
            Thread.sleep(3000);
            System.out.println("name="+name+",endTime="+new Date());
            //线程池执行
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}