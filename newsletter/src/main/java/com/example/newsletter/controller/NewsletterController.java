package com.example.newsletter.controller;

import com.example.newsletter.model.Subscriber;
import com.example.newsletter.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class NewsletterController {

    @Autowired
    private SubscriberRepository subscriberRepository;

    @CrossOrigin(origins = "http://127.0.0.1:5502")
    @PostMapping("/newsletter")
    public ResponseEntity<String> subscribe(@RequestBody Subscriber request) {
        subscriberRepository.save(request);
        return new ResponseEntity<>("Subscription successful!", HttpStatus.OK);
    }
}


