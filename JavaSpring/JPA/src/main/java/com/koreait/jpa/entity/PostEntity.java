package com.koreait.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "post")
@Getter @Setter
@NoArgsConstructor
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false,length = 255)
    private String title;

    @Lob //대용량 데이터
    @Column(nullable = false)
    private String content;

    @CreationTimestamp //데이터를 넣지 않더라도 데이터를 넣지 않더라도 자동으로 시간이 들어가게 된다.
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY) //데이터를 조인해서 하나를 쓰는 방법 (지연로딩)
    @JoinColumn(name = "writer_id", nullable = false)
    private MemberEntity writer;



}
