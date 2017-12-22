package com.repository;

import com.entity.Folder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

public interface CreateDirectoryService extends CrudRepository<Folder, Long>{
}
