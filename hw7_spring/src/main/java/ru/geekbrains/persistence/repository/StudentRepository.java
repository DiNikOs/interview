/**
 * @author Ostrovskiy Dmitriy
 * @created 06.05.2020
 * StudentDAO
 * @version v1.0
 */

package ru.geekbrains.persistence.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.persistence.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

//    Optional<Student> findById(Long id);

//    Student save(Student newInstance);
//    void update(Student transientObject);
//    void delete(Student persistentObject);
//    List<Student> findAll();
}
