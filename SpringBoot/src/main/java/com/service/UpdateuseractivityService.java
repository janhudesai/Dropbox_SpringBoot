package com.service;

        import com.entity.Folder;
        import com.entity.SharingFolder;
        import com.entity.Users;
        import com.repository.CreateDirectoryService;
        import com.repository.DropBoxUsers;
        import com.repository.Sharing;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;

@Service
public class UpdateuseractivityService {


    @Autowired
    private DropBoxUsers dropBoxUsers;

    public void updateactivity (Users F){

        System.out.println("Inside Update User Activities"+F);
        dropBoxUsers.save(F);

    }}

