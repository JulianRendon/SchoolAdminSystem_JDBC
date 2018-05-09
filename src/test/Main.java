/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import interfaceDAO.StudentDAO;
import interfaceDAOImplementation.CourseDAOImplementation;
import interfaceDAOImplementation.MarksDAOImplementation;
import interfaceDAOImplementation.StudentDAOImplementation;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import model.Course;
import model.Marks;
import model.Student;

/**
 *
 * @author Julian
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // create dao objects and objetcs
        StudentDAOImplementation studentDao = new StudentDAOImplementation();
        Student student = new Student();

        CourseDAOImplementation courseDao = new CourseDAOImplementation();
        Course course = new Course();

        MarksDAOImplementation marksDao = new MarksDAOImplementation();
        Marks marks = new Marks();

        String continue1 = "y";
        while (continue1.toLowerCase().equals("y")) {

            System.out.println("Enter 1 for Student, 2 for Course or 3 for Marks");
            int mainMenuOption = sc.nextInt();
            String menuTitle;

            /**
             * *** MAIN MENU ****
             */
            switch (mainMenuOption) {

                /**
                 * *** MENU STUDENT ****
                 */
                case 1:
                    menuTitle = "Menu Student.";
                    String continueStudent = "y";
                    while (continueStudent.toLowerCase().equals("y")) {

                        System.out.println(menuTitle + " Please enter your choice:");
                        System.out.println("1 to insert a new student");
                        System.out.println("2 to update a student");
                        System.out.println("3 to delete a student");
                        System.out.println("4 to retreive a student info");
                        System.out.println("5 to display all students");

                        int studentChoice = sc.nextInt();
                        switch (studentChoice) {

                            /**
                             * *** INSERT A STUDENT ****
                             */
                            case 1:
                                System.out.println("Enter the student id");
                                int id = sc.nextInt();
                                System.out.println("Enter the student first name");
                                String firstName = sc.next();
                                System.out.println("Enter the student last name");
                                String lastName = sc.next();

                                student.setStudentId(id);
                                student.setStudentFirstname(firstName);
                                student.setStudentLastname(lastName);

                                studentDao.create(student);
                                System.out.println("Student " + firstName + " " + lastName + " has been created!");
                                break;

                            /**
                             * *** UPDATE A STUDENT ****
                             */
                            case 2:
                                System.out.println("Enter student id: ");
                                id = sc.nextInt();

                                Student studentSelected = studentDao.findById(id);
                                if (studentSelected.getStudentId() == 0) {
                                    System.out.println("This id does not exist");
                                } else {
                                    System.out.println("Selected = " + studentSelected.getStudentFirstname() + " " + studentSelected.getStudentLastname());
                                    System.out.println("Enter new first name:");
                                    String newFirstName = sc.next();
                                    System.out.println("Enter new last name;");
                                    String newLastName = sc.next();

                                    Student studentUpdated = new Student();
                                    studentUpdated.setStudentId(id);
                                    studentUpdated.setStudentFirstname(newFirstName);
                                    studentUpdated.setStudentLastname(newLastName);
                                    studentDao.update(studentUpdated);
                                    System.out.println("Student with id = " + id + " has been updated!");
                                }
                                break;

                            /**
                             * *** DELETE A STUDENT ****
                             */
                            case 3:
                                System.out.println("Enter the id of the student "
                                        + "that you want to delete");
                                id = sc.nextInt();

                                Student studentToBeDeleted = studentDao.findById(id);
                                if (studentToBeDeleted.getStudentId() == 0) {
                                    System.out.println("This id does not exist");
                                } else {
                                    System.out.println("Selected = " + studentToBeDeleted.getStudentFirstname() + " "
                                            + studentToBeDeleted.getStudentLastname());
                                    String confirmation = null;
                                    System.out.println("Are you sure you want to delete '" + studentToBeDeleted.getStudentFirstname() + "'? (y/n)");
                                    confirmation = sc.next();
                                    if (confirmation.toLowerCase().equals("y")) {
                                        studentDao.delete(id);
                                        System.out.println("Student with id = " + id + " has been deleted!");
                                    } else if (confirmation.toLowerCase().equals("n")) {
                                        System.out.println("Delete has been canceled!");
                                    } else {
                                        System.out.println("Wrong option..start again!");
                                    }
                                }
                                break;

                            /**
                             * *** DISPLAY ONE STUDENT INFO ****
                             */
                            case 4:
                                System.out.println("Enter the student id:");
                                id = sc.nextInt();

                                Student stSelected = studentDao.findById(id);
                                if ((stSelected.getStudentId() == 0)) {
                                    System.out.println("This id does not exist");
                                } else {
                                    Student st1 = studentDao.findById(id);
                                    System.out.println("Id: " + id + " belongs to: "
                                            + st1.getStudentFirstname() + " "
                                            + st1.getStudentLastname()
                                    );
                                }
                                break;

                            /**
                             * *** DISPLAY ALL STUDENTS ****
                             */
                            case 5:
                                List<Student> allStudents = studentDao.findAll();
                                if (allStudents.isEmpty()) {
                                    System.out.println("There is no students to display!");
                                } else {
                                    System.out.println("List of all students");
                                    for (Student st : allStudents) {
                                        System.out.println("id :" + st.getStudentId() + "  name: "
                                                + st.getStudentFirstname() + " " + st.getStudentLastname());
                                    }
                                }
                                break;

                            default:
                                System.out.println("wrong choice");
                                break;
                        }
                        System.out.println("Do you want to continue on Student? (y or n)");
                        continueStudent = sc.next();
                    }
                    break;

                /**
                 * *** MENU COURSE ****
                 */
                case 2:
                    menuTitle = "Menu Course.";
                    String continueCourse = "y";
                    while (continueCourse.equals("y")) {
                        System.out.println(menuTitle + " Please enter your choice:");
                        System.out.println("1 to insert a new course");
                        System.out.println("2 to update a course");
                        System.out.println("3 to delete a course");
                        System.out.println("4 to retreive a course info");
                        System.out.println("5 to display all courses");

                        int courseChoice = sc.nextInt();
                        switch (courseChoice) {

                            /**
                             * *** INSERT A COURSE ****
                             */
                            case 1:
                                System.out.println("Enter course id");
                                int id = sc.nextInt();
                                System.out.println("Enter your course name");
                                String courseName = sc.next();
                                course.setCourseId(id);
                                course.setCourseName(courseName);

                                courseDao.create(course);
                                System.out.println("Course " + courseName + " has been created!");
                                break;

                            /**
                             * *** UPDATE COURSE ****
                             */
                            case 2:
                                System.out.println("Enter course id:");
                                id = sc.nextInt();

                                Course courseSelected = courseDao.findById(id);
                                if (courseSelected.getCourseId() == 0) {
                                    System.out.println("This id does not exist");
                                } else {
                                    System.out.println("Selected = " + courseSelected.getCourseName());
                                    System.out.println("Enter new course name");
                                    String newCourseName = sc.next();

                                    Course courseUpdated = new Course();
                                    courseUpdated.setCourseId(id);
                                    courseUpdated.setCourseName(newCourseName);
                                    courseDao.update(courseUpdated);
                                    System.out.println("Course with id = " + id + " has been updated!");
                                }
                                break;

                            /**
                             * *** DELETE COURSE ****
                             */
                            case 3:
                                System.out.println("Enter the id of the course that you want to delete");
                                id = sc.nextInt();

                                Course courseToBeDeleted = courseDao.findById(id);
                                if (courseToBeDeleted.getCourseId() == 0) {
                                    System.out.println("This id does not exist");
                                } else {
                                    System.out.println("Selected = " + courseToBeDeleted.getCourseName());
                                    String confirmation = null;
                                    System.out.println("Are you sure you want to delete '" + courseToBeDeleted.getCourseName() + "'? (y/n)");
                                    confirmation = sc.next();
                                    if (confirmation.toLowerCase().equals("y")) {
                                        courseDao.delete(id);
                                        System.out.println("Course id = " + id + " has been deleted!");
                                    } else if (confirmation.toLowerCase().equals("n")) {
                                        System.out.println("Delete has been canceled!");
                                    } else {
                                        System.out.println("Wrong choise.. start over again!");
                                    }
                                }
                                break;

                            /**
                             * *** DISPLAY ONE COURSE INFO ****
                             */
                            case 4:
                                System.out.println("Enter the course id:");
                                id = sc.nextInt();

                                Course crsSelected = courseDao.findById(id);
                                if (crsSelected.getCourseId() == 0) {
                                    System.out.println("This id does not exist!");
                                } else {
                                    Course crs = courseDao.findById(id);
                                    System.out.println("Course id " + id + " is: " + crs.getCourseName());
                                }
                                break;

                            /**
                             * *** DISPLAY ALL COURSES ****
                             */
                            case 5:
                                List<Course> allCourses = courseDao.findAll();

                                if (allCourses.isEmpty()) {
                                    System.out.println("There is no courses to display");
                                } else {
                                    System.out.println("List of all courses");
                                    for (Course c : allCourses) {
                                        System.out.println("Course id: " + c.getCourseId() + " name: " + c.getCourseName());
                                    }
                                }
                                break;

                            default:
                                System.out.println("wrong choice");
                                break;
                        }
                        System.out.println("Do you want to continue on Course? (y or n)");
                        continueCourse = sc.next();
                    }
                    break;

                /**
                 * *** MENU MARKS ****
                 */
                case 3:
                    menuTitle = "Menu Marks.";
                    String continueMarks = "y";
                    while (continueMarks.equals("y")) {
                        System.out.println(menuTitle + " Please enter your choice:");
                        System.out.println("1 to insert new marks");
                        System.out.println("2 to retreive one student marks");
                        System.out.println("3 to display all students marks");

                        int courseChoice = sc.nextInt();
                        switch (courseChoice) {

                            /**
                             * *** INSERT ONE STUDENT MARKS ****
                             */
                            case 1:
                                System.out.println("Enter student id");
                                int stId = sc.nextInt();
                                System.out.println("Enter course id");
                                int crsId = sc.nextInt();
                                System.out.println("Enter marks1");
                                double marks1 = sc.nextDouble();
                                System.out.println("Enter marks2");
                                double marks2 = sc.nextDouble();
                                marks.setStudentId(stId);
                                marks.setCourseId(crsId);
                                marks.setMarks1(marks1);
                                marks.setMarks2(marks2);

                                marksDao.create(marks);
                                System.out.println(marks.getMarks1() + " and " + marks.getMarks2() + " have been added!");
                                break;

                            /**
                             * *** DISPLAY ONE STUDENT MARKS ****
                             */
                            case 2:
                                System.out.println("Enter the student id:");
                                stId = sc.nextInt();

                                List<Marks> stIdSelected = marksDao.findById(stId);
                                if (stIdSelected.isEmpty()) {
                                    System.out.println("There are no info to display");
                                } else {
                                    marksDao.findById(stId);
                                    List<Marks> stIdSelected1 = marksDao.findById(stId);

                                    for (Marks mk : stIdSelected1) {

                                        int stId3 = mk.getStudentId();
                                        Student st = studentDao.findById(stId3);
                                        int crsId1 = mk.getCourseId();
                                        Course crs = courseDao.findById(crsId1);
                                        
                                        System.out.println("Student id:" + mk.getStudentId()
                                                + " course :" + crs.getCourseName()
                                                + " name: " + st.getStudentFirstname() + " " + st.getStudentLastname()
                                                + " mark1:" + mk.getMarks1()
                                                + " mark2:" + mk.getMarks2()
                                        );
                                    }
                                }
                                break;

                            /**
                             * *** DISPLAY ALL STUDENTS MARKS ****
                             */
                            case 3:
                                System.out.println("List with all student marks");
                                List<Marks> pSelected1 = marksDao.findAll();
                                if (pSelected1.isEmpty()) {
                                    System.out.println("There are no info to display");
                                } else {
                                    marksDao.findAll();
                                    List<Marks> pSelected2 = marksDao.findAll();

                                    for (Marks mk : pSelected2) {
                                        //System.out.println(p.getStudentId()+ " TEST");
                                        int stid = mk.getStudentId(); //
                                        Student st = studentDao.findById(stid);
                                        int crsId1 = mk.getCourseId();
                                        Course crs = courseDao.findById(crsId1);

                                        System.out.println("Student id : " + mk.getStudentId()
                                                + " course :" + crs.getCourseName()
                                                + " name : " + st.getStudentFirstname() + " " + st.getStudentLastname()
                                                + " marks1 : " + mk.getMarks1()
                                                + " marks2 : " + mk.getMarks2());
                                    }
                                }
                                break;

                            default:
                                System.out.println("wrong choice");
                                break;
                        }
                        System.out.println("Do you want to continue on Marks? (y or n)");
                        continueMarks = sc.next();
                    }
                    break;

                default:
                    menuTitle = "Invalid choice";
                    break;
            }

            System.out.println(menuTitle);
            System.out.println("Do you want to continue on the Main Menu? (y or n)");
            continue1 = sc.next();
        }

        System.out.println(
                "Thank you. Your session has ended");

    }
}
