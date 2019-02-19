package lzugis.demo.service;

import lzugis.demo.entity.User;

import java.util.List;

public interface UserService {
    User getUserById(int id);
    List<User> getUserByName(String name);
}
