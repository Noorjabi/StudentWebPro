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

@WebServlet(name = "ServletEditStudent",
        urlPatterns = "/EditStudent")
public class ServletEditStudent extends HttpServlet {
    /**
     * purpose:update student details
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student =new Student();
        int id =Integer.parseInt(request.getParameter("id"));
        String name =request.getParameter("name");
        int age =Integer.parseInt(request.getParameter("age"));
        student.setStdname(name);
        student.setAge(age);
        MysqlOperation mysqlOperation=new MysqlOperation();
        mysqlOperation.updateStudentSqlDb(id,student);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
        requestDispatcher.forward(request, response);
    }

}
