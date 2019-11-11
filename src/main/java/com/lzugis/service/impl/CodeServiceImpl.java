package com.lzugis.service.impl;

import com.lzugis.dao.CodeDao;
import com.lzugis.entity.Code;
import com.lzugis.service.CodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: lzugis
 * @Date: 2019/2/18 16:54
 * @Description:
 */
@Service("codeService")
public class CodeServiceImpl implements CodeService {
  @Resource
  private CodeDao codeDao;

  @Override
  public Code getCodeById(int id) {
    return codeDao.getCodeById(id);
  }


  @Override
  public List<Code> getCodesList() {
    return codeDao.getCodesList();
  }

  @Override
  public void addCode(Integer pid, String username, String password) {
    codeDao.addCode(pid, username, password);
  }

  @Override
  public void deleteCode(Integer id) {
    codeDao.deleteCode(id);
  }

  @Override
  public void updateCode(Integer id, String name, String code) {
    codeDao.updateCode(id, name, code);
  }
}
