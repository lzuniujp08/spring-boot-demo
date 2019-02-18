package pnunu.demo.dao;

import pnunu.demo.entity.User;

public interface UserDao {
    User selectByPrimaryKey(Integer id);
}
