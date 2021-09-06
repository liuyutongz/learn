package com.test.lyt.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author lyt
 * @description
 * @date 2021/9/6 15:50
 */
public class TestJob {
    public static void main(String[] args) {
        JobDetail jobDetail= JobBuilder.newJob(MyJob.class)
                .withIdentity("job1","group1")
                .build();
        Trigger trigger= TriggerBuilder.newTrigger()
                .withIdentity("trigger1","trigger1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(1)
                        .repeatForever())
                .build();

        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.scheduleJob(jobDetail,trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }
}
