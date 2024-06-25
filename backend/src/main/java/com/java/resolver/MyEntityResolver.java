package com.java.resolver;

import java.util.List;

import org.springframework.stereotype.Component;

import com.java.entities.MyEntity;
import com.java.service.MyEntityService;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class MyEntityResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final MyEntityService myEntityService;

    public MyEntityResolver(MyEntityService myEntityService) {
        this.myEntityService = myEntityService;
    }

    public MyEntity getMyEntity(Long id) {
        return myEntityService.getMyEntityById(id);
    }

    public List<MyEntity> getAllMyEntities() {
        return myEntityService.getAllMyEntities();
    }

    public MyEntity createMyEntity(String name, String description) {
        return myEntityService.createMyEntity(name, description);
    }

    public MyEntity updateMyEntity(Long id, String name, String description) {
        return myEntityService.updateMyEntity(id, name, description);
    }

    public boolean deleteMyEntity(Long id) {
        return myEntityService.deleteMyEntity(id);
    }
}
