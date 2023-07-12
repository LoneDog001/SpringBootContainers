package ru.netology.springbootdemo.repository;

import org.springframework.stereotype.Repository;
import ru.netology.springbootdemo.model.Authorities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private final ConcurrentHashMap<String, List<Authorities>> authorities;

    public UserRepository() {
        this.authorities = new ConcurrentHashMap<>();

        this.authorities.put("Admin", List.of(Authorities.values()));
        this.authorities.put("User", List.of(Authorities.READ));
    }

    public List<Authorities> getUserAuthorities(String userName, String userPassword) {
        if (!userName.isEmpty() && !userPassword.isEmpty()){
            return authorities.getOrDefault(userName, Collections.emptyList());
        }
        return Collections.emptyList();
    }
}
