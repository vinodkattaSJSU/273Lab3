package com.repository;

import com.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository

public interface UserActionRepository extends CrudRepository<UserEntity, Long> {
    List<UserEntity> findByEmailAndPassword(String username, String password);
}

//
//public interface fileRepository extends CrudRepository<FileEntity, Long> {
//    List<UserEntity> findByEmailAndPassword(String username, String password);
//}