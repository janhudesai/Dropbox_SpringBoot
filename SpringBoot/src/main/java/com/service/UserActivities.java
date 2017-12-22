package com.service;

        import com.entity.Useractivites;
        import com.repository.UserActivitiesService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;

@Service
public class UserActivities {

    @Autowired
    private UserActivitiesService userActivitiesService;

    public List<Useractivites> findByuserid (String userid){
        System.out.println("userid:"+userid);
        //System.out.println("jay desai:"+folderRepository.findByuserid(userid));
        return userActivitiesService.findByuserid(userid);
    }

    public void saveactivity (UserActivities F){

        System.out.println("Inside Create directory"+F);
        userActivitiesService.save((Iterable<Useractivites>) F);

    }
}

