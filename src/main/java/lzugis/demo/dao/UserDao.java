package lzugis.demo.dao;

import lzugis.demo.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserDao {
    User getUserById(@Param("id")Integer id);
    List<User> getUserByName(@Param("name") String name);
    void addUser(@Param("username")String username, @Param("password")String password);
    void updateUser(@Param("id")Integer id,@Param("username")String username, @Param("password")String password);
}
