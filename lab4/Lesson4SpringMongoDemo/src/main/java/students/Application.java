package students;

import students.domain.Address;
import students.domain.Student;
import students.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import students.repository.StudentRepository;

import java.util.List;


@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private StudentRepository studentRepository;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//create Students
		Student student1 = new Student(101l, "John Doe", "jond@gmail.com", "0462234562");
		Address address = new Address("1000 N 4th Street", "Fairfield", "52556");
		student1.setAddress(address);
		studentRepository.save(student1);

		Student student2 = new Student(102l, "Alice Dane", "aliceDane@gmail.com", "1235311234");
		Address address2 = new Address("1123 N 4th Street", "Fairfield", "52556");
		student2.setAddress(address2);
		studentRepository.save(student2);

		Student student3 = new Student(103l, "Eddy Merphey", "eddyM@gmail.com", "04622124562");
		Address address3 = new Address("1000 W 4th Street", "Iowa", "234332");
		student3.setAddress(address3);
		studentRepository.save(student3);

		System.out.println("-----------find by phone ----------------");
		System.out.println(studentRepository.findStudentByPhone("04622124562"));
		System.out.println("-----------find by email ----------------");
		System.out.println(studentRepository.findStudentWithEmail("eddyM@gmail.com"));
		System.out.println("-----------find students within a city ----------------");
		List<Student> students = studentRepository.findStudentWithCity("Fairfield");
		for (Student stu : students){
			System.out.println(stu);
		}

		System.out.println("-----------find by name ----------------");
		System.out.println(studentRepository.findStudentByName("Alice Dane"));

	}

}
