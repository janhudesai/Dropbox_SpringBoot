

package com.service;

import com.entity.Files;
import com.entity.Folder;
import com.entity.SharingFolder;
import com.repository.CreateDirectoryService;
import com.repository.FileRepository;
import com.repository.Sharing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileUploadService {


    @Autowired
    private FileRepository fileRepository;

    public void fileUpload (Files F){

        System.out.println("Inside Upload File"+F);
        fileRepository.save(F);

    }}

