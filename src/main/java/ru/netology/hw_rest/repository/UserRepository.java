package ru.netology.hw_rest.repository;

import org.springframework.stereotype.Repository;
import ru.netology.hw_rest.model.Authorities;
import ru.netology.hw_rest.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static ru.netology.hw_rest.model.Authorities.*;

@Repository
public class UserRepository {

    private static final CopyOnWriteArrayList<User> storage = new CopyOnWriteArrayList<>();

    static {

        storage.add(new User("Ivan", "555555"));
        storage.add(new User("Oleg", "11111"));
        storage.add(new User("Anna", "33333"));
        storage.add(new User("Olga", "44444"));
        storage.add(new User("Masha", "22222"));
    }

    public List<Authorities> getUserAuthorities(User user) {
        if (!storage.contains(user)) return new ArrayList<>();
        return getAllAuthorities();
    }

    private List<Authorities> getAllAuthorities() {
        return List.of(READ, WRITE, DELETE);
    }

    public UserRepository() {
    }
}
