package com.koreait.jpa.repository;

import com.koreait.jpa.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

// 필요한 건 여기에 만들어서 쓰면 돼요 (맞춤형으로 뽑아 쓰세요)
public interface PostRepository extends JpaRepository<PostEntity,Integer> {
    @Query("SELECT p FROM PostEntity p JOIN FETCH p.writer WHERE p.title LIKE %:keyword%")
    List<PostEntity> searchByTitle(@Param("keyword") String keyword);

    @Query("SELECT p FROM PostEntity p JOIN FETCH p.writer w WHERE w.username =  :username")
    List<PostEntity> findByWriterUsername(@Param("username") String username);
}

