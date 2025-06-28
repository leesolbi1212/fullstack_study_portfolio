package com.koreait.member.mapper;

import com.koreait.member.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

// resources에 mapper 파일과 연결해주는 어노테이션
@Mapper
public interface MemberMapper {
    // 파라미터로 username을 받을건데 그건 String username이야
    MemberDTO findByUsername(@Param("username") String username);
    void save(MemberDTO memberDTO);
    void update(MemberDTO memberDTO);

}
// class
