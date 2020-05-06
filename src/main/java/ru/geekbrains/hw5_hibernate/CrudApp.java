/**
 * @author Ostrovskiy Dmitriy
 * @created 06.05.2020
 * CrudApp
 * @version v1.0
 */

package ru.geekbrains.hw5_hibernate;

import java.util.List;

public class CrudApp {

    public static void main(String[] args) throws Exception {

        CrudApp rand = new CrudApp();
        StudentService studentService = new StudentService();

        System.out.println("============\n== INIT DB ==\n============");
        studentService.initDB();

        System.out.println("============\n== CREATE ==\n============");
        System.out.println("Before save: students= " + studentService.findAllStudent().size());
        if(studentService.findAllStudent().size()<1000) {
            for (int i = 0; i < 1000; i++) {
                Student newStudent = new Student("Student" + i, rand.random(5));
                studentService.saveStudent(newStudent);
            }
        }
        System.out.println("After save and commit: students= " + studentService.findAllStudent().size());

        System.out.println("============\n=== READ ===\n============");
        for (int i = 0; i < 5; i++) {
            Long id = rand.randomLong(1000);
            System.out.println("ID random= " + id);
            Student findStudent = studentService.
                    findStudent(id);
            if (findStudent!=null) {
                System.out.println("Student: " + findStudent.toString());
            }
        }

        System.out.println("============\n=== READ ALL ===\n============");
            List<Student> findAllStudent = studentService.findAllStudent();
            if (findAllStudent!=null) {
                for (Student student: findAllStudent) {
                    System.out.println("Student: " + student);
                }
        }

        System.out.println("============\n== UPDATE ==\n============");
        for (int i = 0; i < 5; i++) {
            Long idStudent = rand.randomLong(1000);
            System.out.println("Long id= " + idStudent);
            Student findStudent = studentService.
                    findStudent(idStudent);
            if (findStudent!=null) {
                System.out.println("Before update: student= " + findStudent.toString());
                findStudent.setName("Student " + rand.random(1000));
                findStudent.setMark(rand.random(5));
                studentService.updateStudent(findStudent);
                System.out.println("After update: students= " + studentService.
                        findStudent(idStudent));
            }
        }

        System.out.println("============\n== DELETE ==\n============");
        for (int i = 0; i <5 ; i++) {
            Long idStudent = rand.randomLong(1000);
            System.out.println("Long id= " + idStudent);
            Student findStudent = studentService.
                    findStudent(idStudent);
            if (findStudent!=null) {
                System.out.println("Before delete: student= " + findStudent.toString());
                studentService.deleteStudent(findStudent);
                System.out.println("After delete: students= " + studentService.
                            findStudent(idStudent));
            }
        }

        System.out.println("============\n== DELETE ALL ==\n============");
        System.out.println("Before delete All: student count= " + studentService.findAllStudent().size());
        if (studentService.deleteAllStudents()==0) {
            System.out.println("*****DELETE ALL DONE!*****");
        }
        System.out.println("After delete All: student count= " + studentService.findAllStudent().size());
    }

    public int random(int size) {
        double rand = Math.random()*size;
        return (int)rand + 1;
    }

    public Long randomLong(int size) {
        CrudApp rand = new CrudApp();
        return Long.parseLong(String.valueOf(rand.random(size)));
    }
}
