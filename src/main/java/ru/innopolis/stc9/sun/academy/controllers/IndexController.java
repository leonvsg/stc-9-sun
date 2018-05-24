package ru.innopolis.stc9.sun.academy.controllers;

import org.apache.log4j.Logger;
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
    private static final Logger logger = Logger.getLogger(IndexController.class);

    @Autowired
    private ConnectionManager connectionManager;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO: убрать заглушку, реализовать логику
        try(Connection connection = connectionManager.getConnection()) {
            request.setAttribute("hello", connection.getCatalog());
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
