package v4.b2c.java_learn_v2.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users-example")
class UserExampleController {

    private List<String> users = new ArrayList<>();

    @PostMapping
    public String createUser(@RequestBody String user) {
        users.add(user);
        return "User created: " + user;
    }

    @GetMapping
    public List<String> getAllUsers() {
        return users;
    }

    @DeleteMapping("/{name}")
    public String deleteUser(@PathVariable String name) {
        users.remove(name);
        return "User deleted: " + name;
    }
}
