package com.sms.controllers;

import com.sms.ejb.TextMessageQI;
import com.sms.jms.FilterMessages;
import com.sms.models.Sms;

import javax.ejb.EJB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "sendMsg", urlPatterns = "/sendMsg")
public class SendMsgServlet extends HttpServlet {

    @EJB
    FilterMessages filterMessages;

    @EJB
    TextMessageQI textMessageQI;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String msg = req.getParameter("msg");
        String recipient = req.getParameter("to");
        Sms sms = new Sms();
        sms.setMessage(msg);
        sms.setRecepient(recipient);
        Date date = new Date();
        sms.setDate(date);

        String option = req.getParameter("option");
        filterMessages.checkMessage(option, sms);
        resp.sendRedirect("index.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/msgs/addMsg.jsp").forward(req,resp);
    }
}
