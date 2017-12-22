package com.repository;

import com.entity.Files;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FileRepository extends CrudRepository<Files, Long> {
    List<Files> findByuserid (String userid);

    List<Files> findByUseridAndParentfolder (String userid,String parentid);
}
