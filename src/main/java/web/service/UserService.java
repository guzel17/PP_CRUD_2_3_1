package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void add(User user);
    void delete(Long id);
    User getById(Long id);
    void update(Long id, User updatedUser);
}
