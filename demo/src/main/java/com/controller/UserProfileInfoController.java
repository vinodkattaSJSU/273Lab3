package com.controller;


import com.entity.UserProfileInfoEntity;
import com.repository.UserProfileInfoRepo;
import com.service.UserProfileInfoService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/userprofile")
public class UserProfileInfoController {

@Autowired
    public UserProfileInfoService up;
@Autowired
    public UserProfileInfoRepo p;

    @PostMapping(path="/profile",consumes = MediaType.APPLICATION_JSON_VALUE) // Map ONLY POST Requests
    public @ResponseBody
    ResponseEntity<?> profile (@RequestBody String details, HttpSession session ) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        //Getting all the files with that username

         JSONObject jsonObject = new JSONObject(details);
//JSONObject jsonObject=new JSONObject(jsonObject1.get("details"));
System.out.println(jsonObject);
//System.out.println(jsonObject1.get("details"));


         UserProfileInfoEntity profileentity=new UserProfileInfoEntity();
         System.out.println(jsonObject);
        profileentity.setContact(jsonObject.getInt("contact"));
        profileentity.setEducation(jsonObject.getString("education"));
        profileentity.setHobies(jsonObject.getString("hobies"));
        profileentity.setOverview(jsonObject.getString("overview"));
        profileentity.setWork(jsonObject.getString("work"));
        profileentity.setUsername(session.getAttribute("name").toString());
        System.out.println(profileentity);
        //p.save(profileentity);

        up.save(profileentity);
        return new ResponseEntity(null, HttpStatus.CREATED);
    }





//    @GetMapping(path="/grouplist",produces = MediaType.APPLICATION_JSON_VALUE)
//    public @ResponseBody
//    UserProfileInfoEntity getData(HttpSession session) {
//        // This returns a JSON with the users
//System.out.println("inside grouplist");
//        return up.getData(session.getAttribute("name").toString());
//
//    }















}
