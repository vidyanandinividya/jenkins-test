package wiprofsd.webdev.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wiprofsd.webdev.entity.Employee;
import wiprofsd.webdev.repository.EmployeeRepository;

@Service
public class EmployeeDeleteServiceImpl {
	
	@Autowired
	EmployeeRepository deleteRepository;
	
	public String deleteOneEmployee(Employee employee)
	{
		deleteRepository.delete(employee);
		return "Deleted Employee"+employee;
	}
	public String pruneTable()
	{
		deleteRepository.deleteAll();
		return "prune complete";
	}
	public String deleteAllThese(List<Employee> employees)
	{
		deleteRepository.deleteAll(employees);
		return "Delete All Employees";
	}
	public String DeleteAllInBatch()
	{
		deleteRepository.deleteAllInBatch();
		return "Delete All in Batch Completed";
	}

}
