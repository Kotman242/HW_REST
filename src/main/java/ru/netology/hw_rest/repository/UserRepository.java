package ru.netology.hw_rest.repository;

import org.springframework.stereotype.Repository;
import ru.netology.hw_rest.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import static ru.netology.hw_rest.model.Authorities.*;

@Repository
public class UserRepository {

    private static final CopyOnWriteArrayList<User> storage = new CopyOnWriteArrayList<>();

    static {

        storage.add(new User("Ivan", "11111"));
        storage.add(new User("Admin", "22222",READ,WRITE,DELETE));
    }

    public List<Authorities> getUserAuthorities(User user) {
        if (!storage.contains(user)) return new ArrayList<>();
        user=storage.get(storage.indexOf(user));
        return Arrays.asList(user.getAuthorities());
    }


    public UserRepository() {
    }
}
