/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceDAOImplementation;

import connection.ConnectionFactory;
import interfaceDAO.StudentDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Student;

/**
 *
 * @author user
 */
public class StudentDAOImplementation implements StudentDAO {

    Connection connection = ConnectionFactory.getConnection();

    //Constructor   
    public StudentDAOImplementation() {
    }

    //Find a student by his/her ID
    @Override
    public Student findById(int id) {

        Student student = null;
        ResultSet resultSet = null;

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("SELECT * "
                    + "FROM STUDENT WHERE STUDENT_ID= ?" );
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try {
            resultSet.next();
            student = new Student();
            student.setStudentId(resultSet.getInt("student_id"));
            student.setStudentFirstname(resultSet.getString("first_name"));
            student.setStudentLastname(resultSet.getString("last_name"));
            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return student;
    }
    
//    @Override
//    public List<Student> select() throws SQLException, ClassNotFoundException {
//        List<Student> students = new ArrayList<>();
//        Statement statement = getConnection().createStatement();
//        ResultSet resultSet = statement.executeQuery("SELECT * FROM STUDENT ORDER BY STUDENT_ID");
//        Student student = null;
//        while (resultSet.next()) {
//            student = new Student();
//            student.setStudentId(resultSet.getInt("student_id"));
//            student.setStudentFirstname(resultSet.getString("first_name"));
//            student.setStudentLastname(resultSet.getString("last_name"));
//            students.add(student);
//        }
//        resultSet.close();
//        statement.close();
//        closeConnection();
//        return students;
//    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
