package com.controller;
import com.entity.FileEntity;
import com.service.FileActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpSession;
import java.util.Iterator;


@Controller    // This means that this class is a Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path="/file") // This means URL's start with /demo (after Application path)
public class FileActionController {

    @Autowired
    private FileActionService fservice;


    @GetMapping(path="/display",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Iterable<FileEntity> getAllFiles(HttpSession session) {
        // This returns a JSON with the users
        return fservice.getData(session.getAttribute("name").toString());
    }


    @PostMapping(path="/sfile",consumes = MediaType.APPLICATION_JSON_VALUE) // Map ONLY POST Requests
    public @ResponseBody String sfile (@RequestBody String path,HttpSession session ) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
//Getting all the files with that username
        Iterable<FileEntity> f= fservice.getData(session.getAttribute("name").toString());
        Iterator<FileEntity>f2=f.iterator();
        while(f2.hasNext())
        {
            FileEntity kl = f2.next();
            String k=kl.getPath();
            k='"'+k+'"';
            String kj=path;
            if(k.equals(kj))
            {
                fservice.save(kl);
            }
        }
        return "201";
    }



    @PostMapping(path="/sharefile") // Map ONLY POST Requests
    public @ResponseBody ResponseEntity<?> sharefile (@RequestBody String input,  HttpSession session ) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        //Getting all the files with that username


        input=input.substring(1,input.length()-1);
        System.out.println(input);
        String [] inputdata=input.split("&");
        String path=inputdata[0];
        String otheruser=inputdata[1];
        //System.out.println(otheruser);
        Iterable<FileEntity> f= fservice.getData(session.getAttribute("name").toString());
        Iterator<FileEntity>f2=f.iterator();
        FileEntity sharef=new FileEntity();
        //sharef.setStar("No");
        sharef.setPath(path);
        sharef.setDeletefile("No");
        //sharef.setIsdirectory("No");
        sharef.setEmail(otheruser);
        //sharef.setDname("");
        fservice.save(sharef);
        return new ResponseEntity(null, HttpStatus.CREATED);
    }


//    @PostMapping(path = "/createDirectory",consumes = MediaType.APPLICATION_JSON_VALUE) // Map ONLY POST Requests
//    public @ResponseBody  String createD(@RequestBody String path, HttpSession session) {
//        // @ResponseBody means the returned String is the response, not a view name
//        // @RequestParam means it is a parameter from the GET or POST request
//        // userService.addUser(user);
//        //System.out.println("saasd");
//        FileEntity f=new FileEntity();
//        f.setEmail(session.getAttribute("name").toString());
//        f.setIsdirectory("yes");
//        f.setDeletefile("yes");
//        f.setStar("No");
//        f.setDname("normal");
//        f.setPath(path.substring(1,path.length()-1));
//        fservice.save(f);
//        return "201";
//    }

    @PostMapping(path="/delete",consumes = MediaType.APPLICATION_JSON_VALUE) // Map ONLY POST Requests
    public @ResponseBody String deletefile (@RequestBody String path,HttpSession session ) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        //Getting all the files with that username
        Iterable<FileEntity> f= fservice.getData(session.getAttribute("name").toString());
        Iterator<FileEntity>f2=f.iterator();
        while(f2.hasNext())
            {
                FileEntity kl = f2.next();
                String k=kl.getPath();
                k='"'+k+'"';
                String kj=path;
              if(k.equals(kj))
                 {
                     fservice.deleteFile(kl);
                 }
           }
        return "201";
    }


    @PostMapping(path = "/add") // Map ONLY POST Requests
    public @ResponseBody  ResponseEntity<?> addNewUser(
            @RequestParam(name="mypic") MultipartFile uploadfile, HttpSession session) {
        // ,@RequestParam(name="dname") String dname
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        // userService.addUser(user);
        String Path="C:\\sanjay\\273\\DEMOS\\SpringBootDemoCode\\front-end\\public";
        System.out.println(session.getAttribute("name"));
        String email=session.getAttribute("name").toString();
        // System.out.println("saasd");
        Path=Path+'\\'+uploadfile.getOriginalFilename();

        FileEntity f=new FileEntity();
        f.setEmail(email);
        f.setDeletefile("yes");
//f.setIsdirectory("No");
        f.setPath(uploadfile.getOriginalFilename());
//f.setStar("No");
//f.setDname(dname);
System.out.println("asddsa");
//System.out.println(f.getDname());

          fservice.save(f);
        return new ResponseEntity(null, HttpStatus.CREATED);
    }
}