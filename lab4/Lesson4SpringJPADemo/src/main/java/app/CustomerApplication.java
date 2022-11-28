package app;

import java.util.List;

import domain.Address;
import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import repositories.StudentRepository;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain") 
public class CustomerApplication implements CommandLineRunner{
	
	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// create student
		Student student = new Student("John doe", "johnd@acme.com", "06223341678");
		Address address = new Address("7100 N street", "Iowa", "35336");
		student.setAddressList(address);
		studentRepository.save(student);

		Student student1 = new Student("Alisa de", "alisaDe@acme.com", "0622341678");
		Address address1 = new Address("334 E street", "Fairfield", "23324");
		student1.setAddressList(address);
		studentRepository.save(student1);

		Student student2 = new Student("DD Doe", "DD Doe@acme.com", "06223241678");
		Address address2 = new Address("7100 N street", "Iowa", "35336");
		student2.setAddressList(address);
		studentRepository.save(student2);


//get students
		System.out.println(studentRepository.findById(1l).get());
		System.out.println(studentRepository.findById(2l).get());
		System.out.println(studentRepository.findById(3l).get());

		System.out.println("-----------All Students ----------------");
		System.out.println(studentRepository.findAll());
		//update student
		student = studentRepository.findById(1l).get();
		student.setEmail("jd@gmail.com");
		studentRepository.save(student);
		System.out.println("-----------find by phone ----------------");
		System.out.println(studentRepository.findStudentByPhone("0622341678"));
		System.out.println("-----------find by email ----------------");
		System.out.println(studentRepository.findStudentWithEmail("alisaDe@acme.com"));
		System.out.println("-----------find students with a certain city ----------------");
		List<Student> students = studentRepository.findStudentByAddressList_City("Visa");
		for (Student st : students){
			System.out.println(st);
		}

		System.out.println("-----------find by name ----------------");
		System.out.println(studentRepository.findStudentByName("John doe"));
		
	}

}
