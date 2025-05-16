package org.example.task_11;

import java.util.Objects;

class Person {
    private String name;

    public void setName(String name) {
        this.name = Objects.requireNonNull(name, "Имя не может быть null");
    }
}

public class Main {
    public String findUserInDatabase(String username) {
        return null;
    }

    public void login(String username) {
        String currentUser = findUserInDatabase(username);
        assert currentUser != null : "Пользователь " + username + " должен существовать";

        // дальше идёт код где currentUser вообще null быть не может и мы просто тут проверили возможную ошибку в БД
    }
}
