/**
 * @author Ostrovskiy Dmitriy
 * @created 06.05.2020
 * Student
 * @version v1.0
 */

package ru.geekbrains.hw5_hibernate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "students")
public class Student implements Serializable {
    private static final long serialVersionUID = -2750973356670718107L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "mark")
    private int mark;

//    @OneToMany(mappedBy = "Student", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Mark> marks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Student() {
    }

    public Student(String name, int mark) {
        this.name = name;
        this.mark = mark;
//        marks = new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.format("Student [id = %d, name = %s, mark = %d]", id, name, mark);
    }
}

