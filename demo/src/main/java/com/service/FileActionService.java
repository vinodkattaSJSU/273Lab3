package com.service;
import com.entity.FileEntity;
import com.repository.FileActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class  FileActionService {


@Autowired
public FileActionRepository fileRepository;

public void save(FileEntity file1){
        fileRepository.save(file1);
    }

    public Iterable<FileEntity> getData(String email){
        return fileRepository.findByEmail(email);
    }

    public ArrayList<FileEntity> getDeleteFile(String path)
{
return fileRepository.findByPath(path);
}

public void deleteFile(FileEntity f)
{
    fileRepository.delete(f);
}

// public void updateStar(FileEntity f)
// {
//   fileRepository.save(f);
// }

}
