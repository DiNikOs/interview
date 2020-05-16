/**
 * @author Ostrovskiy Dmitriy
 * @created 06.05.2020
 * StudentDAO
 * @version v1.0
 */

package ru.geekbrains.hw5_hibernate;
import java.util.List;

public interface StudentDAO {

    void initDB();
    Student findById (Long id);
    void save (Student newInstance);
    void update (Student transientObject);
    void delete (Student persistentObject);
    List<Student> findAll();
}
