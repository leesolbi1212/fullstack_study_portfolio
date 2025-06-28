package com.koreait.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
// 테이블에 이 하나하나 필드를 연결하겠다.
@Entity
@Table(name = "member")
//@NoArgsConstructor
//@AllArgsConstructor
public class MemberEntity {
    @Id // 가져올 때만 쓸 거라는 뜻
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 직접 넣는 게 아니라 auto로 자동 증가된다. 유일한 값이다. 라는 뜻
    private long id;
    @Column(unique = true, nullable = false) //유일한 값이 들어가야 하고, null 값 안되고
    private String username;
    @Column(nullable = false, length = 100)
    private String password;
    @Column(nullable = false)
    private String name;

    public MemberEntity() {
    }

    public MemberEntity(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }
}
