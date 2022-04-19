package com.fiap.apiconsumer.scheduler;

import com.fiap.apiconsumer.constants.MailConstants;
import com.fiap.apiconsumer.consumer.DroneConsumer;
import com.fiap.apiconsumer.dto.MailMessage;
import com.fiap.apiconsumer.mail.Mailer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler extends DroneConsumer {

    private MailMessage mailMessage = new MailMessage();
    private Mailer mailer;

    @Value("${sender}")
    private String SENDER;

    @Value("${receiver}")
    private String RECEIVER;



    public EmailScheduler (Mailer mailer){
        this.mailer = mailer;
    }


    @Scheduled(fixedDelay = 60000)
    public void sendEmail() {
        if (stringBuilder != null && !stringBuilder.toString().equals("")) {
            stringBuilder.append("----------------------------------------------");
            mailMessage.setSubject(MailConstants.SUBJECT);
            mailMessage.setBody(stringBuilder.toString());
            mailMessage.setSender(SENDER);
            mailMessage.setRecipient(RECEIVER);
            System.out.println("\nEnviando alerta: \n");
            System.out.println(mailMessage + "\n");
            mailer.sendEmail(mailMessage);
            stringBuilder.setLength(0);
        }
    }
}