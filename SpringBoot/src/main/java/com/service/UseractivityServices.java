package com.service;

        import com.entity.Folder;
        import com.entity.Users;
        import com.repository.DropBoxUsers;
        import com.repository.FolderRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;

@Service
public class UseractivityServices {

    @Autowired
    private DropBoxUsers dropBoxUsers;

    public List<Users> findByuserid (String userid){
        System.out.println("userid:"+userid);
        System.out.println("jay desai:"+dropBoxUsers.findByuserid(userid));
        return dropBoxUsers.findByuserid(userid);
    }
}
