package wiprofsd.webdev.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wiprofsd.webdev.repository.EmployeeRepository;

@Service
public class EmployeeCountServiceImpl {
	
	@Autowired
	EmployeeRepository countRepository;
	
	public long countEmployees()
	{
		return countRepository.count();
	}

}
