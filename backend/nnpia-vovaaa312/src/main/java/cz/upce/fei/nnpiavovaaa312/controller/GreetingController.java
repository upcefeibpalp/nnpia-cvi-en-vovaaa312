package cz.upce.fei.nnpiavovaaa312.controller;

import cz.upce.fei.nnpiavovaaa312.service.GreetingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class GreetingController {
    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greeting")
    public String sayGreeting() {
        return greetingService.sayGreeting();
    }

    @GetMapping("/greeting/{name}")
    public String sayGreeting(
            @PathVariable String name
    ) {
        return greetingService.sayGreeting(name);
    }
}

