package com.lzugis.controller;

import com.lzugis.entity.Code;
import com.lzugis.entity.User;
import com.lzugis.service.CodeService;
import com.lzugis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/code")
public class CodeController {
    @Autowired
    private CodeService codeService;

    @RequestMapping(value = "/byId", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public Code getCodeById(int id) {
        Code code = this.codeService.getCodeById(id);
        return code;
    }

  @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST} )
  @ResponseBody
  public List<Code> getCodesList() {
    List<Code> codes = this.codeService.getCodesList();
    return codes;
  }

    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public String addCode(Integer pid, String name, String code) {
        try {
            this.codeService.addCode(pid, name, code);
            return name + " add succcess";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

  @RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST} )
  @ResponseBody
  public String deleteCode(Integer id) {
    try {
      this.codeService.deleteCode(id);
      return id + " delete succcess";
    } catch (Exception e) {
      return e.getMessage();
    }
  }

  @RequestMapping(value = "/update", method = {RequestMethod.GET, RequestMethod.POST} )
    @ResponseBody
    public String updateCode(Integer id, String name, String code) {
        try {
            this.codeService.updateCode(id, name, code);
            return id + " update succcess";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
