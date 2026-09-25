package com.mongpro.mongo_project.controllers;

import com.mongpro.mongo_project.entities.EmailBody;
import com.mongpro.mongo_project.entities.TextToSpeechRequest;
import com.mongpro.mongo_project.entities.User;
import com.mongpro.mongo_project.repo.UserRepoImpl;
import com.mongpro.mongo_project.respone.WeatherResponse;
import com.mongpro.mongo_project.services.*;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

@RequestMapping("/public")
public class PublicController {
    @Autowired
    public WeatherService weatherService;
    @Autowired
    public UserRepoImpl userRepoImpl;
    @Autowired
    public UserService service;

    @Autowired
    public QuoteService quoteService;

    @Autowired
    public ElevenLabsService elevenLabsService;
    @Autowired
    public EmailService emailService;

    @GetMapping("/check")
    public String fn(){
        return "hello";
    }

    @PostMapping("/create-user")
    public void create(@RequestBody User user){
        service.create(user);
    }

    @GetMapping("/weather/{city}")
    public String getweather(@PathVariable String city){
        WeatherResponse weather = weatherService.fn(city);
        return "Hey niyamath the temp is "+ weather.getCurrent().getTemp_c();
    }

    @GetMapping("/quotes")
    public String quote(){
        String q = quoteService.quoto().getQ();
        return "Todays quote of the day is : " + q;
    }

    @PostMapping("/text-speech")
    public ResponseEntity<byte[]> speak(@RequestBody TextToSpeechRequest request) {

        byte[] audio = elevenLabsService.generateSpeech(request);

        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf("audio/mpeg"))
                .body(audio);
    }

    @GetMapping("/repoimpl")
    public List<User> find(){
        return userRepoImpl.findUsers();
    }

    @GetMapping("/send-mail")
    public String sendMail(@RequestBody EmailBody emailBody) {

        emailService.sendEmail(emailBody);

        return "Mail sent successfully!";
    }


}
