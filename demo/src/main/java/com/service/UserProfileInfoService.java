package com.service;

import com.entity.UserProfileInfoEntity;
import com.repository.UserProfileInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileInfoService {

    @Autowired
    public UserProfileInfoRepo up;

    public void save(UserProfileInfoEntity ent)
    {
        up.save(ent);
    }

    public UserProfileInfoEntity getData(String email)
    {

        return up.findByEmail(email);
    }

}
//package com.service;
//
//        import com.com.entity.UserProfileInfoEntity;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.stereotype.Service;
//
//@Service
//public class UserProfileInfoRepo
//{
//    @Autowired
//    private com.com.repository.UserProfileInfoRepo uprofile;
//
//    public void save(UserProfileInfoEntity up)
//    {
//        uprofile.save(up);
//    }
//
//}