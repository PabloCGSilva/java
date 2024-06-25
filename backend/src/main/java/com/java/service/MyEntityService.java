package com.java.service;

import com.java.entities.MyEntity;
import com.java.repository.AlternativeMyEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyEntityService {

    private final AlternativeMyEntityRepository myEntityRepository;

    @Autowired
    public MyEntityService(AlternativeMyEntityRepository myEntityRepository) {
        this.myEntityRepository = myEntityRepository;
    }

    public MyEntity getMyEntityById(Long id) {
        return myEntityRepository.findById(id).orElse(null);
    }

    public List<MyEntity> getAllMyEntities() {
        return myEntityRepository.findAll();
    }

    public MyEntity createMyEntity(String name, String description) {
        MyEntity entity = new MyEntity();
        entity.setName(name);
        entity.setDescription(description);
        return myEntityRepository.save(entity);
    }

    public MyEntity updateMyEntity(Long id, String name, String description) {
        MyEntity entity = myEntityRepository.findById(id).orElse(null);
        if (entity != null) {
            entity.setName(name);
            entity.setDescription(description);
            return myEntityRepository.save(entity);
        }
        return null; // Handle error or throw exception
    }

    public boolean deleteMyEntity(Long id) {
        myEntityRepository.deleteById(id);
        return true;
    }
}
