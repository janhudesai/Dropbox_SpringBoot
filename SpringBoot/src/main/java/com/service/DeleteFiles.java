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
public class DeleteFiles {


    @Autowired
    private FileRepository fileRepository;

    public void delete (Files F){

        System.out.println("Delete Files"+F);

        fileRepository.delete(F);
    }}


