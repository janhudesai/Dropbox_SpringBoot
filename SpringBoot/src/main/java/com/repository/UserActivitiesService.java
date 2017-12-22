package com.repository;
import com.entity.Useractivites;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface UserActivitiesService extends CrudRepository<Useractivites, Long>{
        List<Useractivites> findByuserid (String userid);
}
