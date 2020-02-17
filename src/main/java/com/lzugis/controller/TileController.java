package com.lzugis.controller;

import com.lzugis.service.TileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/tile")
public class TileController {
  @Autowired
  private TileService tileService;

  @RequestMapping(value = "/vec", method = {RequestMethod.GET, RequestMethod.POST} )
  @ResponseBody
  public byte[] getCodeById(int x, int y, int z) {
    byte[] res = this.tileService.getTile(x, y, z);
    return res;
  }
}
