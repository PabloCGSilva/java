package com.java.repository;

import com.java.entities.MyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlternativeMyEntityRepository extends JpaRepository<MyEntity, Long> {
}
