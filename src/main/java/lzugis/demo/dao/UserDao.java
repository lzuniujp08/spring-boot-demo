package lzugis.demo.dao;

import lzugis.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface UserDao {
    User getUserById(Integer id);
    List<User> getUserByName(@Param("name") String name);
}
