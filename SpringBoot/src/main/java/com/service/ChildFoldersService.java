package com.service;

        import com.entity.Folder;
        import com.repository.FolderRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;

@Service
public class ChildFoldersService {

    @Autowired
    private FolderRepository folderRepository;

    public List<Folder> findByUseridAndParentfolder (String userid, String parentid){
        System.out.println("Inside Child Folders"+folderRepository.findByUseridAndParentfolder(userid,parentid) );
        return folderRepository.findByUseridAndParentfolder(userid,parentid);
    }
}
