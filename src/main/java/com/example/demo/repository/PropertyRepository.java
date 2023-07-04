package com.example.demo.repository;

import com.example.demo.entity.PropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface PropertyRepository extends CrudRepository<PropertyEntity, Long> {
}
