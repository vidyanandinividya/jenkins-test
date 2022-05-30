package wiprofsd.webdev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wiprofsd.webdev.entity.Employee;
import wiprofsd.webdev.serviceImpl.EmployeeCreateServiceImpl;

@RestController
@RequestMapping("createService")
public class EmployeeCreateController {
	@Autowired
	EmployeeCreateServiceImpl createService;
	
	@PostMapping("/addSingleEmployee")
	public String addSingleEmployee(Employee employee)
	{
		return createService.addSingleEmployee(employee);
	}
	@PostMapping("/addAllEmployees")
	public String addAllEmployees(List<Employee> employees)
	{
		return createService.addAllEmployees(employees);
	}
	

}
