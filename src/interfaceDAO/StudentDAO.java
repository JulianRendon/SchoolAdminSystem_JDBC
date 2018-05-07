/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceDAO;

import java.util.List;
import model.Student;

/**
 *
 * @author user
 */
public interface StudentDAO {

    //void create(Student st);

//    List<Student> findAll();

    Student findById(int id);
}
