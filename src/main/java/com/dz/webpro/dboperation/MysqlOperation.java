package com.dz.webpro.dboperation;

import com.dz.webpro.config.JavaMysqlDbConnection;
import com.dz.webpro.entity.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class MysqlOperation {

    /**
     * purpose: add student in Sql database
     *
     * @param student
     */
    public void addStudentSqlDb(Student student) {
            int id=lastIdExist();
        try {
            Connection connection = JavaMysqlDbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into student values(?,?,?)");
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, student.getStdname());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * purpose:delete student in sql database
     *
     * @param id
     */
    public void deleteStudentSqlDb(int id) {
        PreparedStatement preparedStatement;
        Connection connection = JavaMysqlDbConnection.getConnection();
        try {
            int check = checkIdExist(id);
            if (check == 1) {
                preparedStatement = connection.prepareStatement("delete from student where StudentId=?");
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                System.out.println("Successfully deleted");
                connection.close();
            } else
                System.out.println("Student Id does'nt exist");

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

    /**
     * purpose:accessing student from sql database
     */
    public ArrayList<Student> retrieveStudentSqlDb() {

        ArrayList<Student> arrayList=new ArrayList<>();
        try {
            Connection connection = JavaMysqlDbConnection.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("select * from student");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Student student=new Student();
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);
                student.setStdname(name);
                student.setAge(age);
                student.setId(id);
                arrayList.add(student);
                System.out.println(id+name+age);
            }
            for (Student student1:arrayList){
                System.out.println(student1.getId());
            }
            preparedStatement.close();
            connection.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return arrayList;
    }

    /**
     * purpose:update student in sql database
     *
     * @param id
     * @param student
     */
    public void updateStudentSqlDb(int id, Student student) {
        try {
            Connection connection = JavaMysqlDbConnection.getConnection();
            int check = checkIdExist(id);
            if (check == 1) {
                PreparedStatement preparedStatement = connection.prepareStatement("update student set Name = ? , Age = ? where StudentId = ?");
                preparedStatement.setString(1, student.getStdname());
                preparedStatement.setInt(2, student.getAge());
                preparedStatement.setInt(3, id);
                preparedStatement.executeUpdate();
                preparedStatement.close();
                connection.close();
            } else
                System.out.println("Student Id does'nt exist");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * purpose:checking Student ID exist in database or not
     *
     * @param i
     * @return
     */
    public int checkIdExist(int i) {
        int x = 0;
        try {
            Connection connection = JavaMysqlDbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from student");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("StudentId");
                if (id == i) {
                    x = 1;
                }
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return x;
    }

    /**
     *purpose:generate Id
     * @return
     */
    public int lastIdExist()
    {
        int id=0;
        try {
            Connection connection = JavaMysqlDbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from student");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("StudentId");

            }
            id=id+1;
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return id;
    }
}
