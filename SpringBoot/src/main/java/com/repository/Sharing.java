package com.repository;

import com.entity.SharingFolder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

public interface Sharing extends CrudRepository<SharingFolder, Long> {

}

