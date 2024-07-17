package com.example.newsletter.controller;

import com.example.newsletter.model.Subscriber;
import com.example.newsletter.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/newsletter")
public class NewsletterController {

    @Autowired
    private SubscriberRepository subscriberRepository;

    @PostMapping
    public String addSubscriber(@RequestParam("name") String name, @RequestParam("email") String email) {
        Subscriber subscriber = new Subscriber(name, email);
        subscriberRepository.save(subscriber);
        return "redirect:/thankyou.html";
    }
}


