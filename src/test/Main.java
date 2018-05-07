/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import interfaceDAO.StudentDAO;
import interfaceDAOImplementation.StudentDAOImplementation;
import java.util.List;
import java.util.Scanner;
import model.Student;

/**
 *
 * @author user
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // create dao object for PersonDAO
        StudentDAO dao = new StudentDAOImplementation();

        // find by ID
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student ID");
        int d = sc.nextInt();
        Student student = dao.findById(d);
        System.out.println(student);

        // Display All people
//        List<Student> listStudents = dao.findAll();
//        for (Student st1: listStudents) {
//            System.out.println("student id " + st1.getStudentId());
//        }
    }

}
