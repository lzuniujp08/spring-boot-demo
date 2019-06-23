package com.lzugis.controller;

import com.lzugis.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/data")
public class DataController {
    @Autowired
    private DataService dataService;

  @RequestMapping(value = "/capital/list", method = {RequestMethod.GET, RequestMethod.POST} )
  @ResponseBody
  public List getCapitalList() {
    List capitals = this.dataService.getCapitalList();
    return capitals;
  }
}
