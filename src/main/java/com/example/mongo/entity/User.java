package com.example.mongo.entity;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="users")
@Getter
@Setter
public class User {

    @Id
    String id;
    @NotNull
    private String name;
    @NotNull
    private String age;
}
