package v4.b2c.java_learn_v2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @GetMapping("/greeting/{name}")
    public String greeting(@PathVariable String name) {
        return String.format("Hello, %s!", name);
    }
}
