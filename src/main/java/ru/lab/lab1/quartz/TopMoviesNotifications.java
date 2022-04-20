package ru.lab.lab1.quartz;

import lombok.RequiredArgsConstructor;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.lab.lab1.component.TopMoviesGenerator;

@Component
@RequiredArgsConstructor
public class TopMoviesNotifications implements Job {

    private final JmsTemplate jmsTemplate;
    private final TopMoviesGenerator generator;

    @Transactional
    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        jmsTemplate.send("top_films", session -> session.createObjectMessage(generator.generate()));

    }
}
