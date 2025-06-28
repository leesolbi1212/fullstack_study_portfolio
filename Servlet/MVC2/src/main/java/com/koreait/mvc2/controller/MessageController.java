package com.koreait.mvc2.controller;

import com.koreait.mvc2.service.MessageService;
import com.koreait.mvc2.service.MessageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.message")
public class MessageController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MessageService service = new MessageServiceImpl();
    public MessageController() {}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doAction(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doAction(req,resp);
    }

    protected void doAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String uri = req.getRequestURI();
        String context = req.getContextPath();
        String commend= uri.substring(context.length());

        switch (commend){
            case "/box.message":
                service.showMessage(req,resp);
                break;
            case "/write.message":
                    req.setAttribute("receiver", req.getParameter("receiver"));
                    req.getRequestDispatcher("/WEB-INF/views/writemessage.jsp").forward(req, resp);

                break;
            case "/read.message":
                service.viewMessage(req,resp);
                break;
            case "/delete.message":
                service.deleteMessage(req,resp);
                break;
            case "/send.message":
                service.writeMessage(req, resp);
                break;
            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }



    }

} // class
