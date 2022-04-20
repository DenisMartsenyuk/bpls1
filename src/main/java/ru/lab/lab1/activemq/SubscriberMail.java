package ru.lab.lab1.activemq;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import ru.lab.lab1.service.EmailService;
import ru.lab.lab1.dto.SendingEmailDTO;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

@Component
@RequiredArgsConstructor
public class SubscriberMail {

    private final EmailService emailService;

    @JmsListener(destination = "top_films")
    public void receive(ObjectMessage message) throws JMSException {
        SendingEmailDTO sendingEmailDTO = (SendingEmailDTO) message.getObject();
        emailService.send(sendingEmailDTO);
    }

}
