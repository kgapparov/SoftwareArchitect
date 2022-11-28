package repositories;

import domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findStudentByPhone(String phone);
    Student findStudentByName(String name);
    List<Student> findStudentByAddressList_City(String city);

    @Query("select s from Student s where s.email= :email")
    Student findStudentWithEmail(String email);

    @Query("select c from Student c where c.addressList.city = :city")
    List<Student>  findStudentsWithCity(String city);
}
