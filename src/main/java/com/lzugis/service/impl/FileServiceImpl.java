package com.lzugis.service.impl;

import com.lzugis.service.FileService;
import com.lzugis.utils.ExcelUtil;
import com.lzugis.utils.TxtUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: lzugis
 * @Date: 2019/2/18 16:54
 * @Description:
 */
@Service("fileService")
public class FileServiceImpl implements FileService {
  private TxtUtil txtUtil = new TxtUtil();
  private ExcelUtil excelUtil = new ExcelUtil();

  @Override
  public List uploadFile(MultipartFile file) {
    List list = new ArrayList();
    if (!file.isEmpty()) {
      String fileName = file.getOriginalFilename();
      String[] fileInfo = fileName.split("\\.");
      String filePath = "C:\\Users\\lzuni\\Desktop\\temp\\";
      String destFile = filePath + fileInfo[0] + new Date().getTime() + "." + fileInfo[1];
      File dest = new File(destFile);
      try {
        file.transferTo(dest);
        if (fileInfo[1].indexOf("xls") !=-1) {// excel文件
          list = excelUtil.getFileContent(dest);
        }
        else if ("csv,txt".indexOf(fileInfo[1]) !=-1) {//txt或csv文件
          list = txtUtil.getFileContent(dest);
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return list;
  }
}
