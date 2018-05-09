/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceDAOImplementation;

import connection.ConnectionFactory;
import interfaceDAO.MarksDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Marks;

/**
 *
 * @author Julian
 */
public class MarksDAOImplementation implements MarksDAO {

    Connection connection = ConnectionFactory.getConnection();

    // constructor
    public MarksDAOImplementation() {
    }

    // create new marks
    @Override
    public void create(Marks marks) {

        PreparedStatement preparedStatement = null;

        try {
            String createQuery = "INSERT INTO MARKS (STUDENT_ID, COURSE_ID, MARKS1, MARKS2) VALUES(?,?,?,?)";
            preparedStatement = connection.prepareStatement(createQuery);
            preparedStatement.setInt(1, marks.getStudentId());
            preparedStatement.setInt(2, marks.getCourseId());
            preparedStatement.setDouble(3, marks.getMarks1());
            preparedStatement.setDouble(4, marks.getMarks2());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // List one student marks
    @Override
    public List<Marks> findById(int id) {

        List<Marks> mrks = new ArrayList<>();
        Marks marks = null;
        ResultSet resultSet;
        PreparedStatement preparedStatement;

        try {
            String mrkQuery = "SELECT "
                    + "S.STUDENT_ID, S.FIRST_NAME, S.LAST_NAME, C.COURSE_ID, "
                    + "C.COURSE_NAME, M.MARKS1, M.MARKS2 "
                    + "FROM STUDENT S, COURSE C, MARKS M "
                    + "WHERE S.STUDENT_ID = M.STUDENT_ID AND C.COURSE_ID = M.COURSE_ID "
                    + "AND S.STUDENT_ID =" + id + " ORDER BY M.COURSE_ID";

            preparedStatement = connection.prepareStatement(mrkQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                marks = new Marks();
                marks.setStudentId(resultSet.getInt("student_id"));
                marks.setCourseId(resultSet.getInt("course_id"));
                marks.setMarks1(resultSet.getDouble("marks1"));
                marks.setMarks2(resultSet.getDouble("marks2"));
                mrks.add(marks);
            }
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return mrks;
    }

    //  List all students marks
    public List<Marks> findAll() {

        List<Marks> mrks1 = new ArrayList<>();
        Marks marks = null;
        ResultSet resultSet;
        PreparedStatement preparedStatement;

        try {
            String mrkQuery1 = "SELECT "
                    + "S.STUDENT_ID, S.FIRST_NAME, S.LAST_NAME, "
                    + "C.COURSE_ID, C.COURSE_NAME, M.MARKS1, M.MARKS2 "
                    + "FROM STUDENT S, COURSE C, MARKS M "
                    + "WHERE S.STUDENT_ID = M.STUDENT_ID AND "
                    + "C.COURSE_ID = M.COURSE_ID "
                    + "ORDER BY S.STUDENT_ID, C.COURSE_ID";

            preparedStatement = connection.prepareStatement(mrkQuery1);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                marks = new Marks();
                marks.setStudentId(resultSet.getInt("student_id"));
                marks.setCourseId(resultSet.getInt("course_id"));
                marks.setMarks1(resultSet.getDouble("marks1"));
                marks.setMarks2(resultSet.getDouble("marks2"));
                mrks1.add(marks);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return mrks1;
    }

}
