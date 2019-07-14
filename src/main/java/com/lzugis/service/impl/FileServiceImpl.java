package com.lzugis.service.impl;

import com.lzugis.service.FileService;
import com.lzugis.utils.TxtUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lzugis
 * @Date: 2019/2/18 16:54
 * @Description:
 */
@Service("fileService")
public class FileServiceImpl implements FileService {
  private TxtUtil txtUtil = new TxtUtil();

  @Override
  public List uploadFile(MultipartFile file) {
    List list = new ArrayList();
    if (!file.isEmpty()) {
      String fileName = file.getOriginalFilename();
      String filePath = "C:\\Users\\lzuni\\Desktop\\temp\\";
      File dest = new File(filePath + fileName);
      try {
        file.transferTo(dest);
        list = txtUtil.readCsvFile(dest);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return list;
  }
}
