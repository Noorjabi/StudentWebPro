package com.dz.webpro.servlet;

import com.dz.webpro.dboperation.MysqlOperation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "ServletDeleteStudent",
        urlPatterns = "/DeleteStudent"
)
public class ServletDeleteStudent extends HttpServlet {

    /**
     * purpose:delete student details
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id =Integer.parseInt(request.getParameter("id"));
        MysqlOperation mysqlOperation=new MysqlOperation();

            mysqlOperation.deleteStudentSqlDb(id);

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request, response);




    }
}
