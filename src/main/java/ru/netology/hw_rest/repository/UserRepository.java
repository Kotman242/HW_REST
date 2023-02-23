package ru.netology.hw_rest.repository;

import org.springframework.stereotype.Repository;
import ru.netology.hw_rest.model.Authorities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import static ru.netology.hw_rest.model.Authorities.*;

@Repository
public class UserRepository {

    private static final ConcurrentHashMap<String, HashMap<String, Authorities[]>> storage = new ConcurrentHashMap<>();

    static {
        storage.put("Admin", new HashMap<>());
        storage.get("Admin").put("55555", new Authorities[]{WRITE, READ, DELETE});
        storage.put("Oleg", new HashMap<>());
        storage.get("Oleg").put("11111", new Authorities[]{WRITE, READ});
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        HashMap<String, Authorities[]> result = storage.get(user);
        if (result == null) return new ArrayList<>();
        Authorities[] authorities = result.get(password);
        if (authorities == null) return new ArrayList<>();
        return Arrays.asList(authorities);
    }


    public UserRepository() {
    }
}
