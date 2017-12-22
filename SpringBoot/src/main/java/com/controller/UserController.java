package com.controller;

import com.entity.*;
import com.service.*;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.html.HTMLParagraphElement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Controller    // This means that this class is a Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path="/user") // This means URL's start with /demo (after Application path)
public class UserController {

    public String username;
    public String key;
    public String directorypath;
    public String[] share;
    public String filelocation;

    @Autowired
    private UserService userService;



    @Autowired
    private FileServices fileServices;

    @Autowired
    private LoginService loginService;

    @Autowired
    private SharingService sharingService;

    @Autowired
    private CreateDirectory createDirectory;

    @Autowired
    private FileUploadService fileUploadService;

    @Autowired
    private SignupService signupService;

    @Autowired
    private FolderServices folderService;

    @Autowired
    private ChildFoldersService childFoldersService;

    @Autowired
    private ChildFilesService childFilesService;

    @Autowired
    private CreateDirectoryShareService createDirectoryShareService;

    @Autowired
    private FileShareServices fileShareServices;

    @Autowired
    private UseractivityServices useractivityServices;

    @Autowired
    private UpdateuseractivityService updateuseractivityService;

    @Autowired
    private DeleteService deleteService;

    @Autowired
    private DeleteFiles deleteFiles;

    @Autowired
    private UpdateStarService updateStarService;

    @Autowired
    private UserActivities userActivities;




