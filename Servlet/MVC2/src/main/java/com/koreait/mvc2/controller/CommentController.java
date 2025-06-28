package com.koreait.mvc2.controller;

import com.koreait.mvc2.service.CommentService;
import com.koreait.mvc2.service.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.CLcomment")
public class CommentController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CommentService service = new CommentServiceImpl();


    public CommentController() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doAction(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doAction(req, resp);
    }

    protected void doAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String contextPath = req.getContextPath();
        String command = uri.substring(contextPath.length());

        switch (command) {
            case "/write.CLcomment":
                service.write(req, resp);
                break;

            case "/updateForm.CLcomment":
                service.update(req, resp);
                break;

            case "/deleteForm.CLcomment":
                service.delete(req, resp);
                break;

            default:
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);

        }
    }


} //class
