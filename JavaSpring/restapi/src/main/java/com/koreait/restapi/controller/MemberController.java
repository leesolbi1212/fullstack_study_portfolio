package com.koreait.restapi.controller;

import com.koreait.restapi.dto.MemberDTO;
import com.koreait.restapi.jwt.JwtUtil;
import com.koreait.restapi.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="http://localhost:5173", allowCredentials = "true")
@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService service;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody MemberDTO member) {
        service.register(member);
        return ResponseEntity.ok("회원가입 성공"); //ok라면 200이 알아서 가게 된다.
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody MemberDTO loginRequest) { //이름만 맞으면 DTO로 받아도 관계없음
        String token = service.login(loginRequest.getUsername(),loginRequest.getPassword());
        if (token != null) {
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(401).body("로그인 실패");
        }
    }

    @GetMapping("/info") //로그인해야지만들어올수있다(auth에 토큰이 있어야해용
    public ResponseEntity<?> GetUserinfo(@RequestHeader("Authorization") String token) {
        MemberDTO member = service.getUserInfoFromToken(token);
        if (member != null) {
            return ResponseEntity.ok(member);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("사용자를 찾을 수 없습니다.");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader("Authorization") String token) {
        service.logout(token);
        return ResponseEntity.ok("로그아웃 성공");
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestHeader("Authorization") String token, @RequestBody MemberDTO member) {
        service.update(token, member);
        return ResponseEntity.ok("회원정보 수정 성공");
    }


}
