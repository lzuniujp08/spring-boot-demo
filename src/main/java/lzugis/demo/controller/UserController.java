package lzugis.demo.controller;

import lzugis.demo.entity.User;
import lzugis.demo.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
    public List<User> getUserByName(String name) {
        List<User> users = this.userService.getUserByName(name);
        return users;
    }

  @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST} )
  @ResponseBody
  public List<User> getUsersList() {
    List<User> users = this.userService.getUsersList();
    return users;
  }

    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public String addUser(String username, String password) {
        try {
            this.userService.addUser(username, password);
            return username + " add succcess";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

  @RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST} )
  @ResponseBody
  public String deleteUser(Integer id) {
    try {
      this.userService.deleteUser(id);
      return id + " delete succcess";
    } catch (Exception e) {
      return e.getMessage();
    }
  }

  @RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public String updateUser(Integer id, String username, String password) {
        try {
            this.userService.updateUser(id, username, password);
            return id + " update succcess";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
