package com.dz.webpro.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletSelectTask",
        urlPatterns = "/SelectTask"
)
public class ServletSelectTask extends HttpServlet {
    /**
     * purpose:input from user for task choice
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String taskchoice = request.getParameter("Task");


            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jspPages/addStudent.jsp");
            requestDispatcher.forward(request, response);


    }
}
