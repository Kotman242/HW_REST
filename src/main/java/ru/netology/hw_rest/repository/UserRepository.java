package ru.netology.hw_rest.repository;

import org.springframework.stereotype.Repository;
import ru.netology.hw_rest.model.Authorities;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import static ru.netology.hw_rest.model.Authorities.*;

@Repository
public class UserRepository {

    private static final ConcurrentHashMap<String, String> storage = new ConcurrentHashMap<>();

    static {
        storage.put("Ivan", "555555");
        storage.put("Oleg", "11111");
        storage.put("Anna", "33333");
        storage.put("Olga", "44444");
        storage.put("Masha", "22222");
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (!storage.containsKey(user) ||
                !storage.get(user).equals(password)) return new ArrayList<>();
        return getAllAuthorities();
    }

    private List<Authorities> getAllAuthorities() {
        return List.of(READ, WRITE, DELETE);
    }

    public UserRepository() {
    }
}
