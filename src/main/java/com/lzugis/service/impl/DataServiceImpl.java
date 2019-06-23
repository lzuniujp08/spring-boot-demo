package com.lzugis.service.impl;

import com.lzugis.dao.DataDao;
import com.lzugis.service.DataService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: lzugis
 * @Date: 2019/2/18 16:54
 * @Description:
 */
@Service("dataService")
public class DataServiceImpl implements DataService {
  @Resource
  private DataDao dataDao;

  @Override
  public List getCapitalList() {
    return dataDao.getCapitalList();
  }
}
