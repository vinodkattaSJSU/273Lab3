package com.repository;


import com.entity.UserProfileInfoEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserProfileInfoRepo extends CrudRepository<UserProfileInfoEntity, Long> {


    UserProfileInfoEntity findByEmail(String email);
}
