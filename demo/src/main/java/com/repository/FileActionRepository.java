package com.repository;

import com.entity.FileEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository

public interface FileActionRepository extends CrudRepository<FileEntity, Long> {
    Iterable<FileEntity> findByEmail(String email);
    ArrayList<FileEntity> findByPath(String email);
}

