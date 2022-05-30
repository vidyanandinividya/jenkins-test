package wiprofsd.webdev.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import wiprofsd.webdev.model.Employee;

@RestController
@Slf4j
public class ExampleController {
	@CrossOrigin("http://localhost:4200")
	@GetMapping("/getInfo")
	public Employee getInfo()
	{
		log.info("inside get method");
		Employee e=new Employee();
		e.setId(2);
		e.setName("Jack");
		e.setEmail("jack@mail.com");
		return e;
	}

}
