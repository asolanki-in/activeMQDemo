package com.example.Publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    @Autowired
    ArtemisProducer producer;

    @GetMapping("/value/{text}")
    public String send(@PathVariable("text") String text) {
        producer.send(text);
        return "hello";
    }
}
