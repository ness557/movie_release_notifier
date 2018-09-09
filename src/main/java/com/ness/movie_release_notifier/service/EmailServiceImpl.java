package com.ness.movie_release_notifier.service;

import com.ness.movie_release_notifier.model.OmdbWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private MailSender mailSender;

    @Override
    public void sendNotifyEmail(String emailAddress, OmdbWrapper omdbWrapper) {
        SimpleMailMessage message = new SimpleMailMessage();

        //TODO better email film wrapper
        message.setText(omdbWrapper.toString());
        message.setTo(emailAddress);
        message.setFrom("movie_release_notifier@gmail.com");
        message.setSubject("testing");

        mailSender.send(message);
    }
}
