package com.repository;

import com.entity.Folder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FolderRepository extends CrudRepository<Folder, Long>{
    List<Folder> findByuserid (String userid);

    List<Folder> findByUseridAndParentfolder (String userid,String parentid);
}
