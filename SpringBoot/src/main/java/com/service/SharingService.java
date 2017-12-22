package com.service;

import com.entity.SharingFolder;
import com.repository.Sharing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SharingService {


    @Autowired
    private Sharing sharing;

    public void sharing (SharingFolder F){

        System.out.println("Inside Sharing"+F);
        sharing.save(F);

}}

