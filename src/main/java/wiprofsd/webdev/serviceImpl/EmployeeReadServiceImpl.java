package wiprofsd.webdev.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import wiprofsd.webdev.entity.Employee;
import wiprofsd.webdev.repository.EmployeeRepository;

@Service
public class EmployeeReadServiceImpl {
	
	@Autowired
	EmployeeRepository readRepository;
	public List<Employee> getAllEmployees()
	{
		return readRepository.findAll();
	}
	public List<Employee> getAllEmployeeswithNoEmail()
	{
		Employee empwithNoEmail=new Employee();
		empwithNoEmail.setEmail("");
		ExampleMatcher matcher=ExampleMatcher.matching().withMatcher("email",
				ExampleMatcher.GenericPropertyMatchers.exact()).withIgnorePaths("id","name");
		Example<Employee> example=Example.of(empwithNoEmail,matcher);
		return readRepository.findAll(example);
	}
	public Page<Employee> getEmployeesPaged()
	{
		Pageable first3Records=PageRequest.of(0, 3);
		return readRepository.findAll(first3Records);
	}
	public Page<Employee> getEmployeesCustomPaged(int pageNumber,int numberofrecordsinapage)
	{
		Pageable first3Records=PageRequest.of(pageNumber, numberofrecordsinapage);
		return readRepository.findAll(first3Records);
	}
	public List<Employee> getEmployeesWithLatestAddedOrder()
	{
		return readRepository.findAll(Sort.by(Direction.DESC,"id"));
	}
	public List<Employee> getEmployeesCustomSortedById(Direction direction)
	{
		return readRepository.findAll(Sort.by(direction,"id"));
	}
	
	
	
	

}
