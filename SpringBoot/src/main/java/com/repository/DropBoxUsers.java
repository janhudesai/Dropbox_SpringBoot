package com.repository;
import com.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface DropBoxUsers extends CrudRepository<Users, Long>{

    List<Users> findByuserid (String userid);
}
