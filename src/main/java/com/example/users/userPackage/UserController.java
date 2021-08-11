package com.example.users.userPackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("")
    public List<User> listOfUsers() throws InterruptedException, ExecutionException {

        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable String id) throws InterruptedException, ExecutionException {

        return userService.getUser(id);
    }

    @PostMapping("")
    public void addUser(@RequestBody User user) throws ExecutionException, InterruptedException {

        userService.addUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {

        userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable String id, @RequestBody User user) throws ExecutionException, InterruptedException {

        userService.updateUser(id, user);
    }
}
