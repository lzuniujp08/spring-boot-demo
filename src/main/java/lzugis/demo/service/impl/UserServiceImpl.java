package lzugis.demo.service.impl;

import lzugis.demo.dao.UserDao;
import lzugis.demo.entity.User;
import org.springframework.stereotype.Service;
import lzugis.demo.service.UserService;

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
