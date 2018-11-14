package com.dz.webpro.config;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;


public class JavaMysqlDbConnection {

    private  static Logger log=Logger.getLogger(JavaMysqlDbConnection.class);

    /**
     * purpose:create connection
     * @return
     */

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student?useSSL=false", "root", "root");
            return con;
        }
        catch (Exception ex) {
           log.error(ex);
        }

        return null;
    }
}
