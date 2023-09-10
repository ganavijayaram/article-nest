package com.springboot.blog.service.impl;

import com.springboot.blog.model.Post;
import com.springboot.blog.payload.PostDto;
import com.springboot.blog.repository.PostRepository;
import com.springboot.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    // if spring class is configured as bean and it has only one constructor
    // you don't need to autowire it
    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

        System.out.printf("service dto %d %s %s %s%n", postDto.getId(), postDto.getTitle(), postDto.getContent(), postDto.getDescription());

        // convert DTO to entity
        Post post = dtoToEntity(postDto);

        System.out.printf("service post %s %s %s%n", post.getTitle(), post.getContent(), post.getDescription());


        // Saving the entity into the DB and returns entity
        Post newPost = postRepository.save(post);

        System.out.printf("service newpost %d %s %s %s%n", newPost.getId(), newPost.getTitle(), newPost.getContent(), newPost.getDescription());


        //convert entity to DTO to send to client

        PostDto postResponse = entityToDto(newPost);

        System.out.printf("CService resp %d %s %s %s%n", postResponse.getId(), postResponse.getTitle(), postResponse.getContent(), postResponse.getDescription());


        return postResponse;
    }

    // convert Entity to DTO
    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();


        return posts.stream().map(post -> entityToDto(post)).collect(Collectors.toList());


    }

    // convert DTO to entity
    private PostDto entityToDto(Post post) {

        //convert entity to DTO to send to client
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());

        return postDto;

    }

    private Post dtoToEntity(PostDto postDto) {

        //convert entity to DTO to send to client
        Post post = new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        return post;

    }

}
