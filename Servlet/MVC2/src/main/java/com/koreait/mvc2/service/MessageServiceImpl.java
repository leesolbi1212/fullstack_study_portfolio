package com.koreait.mvc2.service;

import com.koreait.mvc2.dao.MessageDAO;
import com.koreait.mvc2.dto.MemberDTO;
import com.koreait.mvc2.dto.MessageDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MessageServiceImpl implements MessageService {
    private MessageDAO dao= new MessageDAO();

    @Override
    public void isLogged(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MemberDTO sessionDto= (MemberDTO) req.getSession().getAttribute("user");
        if (sessionDto!=null) {
            req.getRequestDispatcher("/WEB-INF/views/writemessage.jsp").forward(req, resp);
        }else{
            resp.sendRedirect("login.member");
        }
    }
    //    받은쪽지 보낸쪽지 조회
    @Override
    public void showMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MemberDTO sessionDto = (MemberDTO) req.getSession().getAttribute("user");
        String userId = sessionDto.getUserid();

        List<MessageDTO> inbox = dao.getReceivedMessages(userId);
        List<MessageDTO> outbox = dao.getSendMessages(userId);

        req.setAttribute("inbox", inbox);
        req.setAttribute("outbox", outbox);
        req.getRequestDispatcher("/WEB-INF/views/box.jsp").forward(req, resp);
    }
    //쪽지 작성하고 db에 저장
    @Override
    public void writeMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MessageDTO dto= new MessageDTO();
        MemberDTO sessionDto= (MemberDTO) req.getSession().getAttribute("user");
        dto.setSenderID(sessionDto.getUserid());

        dto.setReceiverID(req.getParameter("receiver"));
        dto.setContent(req.getParameter("content"));
        boolean success = dao.insertMessage(dto);
        if (success){
            resp.sendRedirect("box.message");
        }else{
            req.setAttribute("error", "쪽지 작성 중 오류");
            req.getRequestDispatcher("/WEB-INF/views/writemessage.jsp").forward(req, resp);
        }
    }
    //로그인한 사용자 쪽지 조회
    @Override
    public void viewMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer messageID= Integer.parseInt(req.getParameter("messageID"));
        MessageDTO onemessage = dao.getOnemessageByID(messageID);
        req.setAttribute("onemessage", onemessage);
        req.getRequestDispatcher("/WEB-INF/views/box.jsp").forward(req, resp);
    }

    @Override
    public void deleteMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer messageID= Integer.parseInt(req.getParameter("messageID"));
        String type= req.getParameter("type");

        boolean isDeletemessage = dao. deletemassage(messageID,type);
        if (isDeletemessage){
            resp.sendRedirect("box.message");
        }else{
            req.setAttribute("500", "삭제 실패");
            req.getRequestDispatcher("/WEB-INF/views/box.jsp").forward(req, resp);
        }
    }


} // class
