package ru.netology.springbootdemo.service;

import org.springframework.stereotype.Service;
import ru.netology.springbootdemo.exception.InvalidCredentials;
import ru.netology.springbootdemo.exception.UnauthorizedUser;
import ru.netology.springbootdemo.model.Authorities;
import ru.netology.springbootdemo.repository.UserRepository;

import java.util.List;
@Service
public class AuthorizationService {
    UserRepository userRepository;

    public List<Authorities> getAuthorities(String userName, String userPassword) {
        if (isEmpty(userName) || isEmpty(userPassword)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(userName, userPassword);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + userName);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
