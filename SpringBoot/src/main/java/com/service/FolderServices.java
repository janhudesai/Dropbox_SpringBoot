package com.service;

import com.entity.Folder;
import com.repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FolderServices {

    @Autowired
    private FolderRepository folderRepository;

    public List<Folder> findByuserid (String userid){
        System.out.println("userid:"+userid);
        System.out.println("jay desai:"+folderRepository.findByuserid(userid));
        return folderRepository.findByuserid(userid);
    }
}
