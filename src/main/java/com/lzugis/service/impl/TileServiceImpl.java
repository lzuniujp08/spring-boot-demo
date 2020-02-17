package com.lzugis.service.impl;

import com.lzugis.dao.TileDao;
import com.lzugis.service.TileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: lzugis
 * @Date: 2019/2/18 16:54
 * @Description:
 */
@Service("tileService")
public class TileServiceImpl implements TileService {
  @Resource
  private TileDao tileDao;

  @Override
  public byte[] getTile(int x, int y, int z) {
    return tileDao.getTile(x, y, z);
  }

}
