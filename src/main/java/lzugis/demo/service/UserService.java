package lzugis.demo.service;

import lzugis.demo.entity.User;

public interface UserService {
    User getUserById(int id);
    User getUserByName(String name);
}
