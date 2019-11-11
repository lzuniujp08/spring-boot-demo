package com.lzugis.service;

import com.lzugis.entity.Code;
import io.swagger.models.auth.In;

import java.util.List;

public interface CodeService {
    Code getCodeById(int id);
    List<Code> getCodesList();
    void addCode(Integer pid, String name, String code);
    void deleteCode(Integer id);
    void updateCode(Integer id, String name, String code);
}
