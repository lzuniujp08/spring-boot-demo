package lzugis.demo.service.impl;

import io.swagger.models.auth.In;
import lzugis.demo.dao.UserDao;
import lzugis.demo.entity.User;
import org.springframework.stereotype.Service;
import lzugis.demo.service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: pnunu
 * @Date: 2019/2/18 16:54
 * @Description:
 */
@Service("userService")
public class UserServiceImpl implements UserService {
  @Resource
  private UserDao userDao;

  @Override
  public User getUserById(int id) {
    return userDao.getUserById(id);
  }

  @Override
  public List<User> getUserByName(String name) {
    return userDao.getUserByName(name);
  }

  @Override
  public List<User> getUsersList() {
    return userDao.getUsersList();
  }

  @Override
  public void addUser(String username, String password) {
    userDao.addUser(username, password);
  }

  @Override
  public void deleteUser(Integer id) {
    userDao.deleteUser(id);
  }

  @Override
  public void updateUser(Integer id, String username, String password) {
    userDao.updateUser(id, username, password);
  }
}
