package com.koreait.member.service;

import com.koreait.member.dto.MemberDTO;
import com.koreait.member.mapper.MemberMapper;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor //생성자에 각각 값을 넣어 사용할 수 있게끔
public class MemberServiceImpl implements MemberService {

    private final MemberMapper mapper;

    @Override
    public void register(MemberDTO member) {
        mapper.save(member);
    }

    @Override
    public boolean login(String username, String password, HttpSession session) {
        MemberDTO member = mapper.findByUsername(username);
        if (member != null
                && StringUtils.hasText(password)
                && password.equals(member.getPassword())) {  // ← 여기 닫는 괄호 추가
            session.setAttribute("loginUser", member);
            return true;
        }
        return false;
    }

    @Override
    public void logout(HttpSession session) {
        session.invalidate();

    }

    @Override
    public void update(MemberDTO member) {
        mapper.update(member);

    }
}
