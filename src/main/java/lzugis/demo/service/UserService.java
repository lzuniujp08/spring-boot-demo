package lzugis.demo.service;

import lzugis.demo.entity.User;

import java.util.List;

public interface UserService {
    User getUserById(int id);
    List<User> getUserByName(String name);
    List<User> getUsersList();
    void addUser(String username, String password);
    void deleteUser(Integer id);
    void updateUser(Integer id, String username, String password);
}
