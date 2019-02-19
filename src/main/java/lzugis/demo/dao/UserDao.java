package lzugis.demo.dao;

import lzugis.demo.entity.User;

public interface UserDao {
    User getUserById(Integer id);
    User getUserByName(String name);
}
