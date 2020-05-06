/**
 * @author Ostrovskiy Dmitriy
 * @created 06.05.2020
 * StudentService
 * @version v1.0
 */

package ru.geekbrains.hw5_hibernate;

import java.util.List;

public class StudentService {

    private StudentDaoImpl studentDao = new StudentDaoImpl();

    public StudentService(){
    }

    public void initDB() {
        studentDao.initDB();
        System.out.println("Init DONE!");
    }

    public Student findStudent(Long id) {
        return studentDao.findById(id);
    }

    public void saveStudent(Student student) {
        studentDao.save(student);
    }

    public void deleteStudent(Student student) {
        studentDao.delete(student);
    }

    public int deleteAllStudents() {
        return studentDao.deleteAll();
    }

    public void updateStudent(Student student) {
        studentDao.update(student);
    }

    public List<Student> findAllStudent() {
        return studentDao.findAll();
    }
}
