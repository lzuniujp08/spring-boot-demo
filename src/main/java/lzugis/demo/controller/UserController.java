package lzugis.demo.controller;

import lzugis.demo.entity.User;
import lzugis.demo.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/byId", method = {RequestMethod.GET, RequestMethod.POST} )
//    @RequestMapping(value = "/select")
    @ResponseBody
    public User getUserById(int id) {
        User user = this.userService.getUserById(id);
        return user;
    }

    @RequestMapping(value = "/byName", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public User getUserByName(@Param("name") String name) {
        User user = this.userService.getUserByName(name);
        return user;
    }
}
