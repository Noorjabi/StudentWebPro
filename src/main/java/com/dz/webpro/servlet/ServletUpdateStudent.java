package com.dz.webpro.servlet;

import com.dz.webpro.dboperation.MysqlOperation;
import com.dz.webpro.entity.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletUpdateStudent",
urlPatterns = "/UpdateStudent")
public class ServletUpdateStudent extends HttpServlet {
    /**
     * purpose:redirect id to update student details
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            int id =Integer.parseInt(request.getParameter("id"));
            request.setAttribute("id",id);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jspPages/updateStudent.jsp");
            requestDispatcher.forward(request, response);


    }
}
