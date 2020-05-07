/**
 * @author Ostrovskiy Dmitriy
 * @created 06.05.2020
 * StudentDaoImpl
 * @version v1.0
 */

package ru.geekbrains.hw5_hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class StudentDaoImpl implements StudentDAO{

    @Override
    @Transactional
    public void initDB() {
        Session session = null;
        try {
            String sql = Files.lines(Paths.get("full.sql")).collect(Collectors.joining(" "));
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.createNativeQuery(sql).executeUpdate();
            session.getTransaction().commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Student findById(Long id) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        Student student = session.get(Student.class, id);
        tx1.commit();
        session.close();
        return student;
    }

    @Override
    public void save(Student student) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(student);
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Student student) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(student);
        tx1.commit();
        session.close();
    }

    @Override
    public void delete(Student student) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(student);
        tx1.commit();
        session.close();
    }

    public int deleteAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
            try {
                session.createQuery("DELETE FROM Student").executeUpdate();

            } catch(Exception e){
                e.printStackTrace();
            }
        tx1.commit();
        Transaction tx2 = session.beginTransaction();
        int size = findAll().size();
        tx2.commit();
        session.close();
        return size;
    }

    @Override
    @Transactional
    public List <Student> findAll() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        List<Student> students = (List<Student>) HibernateSessionFactory.getSessionFactory().
                openSession().createQuery("FROM " + Student.class.getSimpleName()).list();
        tx1.commit();
        session.close();
        return students;
    }

    public void saveAllStudents(List<Student> students) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        for (Student student: students) {
            session.save(student);
        }
        tx1.commit();
        session.close();
    }
}
