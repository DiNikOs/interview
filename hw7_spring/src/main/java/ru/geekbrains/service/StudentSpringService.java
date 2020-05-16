/**
 * @author Ostrovskiy Dmitriy
 * @created 06.05.2020
 * StudentSpringService
 * @version v1.0
 */

package ru.geekbrains.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.persistence.entity.Student;
import ru.geekbrains.persistence.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentSpringService {

    private StudentRepository studentRepository;

    public StudentSpringService() {
    }

    @Autowired
    public StudentSpringService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Transactional(readOnly = true)
    public Optional<Student> findStudent(Long id) {
        return studentRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }

    @Transactional
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    public List<Student> saveAllStudents(List<Student> students) {
        Iterable<Student> iter = (Iterable<Student>) students.iterator();
        return studentRepository.saveAll(iter);
    }

    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }

    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }

}
