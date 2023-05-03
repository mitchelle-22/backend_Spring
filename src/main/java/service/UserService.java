package service;

import org.springframework.stereotype.Component;

import entity.User;

@Component
public interface UserService {
    public User getUser(User user);

    public User insertIntoDatabase(User user);
}
