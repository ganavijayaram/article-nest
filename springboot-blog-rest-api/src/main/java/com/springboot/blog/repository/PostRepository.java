package com.springboot.blog.repository;

import com.springboot.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

// model name and its primaryKey
public interface PostRepository extends JpaRepository<Post, Long> {
    //JPA has all the methods to talk to the repo, no need to write ny methods for
    //CRD, pagination, sorting
    // no need to annotate as repo because JPARepo has Repo annotation
    //  no need to annotate as transaction because JPARepo has transactional annotation
}
