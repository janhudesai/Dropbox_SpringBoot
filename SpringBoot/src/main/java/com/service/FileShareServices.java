
package com.service;

        import com.entity.Files;
        import com.entity.SharingFolder;
        import com.repository.FileRepository;
        import com.repository.Sharing;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;

@Service
public class FileShareServices {


    @Autowired
    private FileRepository fileRepository;

    public void fileShare (Files F){

        System.out.println("Inside Create Share directory"+F);
        System.out.println("Inside Create Share directory - userid"+F.getUserid());

        fileRepository.save(F);

    }}



