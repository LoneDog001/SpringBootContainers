package ru.netology.springbootdemo.person;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@Getter
@ToString
@EqualsAndHashCode
@Setter
@Validated
@AllArgsConstructor
public class User {
    @NotBlank(message = "Имя пользователя должно содержать символы")
    @Size(min = 2, max = 26, message = "Имя пользователя должно быть от 2 до 26 символов)")
    private String userName;
    @NotBlank(message = "Пароль должен содержать символы")
    @Size(min = 2, max = 26, message = "Пароль должен быть от 2 до 26 символов)")
    private String userPassword;

    public User() {
    }
}

