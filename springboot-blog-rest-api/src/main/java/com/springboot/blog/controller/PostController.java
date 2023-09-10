package com.springboot.blog.controller;

import com.springboot.blog.payload.PostDto;
import com.springboot.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// controller + Rest(to convert object to Json)
@RestController
@RequestMapping("/api/posts")
public class PostController {
    // Using interface for lose coupling nad not class which will ame it tight coupling
    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // Create blog post
    @PostMapping
    //@RequestBody convert json to object
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
            return new ResponseEntity<>(postService.createPost(postDto),
                    HttpStatus.CREATED);
    }
}
