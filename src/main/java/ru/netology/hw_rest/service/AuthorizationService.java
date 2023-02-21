package ru.netology.hw_rest.service;

import org.springframework.stereotype.Service;
import ru.netology.hw_rest.exceptions.UnauthorizedUser;
import ru.netology.hw_rest.model.Authorities;
import ru.netology.hw_rest.model.User;
import ru.netology.hw_rest.repository.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }


}