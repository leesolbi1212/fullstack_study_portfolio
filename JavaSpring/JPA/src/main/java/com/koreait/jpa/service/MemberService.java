package com.koreait.jpa.service;

import com.koreait.jpa.entity.MemberEntity;
import com.koreait.jpa.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    // 얘는 걍 껍데기 (insert 문을 쓰지 않아도 자동으로 CRUD가 생성됨)
    public void save(MemberEntity member) {
        memberRepository.save(member);
    }

    public MemberEntity findByUsername(String username) {
        return memberRepository.findByUsername(username) //찾았으면 return
                .orElseThrow(() -> new RuntimeException("User not found")); //찾지 못했다면 일부러 에러 내겠다
    }

    public void update(String Username, String name, String encodedPassword) {
        MemberEntity member = findByUsername(Username);
        member.setName(name);
        member.setPassword(encodedPassword);
        memberRepository.save(member);
    }
}
