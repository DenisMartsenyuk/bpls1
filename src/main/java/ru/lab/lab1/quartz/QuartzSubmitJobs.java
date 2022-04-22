package ru.lab.lab1.quartz;

import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

@Configuration
public class QuartzSubmitJobs {
    private static final String CRON = "0/30 * * * * ?";//"0/30 * * * * ?"; //0 0 0 1 * ?

    @Bean(name = "top_movies_notification")
    public JobDetailFactoryBean jobMemberClassStats() {
        return QuartzConfig.createJobDetail(TopMoviesNotifications.class, "notification_job");
    }

    @Bean
    public CronTriggerFactoryBean triggerMemberClassStats(@Qualifier("top_movies_notification") JobDetail jobDetail) {
        return QuartzConfig.createCronTrigger(jobDetail, CRON, "notification_trigger");
    }
}
