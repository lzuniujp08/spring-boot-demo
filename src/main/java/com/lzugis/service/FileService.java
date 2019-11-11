package com.lzugis.service;


import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {
    List uploadFile(MultipartFile file);
}
