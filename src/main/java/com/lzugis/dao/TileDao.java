package com.lzugis.dao;

import org.apache.ibatis.annotations.Param;


public interface TileDao {
    byte[] getTile(@Param("x") Integer x, @Param("y") Integer y, @Param("z") Integer z);
}
