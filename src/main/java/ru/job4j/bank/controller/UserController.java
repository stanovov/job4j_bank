package ru.job4j.bank.controller;

import org.springframework.web.bind.annotation.*;
import ru.job4j.bank.model.User;
import ru.job4j.bank.service.BankService;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private final BankService bankService;

    public UserController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping
    public User save(@RequestBody Map<String, String> body) {
        var user = new User(body.get("username"), body.get("password"));
        bankService.addUser(user);
        return user;
    }

    @GetMapping
    public User findByPassport(@RequestParam String password) {
        return bankService.findByPassport(password).orElse(null);
    }

}