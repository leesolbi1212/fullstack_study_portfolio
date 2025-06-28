package com.koreait.restapi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor //파라미터가 없는
@AllArgsConstructor // 파라미터가 모두 있는
public class PostDTO {
    private int id;
    private String title;
    private String content;
    private int writerId;
    private String writerName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String thumbnailUrl; //데이터베이스와 상관없이 만들어두기

}
