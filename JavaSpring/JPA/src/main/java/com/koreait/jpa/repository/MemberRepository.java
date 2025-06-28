package com.koreait.jpa.repository;

import com.koreait.jpa.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// 데이터베이스와 직접 통신하지 않고 Spring Data JPA가 자동으로 구현체를 만듦
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    //<MemberEntity, Long> : 어떤 Entity를 다룰지 설정, ID(기본키)의 타입
    //findAll(), findById(), save(), delete() 기본 CRUD 메서드가 자동 생성

    //username을 넣으면 findByUsername에 의해서 찾아줄겜! (카멜표기법으로 적으면 알아서 쿼리문 작성해줌)
    Optional<MemberEntity> findByUsername(String username);
}
