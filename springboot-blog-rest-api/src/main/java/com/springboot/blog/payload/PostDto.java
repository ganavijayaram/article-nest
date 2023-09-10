package com.springboot.blog.payload;

import lombok.Data;

// will automatically create getters, setter, tostring, we dont have to create all this by ourself
@Data
public class PostDto {
    private long id;
    private String title;
    private String description;
    private String content;

}
