package com.springboot.blog.service;

import com.springboot.blog.payload.PostDto;
import org.springframework.web.bind.annotation.RequestBody;

public interface PostService {
    PostDto createPost(PostDto postDto);
}