    @PostMapping(path="/add",consumes = MediaType.APPLICATION_JSON_VALUE) // Map ONLY POST Requests
    public  ResponseEntity<?> addNewUser (@RequestBody User user) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        userService.addUser(user);
        System.out.println("Saved");
        return new ResponseEntity(null,HttpStatus.CREATED);
    }

    @GetMapping(path="/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON with the users
        return userService.getAllUsers();
//        return userService.findbyid();
    }

    @PostMapping(path="/login",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody String user, HttpSession session)
    {
        System.out.println("Inside Login!!!");
        JSONObject jsonObject = new JSONObject(user);
        username = jsonObject.getString("username");
        session.setAttribute("name",jsonObject.getString("username"));
        if(loginService.findByuserid(username).isEmpty())
        {
            return new ResponseEntity(userService.login(jsonObject.getString("username"),jsonObject.getString("password")),HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity(userService.login(jsonObject.getString("username"),jsonObject.getString("password")),HttpStatus.OK);
        }

        //return new ResponseEntity(jsonObject,null,HttpStatus.OK);
    }

    // Jay Desai Method


    @PostMapping(path="/list",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> list(@RequestBody String user, HttpSession session)
    {
        JSONObject jsonObject = new JSONObject(user);

        return new ResponseEntity(folderService.findByuserid(username) ,HttpStatus.OK);
        //return new ResponseEntity(jsonObject,null,HttpStatus.OK);
    }

    @PostMapping(path="/listfiles",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listfiles(@RequestBody String user, HttpSession session)
    {
        JSONObject jsonObject = new JSONObject(user);
        return new ResponseEntity(fileServices.findByuserid(username) ,HttpStatus.OK);
        //return new ResponseEntity(jsonObject,null,HttpStatus.OK);
    }

    @PostMapping(path="/childlist",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> childlist(@RequestBody String user, HttpSession session)
    {
        JSONObject jsonObject = new JSONObject(user);
        System.out.println("Child Folders" + user);
        return new ResponseEntity(childFoldersService.findByUseridAndParentfolder(username,jsonObject.getString("parentid")) ,HttpStatus.OK);
       // return new ResponseEntity(jsonObject,null,HttpStatus.OK);
    }

    @PostMapping(path="/childfiles",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> childfiles(@RequestBody String user, HttpSession session)
    {
        JSONObject jsonObject = new JSONObject(user);
        System.out.println("Child Files" + user);
        return new ResponseEntity(childFilesService.findByUseridAndParentfolder(username,jsonObject.getString("parentid")) ,HttpStatus.OK);
        // return new ResponseEntity(jsonObject,null,HttpStatus.OK);
    }
//

    @PostMapping(path="/useractivity",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> useractivity(@RequestBody String user, HttpSession session)
    {
        //JSONObject jsonObject = new JSONObject(user);
        System.out.println("User Activities" + userActivities.findByuserid(username));

        return new ResponseEntity(userActivities.findByuserid(username) ,HttpStatus.OK);
         //return new ResponseEntity(jsonObject,null,HttpStatus.OK);
    }
    //activity

    @PostMapping(path="/activity",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> activity(@RequestBody String user, HttpSession session)
    {
        //JSONObject jsonObject = new JSONObject(user);
        //System.out.println("User Activities" + user);
        return new ResponseEntity(useractivityServices.findByuserid(username) ,HttpStatus.OK);
        //return new ResponseEntity(jsonObject,null,HttpStatus.OK);
    }

    @PostMapping(path="/delete",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@RequestBody String user, HttpSession session)
    {
        JSONObject jsonObject = new JSONObject(user);
        //"name":"ak5"}
        Folder f = new Folder();
        System.out.println(jsonObject.getString("name"));
        f.setFolderid(jsonObject.getString("name"));

        deleteService.delete(f);

       // return new ResponseEntity(useractivityServices.findByuserid(username) ,HttpStatus.OK);
        return new ResponseEntity(null,HttpStatus.CREATED);
    }

    //deleteFiles

    @PostMapping(path="/deletefile",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deletefile(@RequestBody String user, HttpSession session)
    {
        JSONObject jsonObject = new JSONObject(user);
        //"name":"ak5"}
        System.out.println(jsonObject.getString("name"));

        Files f = new Files();
        System.out.println(jsonObject.getString("name"));
        f.setFileid(jsonObject.getString("name"));

        deleteFiles.delete(f);

        // return new ResponseEntity(useractivityServices.findByuserid(username) ,HttpStatus.OK);
        return new ResponseEntity(null,HttpStatus.CREATED);
    }

    @PostMapping(path="/createdirectory",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createdirectory(@RequestBody String folder, HttpSession session)
    {
        JSONObject jsonObject = new JSONObject(folder);
        System.out.println("String Folder" + folder);
        //System.out.println("create directory method + jsonObject" + jsonObject);

        //key = jsonObject.getString("folder");
        //System.out.println("create directory method + key" + key);
        Folder f = new Folder();
        System.out.println(jsonObject.getString("folderid"));
        f.setFolderid(jsonObject.getString("folderid"));
        f.setName(jsonObject.getString("folderid"));
        f.setUserid(username);

        //f.setParentfolder(jsonObject.getString("id"));
        f.setDisplay("folder");
        directorypath= "F:\\LAB3\\" +jsonObject.getString("folderid") ;
        new File(directorypath).mkdir();

        createDirectory.createDirectory(f);

        return new ResponseEntity(null,HttpStatus.CREATED);
        //return new ResponseEntity(jsonObject,null,HttpStatus.OK);
    }

    @PostMapping(path="/fileupload",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> fileupload( @RequestPart("file") MultipartFile file, HttpSession session) throws IOException {
        System.out.println("Inside String File" );
        System.out.println("Multipart File"+file );
        //JSONObject jsonObject = new JSONObject(file);
        //System.out.println("String File" + file);

        if (!file.isEmpty()) {

            byte[] bytes = file.getBytes();
            directorypath= "F:\\LAB3\\"+file.getOriginalFilename();
            Path path = Paths.get(directorypath);
            java.nio.file.Files.write(path,bytes);


        }
        Files files=new Files();
        files.setFilename(file.getOriginalFilename());
        files.setFileid(file.getOriginalFilename());
        files.setUserid(username);
        files.setDisplay("file");

        fileUploadService.fileUpload(files);

        return new ResponseEntity(null,HttpStatus.CREATED);
        //return new ResponseEntity(jsonObject,null,HttpStatus.OK);
    }

    @PostMapping(value = "/logout")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> logout(HttpSession session) {
        System.out.println(session.getAttribute("name"));
        session.invalidate();
        return  new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(path="/signup",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> signup(@RequestBody String user, HttpSession session)
    {
        JSONObject jsonObject = new JSONObject(user);
        System.out.println("String Folder" + user);
        //System.out.println("create directory method + jsonObject" + jsonObject);


        Users f = new Users();
        //String Folder{"fname":"Jay","lname":"Desai","username":"jay@gmail.com","password":"jay7"}
        f.setUserid(jsonObject.getString("username"));
        f.setFname(jsonObject.getString("fname"));
        f.setLname(jsonObject.getString("lname"));
        f.setPassword(jsonObject.getString("password"));

        signupService.signup(f);



        return new ResponseEntity(null,HttpStatus.CREATED);
        //return new ResponseEntity(jsonObject,null,HttpStatus.OK);
    }
    //

    @PostMapping(path="/createdirectoryshare",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createdirectoryshare(@RequestBody String folder, HttpSession session)
    {
        JSONObject jsonObject = new JSONObject(folder);
        System.out.println("String Folder" + folder);
        //System.out.println("create directory method + jsonObject" + jsonObject);

        // {"folder":"nnkjsnv","members":"nishantb","flag":"new"}

        String Jay = jsonObject.getString("members");
        share = Jay.split(",");

        for(int i =0;i<share.length;i++)
        {
            Folder f = new Folder();
            f.setFolderid(jsonObject.getString("folder"));
            f.setName(jsonObject.getString("folder"));
            f.setUserid(share[i]);
            f.setDisplay("folder");
            createDirectoryShareService.createDirectory(f);

        }


        //f.setParentfolder(jsonObject.getString("id"));

        directorypath= "F:\\LAB3\\temp\\" +jsonObject.getString("folder") ;
        new File(directorypath).mkdir();



        return new ResponseEntity(null,HttpStatus.CREATED);
        //return new ResponseEntity(jsonObject,null,HttpStatus.OK);
    }

    //

    @PostMapping(path="/fileshare",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> fileshare(@RequestBody String file, HttpSession session)
    {
        JSONObject jsonObject = new JSONObject(file);
        System.out.println("String Folder" + file);
        //System.out.println("create directory method + jsonObject" + jsonObject);

        //String Folder{"members":"jay@gmail.com","flag":"old"}

        String Jay = jsonObject.getString("members");
        share = Jay.split(",");
        //fileShareServices

        for(int i =0;i<share.length;i++)
        {
            Files f = new Files();
            f.setFileid(jsonObject.getString("folder"));
            f.setFilename(jsonObject.getString("folder"));
            f.setUserid(share[i]);
            f.setDisplay("file");
            fileShareServices.fileShare(f);


        }

        //f.setParentfolder(jsonObject.getString("id"));

        return new ResponseEntity(null,HttpStatus.CREATED);
        //return new ResponseEntity(jsonObject,null,HttpStatus.OK);
    }

    //

    @PostMapping(path="/updateuseractivity",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateuseractivity(@RequestBody String file, HttpSession session)
    {
        JSONObject jsonObject = new JSONObject(file);
        System.out.println("String Folder" + file);
        //System.out.println("create directory method + jsonObject" + jsonObject);

        //{"Email":"anuj@gmail.com","fname":"Anuj","lname":"Chaudhry","work":"Infosys LTD.","education":"San Jose State","contact":"12345","Show":"Friends","Sports":"Tennis"}

        //String Jay = jsonObject.getString("members");
        //share = Jay.split(",");
        //fileShareServices


            Users user = new Users();
            user.setWork(jsonObject.getString("work"));
            user.setEducation(jsonObject.getString("education"));
            user.setContact(jsonObject.getString("contact"));
            user.setSports(jsonObject.getString("Show"));
            user.setShows(jsonObject.getString("Sports"));
            //user.setMusic(jsonObject.getString("work"));
            user.setUserid(jsonObject.getString("Email"));
            user.setFname(jsonObject.getString("fname"));
        user.setLname(jsonObject.getString("lname"));
        updateuseractivityService.updateactivity(user);




        // updateuseractivityService

        //f.setParentfolder(jsonObject.getString("id"));

        return new ResponseEntity(null,HttpStatus.CREATED);
        //return new ResponseEntity(jsonObject,null,HttpStatus.OK);
    }

    @PostMapping(path="/updatestar",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updatestar(@RequestBody String folder, HttpSession session)
    {
        JSONObject jsonObject = new JSONObject(folder);
        System.out.println("String Update star Folder" + folder);
        //System.out.println("create directory method + jsonObject" + jsonObject);
        // {"name":"Sample1","value":"yes"}
        //key = jsonObject.getString("folder");
        //System.out.println("create directory method + key" + key);
        Folder f = new Folder();
//        System.out.println(jsonObject.getString("folderid"));
        f.setFolderid(jsonObject.getString("name"));
        f.setName(jsonObject.getString("name"));
        f.setUserid(username);
        f.setDisplay("folder");
        f.setStarred(jsonObject.getString("value"));
        updateStarService.updatestar(f);

        return new ResponseEntity(null,HttpStatus.CREATED);
        //return new ResponseEntity(jsonObject,null,HttpStatus.OK);
    }
    @PostMapping(path="/downloadFile",consumes = MediaType.APPLICATION_JSON_VALUE)
    public FileSystemResource downloadfile(@RequestBody String user, HttpSession session)
    {
        System.out.println("Download");
        JSONObject jsonObject = new JSONObject(user);
        String name = jsonObject.getString("name");
        filelocation =  "F:\\LAB3\\"+name;

        return new FileSystemResource(filelocation);
    }

    @GetMapping(path="/downloadFile",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody FileSystemResource filedownload() {
        return new FileSystemResource(filelocation);
    }
}