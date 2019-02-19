package lzugis.demo.dao;

import lzugis.demo.entity.User;

public interface UserDao {
    User selectByPrimaryKey(Integer id);
}
