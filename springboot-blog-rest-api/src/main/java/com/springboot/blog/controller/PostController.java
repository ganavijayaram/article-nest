package com.springboot.blog.controller;

import com.springboot.blog.payload.PostDto;
import com.springboot.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        System.out.printf("Controller %d %s %s %s%n", postDto.getId(), postDto.getTitle(), postDto.getContent(), postDto.getDescription());
            return new ResponseEntity<>(postService.createPost(postDto),
                    HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts() {
        return  new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }
}
