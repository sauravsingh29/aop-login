package com.saurav.api;

import com.saurav.service.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class RandomApi {

    @Autowired
    private RandomString randomString;

    @GetMapping
    public String anyString() {
        return randomString.random();
    }

    @PostMapping
    public String add(@RequestBody Map<String, String> body) {
        randomString.add(body.get("name"));
        return "Added";
    }

    @GetMapping("/throw")
    public String throwMe() {
        randomString.logError();
        return "No Resp";
    }
}
