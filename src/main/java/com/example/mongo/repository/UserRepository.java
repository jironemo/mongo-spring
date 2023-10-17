package com.example.mongo.repository;

import com.example.mongo.entity.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<User,String> {

    boolean existsByName(@NotNull String name);
}
