package net.javaguides.springbootbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}
/*
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String...args) throws Exception {
		this.employeeRepository.save(new Employee("Ramesh", "Fadatare", "ramesh@gmail.com"));
		this.employeeRepository.save(new Employee("Tom", "Cruise", "tom@gmail.com"));
		this.employeeRepository.save(new Employee("Tony", "Stark", "tony@gmail.com"));
	}
 */
}
