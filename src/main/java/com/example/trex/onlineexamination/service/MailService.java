package com.example.trex.onlineexamination.service;

import org.springframework.mail.SimpleMailMessage;

public interface MailService {
    public void sendEmail(SimpleMailMessage email);
}
