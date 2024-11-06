package com.ecommerce.project.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
        // file names of current / original file
        String originalFileName= file.getOriginalFilename();

        // generate a unique file name by UUID
        String randomId = UUID.randomUUID().toString();

        //mat.jpj -->1234-->new file name is 1234.jpj  //1234 randomid
        String fileName= randomId.concat(originalFileName
                .substring(originalFileName.lastIndexOf('.')));
        String filePath =  path + File.separator + fileName;
        // path + "/" +fileName--> it can be used but it not supports on  all operting system

        //check if path exist and create
        File folder = new File(path);
        if(!folder .exists())
            folder.mkdir();

        //upload to server
        Files.copy(file.getInputStream(), Paths.get(filePath));

        // returning file name
        return fileName;
    }

}
