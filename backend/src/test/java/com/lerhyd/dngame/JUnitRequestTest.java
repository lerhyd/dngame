package com.lerhyd.dngame;

import com.lerhyd.dngame.controllers.AuthController;
import com.lerhyd.dngame.dao.UserDao;
import com.lerhyd.dngame.request.UserReq;
import com.lerhyd.dngame.services.EmailService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.Email;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JUnitRequestTest {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    UserDao userDao;
    @Autowired
    AuthController authController;
    @Autowired
    EmailService emailService;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testCreatingUsers(){
        userDao.deleteAll();
        UserReq userReq = new UserReq();
        userReq.setEmail("C08-ECTb@yandex.ru");
        userReq.setLogin("userTester");
        userReq.setPassword("Test123456789");
        userReq.setRetypePassword("Test123456789");
        authController.createUser(userReq);
    }

    @Test
    public void testMail(){
        //emailService.testMail();
        emailService.sendMail("Test","deathNoteProject@yandex.ru", "C08-ECTb@yandex.ru","Test completed!");
    }

}
