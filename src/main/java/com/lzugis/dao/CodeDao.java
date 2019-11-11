package com.lzugis.dao;

import com.lzugis.entity.Code;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CodeDao {
    Code getCodeById(@Param("id") Integer id);
    List<Code> getCodesList();
    void addCode(@Param("pid") Integer pid, @Param("name") String name, @Param("code") String code);
    void deleteCode(@Param("id") Integer id);
    void updateCode(@Param("id") Integer id, @Param("name") String name, @Param("code") String code);
}
