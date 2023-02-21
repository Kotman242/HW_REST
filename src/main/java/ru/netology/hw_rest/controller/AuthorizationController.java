package ru.netology.hw_rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.hw_rest.annotation.ValidUser;
import ru.netology.hw_rest.model.Authorities;
import ru.netology.hw_rest.model.User;
import ru.netology.hw_rest.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@ValidUser User user) {
        return service.getAuthorities(user);
    }

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }
}

