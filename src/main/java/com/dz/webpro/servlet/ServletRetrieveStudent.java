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
import java.util.ArrayList;

@WebServlet(name = "ServletRetrieveStudent",
urlPatterns = "/RetrieveStudent")
public class ServletRetrieveStudent extends HttpServlet {
    /**
     * purpose:retrieve student details
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MysqlOperation mysqlOperation=new MysqlOperation();
        int check=mysqlOperation.lastIdExist();
        if(check==1){
            request.setAttribute("check",check);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jspPages/retrieveStudent.jsp");
            requestDispatcher.forward(request,response);

        }else {
            check=0;
            ArrayList<Student> list = mysqlOperation.retrieveStudentSqlDb();
            request.setAttribute("check",check);
            request.setAttribute("list", list);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jspPages/retrieveStudent.jsp");
            requestDispatcher.forward(request, response);
        }
    }

}
