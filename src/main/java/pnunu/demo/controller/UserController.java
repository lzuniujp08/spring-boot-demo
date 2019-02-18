package pnunu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pnunu.demo.entity.User;
import pnunu.demo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    @ResponseBody
    public User toIndex(int userId) {
        User user = this.userService.getUserById(userId);
        return user;
    }
}
