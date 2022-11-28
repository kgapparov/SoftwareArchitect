package students.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import students.domain.Student;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, Integer> {

    Student findStudentByName(String name);

    Student findStudentByPhone(String phone);

    @Query("{ email:?0}")
    Student findStudentWithEmail(String email);

    @Query("{'address.city':?0}")
    List<Student> findStudentWithCity(String city);
}

