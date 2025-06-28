package com.koreait.jpa.dto;

import com.koreait.jpa.entity.PostEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PostResponseDto {
    private Integer id;
    private String title;
    private String content;
    private String writerUsername;

    public PostResponseDto(PostEntity post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.writerUsername = post.getWriter().getUsername();
    }
}
