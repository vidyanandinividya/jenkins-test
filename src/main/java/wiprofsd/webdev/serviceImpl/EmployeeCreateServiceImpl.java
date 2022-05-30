package wiprofsd.webdev.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wiprofsd.webdev.entity.Employee;
import wiprofsd.webdev.repository.EmployeeRepository;

@Service
public class EmployeeCreateServiceImpl {

	@Autowired
	EmployeeRepository createRepository;
	public String addSingleEmployee(Employee employee)
	{
		createRepository.save(employee);
		createRepository.flush();
		return "Employee record saved";
	}
	public String addAllEmployees(List<Employee> employees)
	{
		createRepository.saveAll(employees);
		createRepository.flush();
		return "All Employee record saved";
	}
	public Employee addEmployeesWithSaveAndFlush(Employee employee)
	{
		
		return createRepository.saveAndFlush(employee);
	}
}
