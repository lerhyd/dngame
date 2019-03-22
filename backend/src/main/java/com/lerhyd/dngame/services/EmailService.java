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
//@RequestMapping("#/mailer")
public class EmailService {
    @Autowired
    Environment env;
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(String subject, User to, String text){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setFrom("deathNoteGame@yandex.ru");
        simpleMailMessage.setTo(to.getNeuralEmail());
        simpleMailMessage.setText(text);
        //if (env.getProperty("PMAIL") != null) javaMailSender.send(simpleMailMessage);
        javaMailSender.send(simpleMailMessage);
    }
    public void sendMail(String subject, String from, String to, String text){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setText(text);
        //if (env.getProperty("PMAIL") != null) javaMailSender.send(simpleMailMessage);
        javaMailSender.send(simpleMailMessage);
    }
    @RequestMapping(value = "/")
    public String myController() {
        return "index";
    }

    @RequestMapping(path = "/test", method = RequestMethod.POST)
    //@PostMapping(path = "/mail")
    public String testMail(){
        User u = new User();
        u.setEmail("deathNoteProject@yandex.ru");
        sendMail("test1","co8ectu.net@gmail.com","deathNoteProject@yandex.ru","hi. it's okey!");
        return "Email sent";
    }
}