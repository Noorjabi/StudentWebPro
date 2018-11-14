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


@WebServlet(name = "ServletAddStudent",
urlPatterns = "/AddStudent")
public class ServletAddStudent extends HttpServlet {
    /**
     * purpose :Add student
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name =request.getParameter("name");
        int age =Integer.parseInt(request.getParameter("age"));
        Student student = new Student();
        student.setStdname(name);
        student.setAge(age);
        MysqlOperation mysqlOperation=new MysqlOperation();
        mysqlOperation.addStudentSqlDb(student);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(request, response);


    }
}
