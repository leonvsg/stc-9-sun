package ru.innopolis.stc9.sun.academy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ru.innopolis.stc9.sun.academy.connection.ConnectionManager;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


public class IndexController extends HttpServlet {
    @Autowired
    private ConnectionManager connectionManager;

    public void init(ServletConfig config) {
        try {
            super.init(config);
        } catch (ServletException e) {
            e.printStackTrace();
        }
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // TODO: убрать заглушку, реализовать логику
        Connection connection = connectionManager.getConnection();
        try {
            request.setAttribute("hello", connection.getCatalog());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
