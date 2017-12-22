package com.service;

        import com.entity.Files;
        import com.entity.Folder;
        import com.entity.SharingFolder;
        import com.repository.CreateDirectoryService;
        import com.repository.FileRepository;
        import com.repository.FolderRepository;
        import com.repository.Sharing;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;

@Service
public class DeleteService {


    @Autowired
    private FolderRepository folderRepository;

    public void delete (Folder F){

        System.out.println("Delete Folder"+F);

        folderRepository.delete(F);
    }}

