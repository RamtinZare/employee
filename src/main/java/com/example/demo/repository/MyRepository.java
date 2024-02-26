package com.example.demo.repository;

import com.example.demo.entity.DataPerson;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyRepository extends CrudRepository<DataPerson, Long> {
}
