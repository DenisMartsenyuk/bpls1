package ru.lab.lab1.quartz;

import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

import java.text.ParseException;

@Configuration
public class QuartzSubmitJobs {
    private static final String CRON = "0/30 * * * * ?";//"0/30 * * * * ?"; //0 0 0 1 * ?

    @Bean(name = "job1")
    public JobDetailFactoryBean jobMemberClassStats() {
        return QuartzConfig.createJobDetail(TopMoviesNotifications.class, "statJob");
    }

    @Bean
    public CronTriggerFactoryBean triggerMemberClassStats(@Qualifier("job1") JobDetail jobDetail) throws ParseException {
        return QuartzConfig.createCronTrigger(jobDetail, CRON, "statTrigger");
    }
}
