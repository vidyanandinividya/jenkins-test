package wiprofsd.webdev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wiprofsd.webdev.serviceImpl.EmployeeCountServiceImpl;

@RestController
@RequestMapping("/countService")
public class EmployeeCountController {
	
	@Autowired
	EmployeeCountServiceImpl countService;
	
	@GetMapping("/countEmployees")
	public long countEmployees()
	{
		return countService.countEmployees();
	}

}
