package com.fiap.apiconsumer.scheduler;

import com.fiap.apiconsumer.constants.MailConstants;
import com.fiap.apiconsumer.consumer.DroneConsumer;
import com.fiap.apiconsumer.dto.MailMessage;
import com.fiap.apiconsumer.mail.Mailer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler extends DroneConsumer {

    private MailMessage mailMessage = new MailMessage();
    private Mailer mailer;

    public EmailScheduler (Mailer mailer){
        this.mailer = mailer;
    }


    @Scheduled(fixedDelay = 100000)
    public void sendEmail() {;
        if (stringBuilder == null || stringBuilder.toString().equals("")) {

        } else {
            stringBuilder.append("----------------------------------------------");

            mailMessage.setSubject(MailConstants.SUBJECT);
            mailMessage.setBody(stringBuilder.toString());
            mailMessage.setSender(MailConstants.SENDER);
            mailMessage.setRecipient(MailConstants.RECEIVER);
            mailer.sendEmail(mailMessage);
            stringBuilder.setLength(0);
        }
    }
}