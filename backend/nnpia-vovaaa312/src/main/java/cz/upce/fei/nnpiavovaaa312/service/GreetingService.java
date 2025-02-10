package cz.upce.fei.nnpiavovaaa312.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String sayGreeting(String name) {
        return "Hello, " + name;
    }
    public String sayGreeting() {
        return "Hello World";
    }
}
