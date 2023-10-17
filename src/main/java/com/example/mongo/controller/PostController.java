package com.example.mongo.controller;


import com.example.mongo.entity.Post;
import com.example.mongo.repository.PostRepository;
import com.example.mongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {


    @Autowired
    PostRepository postRepository;
    @Autowired
    UserRepository userRepository;

    @PostMapping("/create")
    public String createPost(@RequestParam String userId, @RequestBody String content){
        Post post = new Post(userRepository.findById(userId).get(),content);
        postRepository.save(post);
        return post.getUser().getName();
    }

}
