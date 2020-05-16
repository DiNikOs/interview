/**
 * @author Ostrovskiy Dmitriy
 * @created 16.05.2020
 * StudentController
 * @version v1.0
 */

package ru.geekbrains.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.persistence.entity.Student;
import ru.geekbrains.service.StudentSpringService;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private StudentSpringService studentSpringService;

    public StudentController() {
    }

    @Autowired
    public StudentController(StudentSpringService studentSpringService) {
        this.studentSpringService = studentSpringService;
    }

    @GetMapping("")
//    @RequestMapping(value = "", method = RequestMethod.GET)
    public String allStudents(@RequestParam(value = "id", required = false) Long id,Model model) {
        Student student = new Student();
        if (id!=null) {
            student = studentSpringService.findStudent(id).get();
        }
        List<Student> students = studentSpringService.findAllStudent();
        model.addAttribute("student", student);
        model.addAttribute("students", students);
        return "students";
    }

    @PostMapping("/create")
    public String addNewStudent(@ModelAttribute(name = "student") Student student, Model model) {
        studentSpringService.saveStudent(student);
        model.addAttribute("action", "create");
        return "redirect:/students";
    }

    @PostMapping("/edit")
    public String editStudent(@RequestParam("id") Long id, Model model) {
        Student student = studentSpringService.findStudent(id)
                .orElseThrow(() -> new IllegalStateException("Student not found!"));
      model.addAttribute("student", student);
      model.addAttribute("action", "edit");
        return "students";
    }

    @PostMapping("/delete")
    public String deleteStudent(@RequestParam("id") Long id, Model model) {
        Student student = studentSpringService.findStudent(id)
                .orElseThrow(() -> new IllegalStateException("Student not found!"));
        studentSpringService.deleteStudent(student);
        return "redirect:/students";
    }
}
