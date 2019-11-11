package com.lzugis.controller;

import com.lzugis.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileService fileService;

  @RequestMapping(value = "/upload", method = {RequestMethod.POST} )
  @ResponseBody
  public List uploadFile(MultipartFile file) {
    List datas = this.fileService.uploadFile(file);
    return datas;
  }
}
