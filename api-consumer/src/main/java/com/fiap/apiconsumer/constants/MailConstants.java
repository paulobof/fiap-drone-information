package com.fiap.apiconsumer.constants;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MailConstants {
    public static final String SUBJECT = "ALERTA Drone Information";

//    @Value("${sender}")
//    public static String SENDER;
//
//    @Value("${receiver}")
//    public static String RECEIVER;
//
//    @Value("${password}")
//    public static String PASSWORD;

    public static final String BR = "\n";
}
