package com.service;
import com.entity.Files;
import com.entity.Users;
import com.repository.DropBoxUsers;
import com.repository.FileRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;

@Service
public class LoginService {

    @Autowired
    private DropBoxUsers dropBoxUsers;

    public List<Users> findByuserid (String userid){
        System.out.println("userid:- inside file services"+userid);
        System.out.println("userid:"+userid);
        //System.out.println("jay desai:"+fileRepository.findByuserid(userid));
        return dropBoxUsers.findByuserid(userid);
    }
}
