package com.service;

        import com.entity.Folder;
        import com.entity.SharingFolder;
        import com.repository.CreateDirectoryService;
        import com.repository.Sharing;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;

@Service
public class CreateDirectoryShareService {


    @Autowired
    private CreateDirectoryService directory;

    public void createDirectory (Folder F){

        System.out.println("Inside Create Share directory"+F);
        System.out.println("Inside Create Share directory - userid"+F.getUserid());

        directory.save(F);

    }}


