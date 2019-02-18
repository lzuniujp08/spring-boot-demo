package pnunu.demo.service.impl;

import org.springframework.stereotype.Service;
import pnunu.demo.dao.UserDao;
import pnunu.demo.entity.User;
import pnunu.demo.service.UserService;

import javax.annotation.Resource;

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
    public User getUserById(int userId) {
        return userDao.selectByPrimaryKey(userId);
    }
}
