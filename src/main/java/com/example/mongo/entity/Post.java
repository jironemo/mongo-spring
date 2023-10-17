package com.example.mongo.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "posts")
@AllArgsConstructor
@Getter
public class Post {

    @Id
    String id;

    @DBRef
    User user;

    String content;

    public Post(User user, String content) {
        this.user = user;
        this.content = content;
    }
}
