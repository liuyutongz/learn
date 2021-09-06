package com.test.lyt.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author lyt
 * @description  Timer是单线程
 * @date 2021/9/6 10:29
 */
public class TimerTest {
    public static void main(String[] args) {
        Timer t = new Timer();//任务启动
        for (int i = 0; i < 2; i++) {
           TimerTask task = new FoolTimerTask("foo"+i);
           t.schedule(task,new Date(),2000);//任务添加
            // 预设的执行时间nextExecutTime 12:00:00   12:00:02  12：00：04
            //schedule 真正的执行时间，取决于上一个任务的结束时间 ExecuteTime 03 05  08 丢任务（少执行了次数）
            //scheduleAtFixedRate  严格按照预设时间 12：00：00  12：00：02   12：00：04 （执行时间会乱）
//单线程  任务阻塞  任务超时
        }

    }
}
class FoolTimerTask extends TimerTask{

    private String name;

    public FoolTimerTask(String name) {
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
