package com.lerhyd.dngame.controller;

import com.lerhyd.dngame.model.*;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class NewsGenerator {

    static News generateSimpleNews(){
        return new News("random", LocalDateTime.now(), true);
    }



}
