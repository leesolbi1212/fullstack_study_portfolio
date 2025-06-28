package com.koreait.restapi.controller;

import com.koreait.restapi.dto.PostDTO;
import com.koreait.restapi.jwt.JwtUtil;
import com.koreait.restapi.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins="http://localhost:5173", allowCredentials = "true")
@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final JwtUtil jwtUtil;
    private final PostService postService;

//    @PostMapping
//    // (일반 글쓰기) 변수로 받을 수도 있지만... dto가 필요할 것 가타용...
//    public ResponseEntity<?> create(@RequestBody PostDTO post, HttpServletRequest request) {
//        int userId = jwtUtil.getUserIdFromRequest(request);
//        post.setWriterId(userId); //글쓴사람의 userid를 알아내기
//        postService.insertPost(post);
//        return ResponseEntity.ok().build();
//    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> create(@RequestPart("post") PostDTO post,
                                    @RequestPart(value = "image", required=false) MultipartFile image,
                                    HttpServletRequest request) throws IOException {
        int userId = jwtUtil.getUserIdFromRequest(request);
        post.setWriterId(userId);
        postService.insertPostWithImage(post, image);
        return ResponseEntity.ok().build();

    }

    @GetMapping //인피니티 스크롤 (인스타처럼 무한스크롤)
    public List<PostDTO> list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        return postService.getPosts(page,size);
    }


}
