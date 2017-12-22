package com.service;

        import com.entity.Folder;
        import com.entity.SharingFolder;
        import com.entity.Users;
        import com.repository.CreateDirectoryService;
        import com.repository.DropBoxUsers;
        import com.repository.FolderRepository;
        import com.repository.Sharing;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;

@Service
public class UpdateStarService {


    @Autowired
    private FolderRepository folderRepository;

    public void updatestar (Folder F){

        System.out.println("Inside Update Star "+F);

        folderRepository.save(F);
    }}


