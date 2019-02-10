package com.lerhyd.dngame.services;

import com.lerhyd.dngame.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailService {
    @Autowired
    Environment env;
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(String subject, User to, String text){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setFrom("lerhyd@gmail.com");
        simpleMailMessage.setTo(to.getEmail());
        simpleMailMessage.setText(text);
        if(env.getProperty("PMAIL")!=null)
            javaMailSender.send(simpleMailMessage);
        //javaMailSender.send(simpleMailMessage);
    }
    public void sendMail(String subject, String from, String to, String text){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setText(text);
        if(env.getProperty("PMAIL")!=null)
            javaMailSender.send(simpleMailMessage);
        //javaMailSender.send(simpleMailMessage);
    }
    @RequestMapping(path = "/mail", method = RequestMethod.POST)
    public String testMail(){
        sendMail("Test","lerhyd@gmail.com", "lerhyd@gmail.com","Test completed!");
        return "Email sent";
    }
}