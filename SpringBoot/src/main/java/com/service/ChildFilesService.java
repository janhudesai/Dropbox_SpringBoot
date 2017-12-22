package com.service;
import com.entity.Files;
import com.repository.FileRepository;
import com.repository.FolderRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;

@Service
public class ChildFilesService {

    @Autowired
    private FileRepository fileRepository;

    public List<Files> findByUseridAndParentfolder (String userid, String parentid){
        System.out.println("Inside Child Files "+fileRepository.findByUseridAndParentfolder(userid,parentid) );
        return fileRepository.findByUseridAndParentfolder(userid,parentid);
    }
}
