/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceDAO;

import java.util.List;
import model.Course;

/**
 *
 * @author Julian
 */
public interface CourseDAO {

    void create(Course course);

    void update(Course course);

    void delete(int id);

    List<Course> findAll();

    Course findById(int id);

}
