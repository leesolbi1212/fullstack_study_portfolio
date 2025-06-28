package com.koreait.mvc2.service;

import com.koreait.mvc2.dao.CommentDAO;
import com.koreait.mvc2.dto.CommentDTO;
import com.koreait.mvc2.dto.MemberDTO;
import com.koreait.mvc2.mybatis.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommentServiceImpl implements CommentService {


    @Override
    public void write(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        MemberDTO loginUser = (MemberDTO) session.getAttribute("user");
        if(loginUser == null) {
            resp.sendRedirect("login.member");
            return;
        }
        String writer = loginUser.getUserid();
        int boardIdx =  Integer.parseInt(req.getParameter("board_idx"));
        String content = req.getParameter("content");
        CommentDTO dto = new CommentDTO();
        dto.setContent(content);
        dto.setUser_id(writer);
        dto.setBoard_idx(boardIdx);

        try(SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession(true)){
            new CommentDAO(sqlSession).insertComment(dto);
            resp.sendRedirect("detail.board?idx="+boardIdx);

        }
    }

    @Override
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int idx = Integer.parseInt(req.getParameter("idx"));
        int board_idx = Integer.parseInt(req.getParameter("board_idx"));
        String user_id = req.getParameter("user_id");
        String content = req.getParameter("content");
        CommentDTO dto = new CommentDTO();
        dto.setIdx(idx);
        dto.setBoard_idx(board_idx);
        dto.setUser_id(user_id);
        dto.setContent(content);

        try(SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession(true)){
            new CommentDAO(sqlSession).updateComment(dto);
        }
        resp.sendRedirect("detail.board?idx="+board_idx);

    }

    @Override
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int idx = Integer.parseInt(req.getParameter("idx"));
        int board_idx = Integer.parseInt(req.getParameter("board_idx"));
        String user_id = req.getParameter("user_id");
        CommentDTO dto = new CommentDTO();
        dto.setIdx(idx);
        dto.setBoard_idx(board_idx);
        dto.setUser_id(user_id);

        try(SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession(true)){
            new CommentDAO(sqlSession).deleteComment(dto);
        }
        resp.sendRedirect("detail.board?idx="+board_idx);

    }
} // class
