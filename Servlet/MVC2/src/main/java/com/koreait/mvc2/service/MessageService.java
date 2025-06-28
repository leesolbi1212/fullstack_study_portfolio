package com.koreait.mvc2.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MessageService {
    void isLogged(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
    void showMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
    void writeMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
    void deleteMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
    void viewMessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
