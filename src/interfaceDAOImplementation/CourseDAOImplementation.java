/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceDAOImplementation;

import connection.ConnectionFactory;
import interfaceDAO.CourseDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Course;

/**
 *
 * @author Julian
 */
public class CourseDAOImplementation implements CourseDAO {

    Connection connection = ConnectionFactory.getConnection();

    // Constructor
    public CourseDAOImplementation() {
    }

    // Create a new Course
    public void create(Course course) {
        PreparedStatement preparedStatement = null;

        try {
            String createQuery = "INSERT INTO COURSE (COURSE_ID, COURSE_NAME) VALUES(?,?)";
            preparedStatement = connection.prepareStatement(createQuery);
            preparedStatement.setInt(1, course.getCourseId());
            preparedStatement.setString(2, course.getCourseName());
            preparedStatement.executeQuery();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Find a course by ID
    @Override
    public Course findById(int id) {

        Course course = null;
        ResultSet resultSet = null;

        PreparedStatement preparedStatement = null;

        try {
            String selectIdQuery = "SELECT * FROM COURSE WHERE COURSE_ID = ?";
            preparedStatement = connection.prepareStatement(selectIdQuery);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            course = new Course();
            course.setCourseId(resultSet.getInt("course_id"));
            course.setCourseName(resultSet.getString("course_name"));
            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return course;
    }

    // find all courses
    public List<Course> findAll() {

        List<Course> courses = new ArrayList<>();
        Course course = null;
        ResultSet resultSet;
        PreparedStatement preparedStatement;

        try {
            String selectAllQuery = "SELECT * FROM COURSE ORDER BY COURSE_ID";
            preparedStatement = connection.prepareStatement(selectAllQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                course = new Course();
                course.setCourseId(resultSet.getInt("course_id"));
                course.setCourseName(resultSet.getString("course_name"));
                courses.add(course);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return courses;
    }

    // Update a course's info
    public void update(Course course) {

        PreparedStatement preparedStatement;

        try {
            String updateQuery = "UPDATE COURSE SET COURSE_NAME = ? WHERE COURSE_ID = ?";
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, course.getCourseName());
            preparedStatement.setInt(2, course.getCourseId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // delete a course
    public void delete(int id) {

        PreparedStatement preparedStatement;

        try {
            String deleteQuery = "DELETE FROM COURSE WHERE COURSE_ID = " + id;
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
