package wiprofsd.webdev;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort.Direction;

import lombok.extern.slf4j.Slf4j;
import wiprofsd.webdev.entity.Employee;
import wiprofsd.webdev.serviceImpl.EmployeeCountServiceImpl;
import wiprofsd.webdev.serviceImpl.EmployeeCreateServiceImpl;
import wiprofsd.webdev.serviceImpl.EmployeeDeleteServiceImpl;
import wiprofsd.webdev.serviceImpl.EmployeeReadServiceImpl;

@SpringBootApplication
@Slf4j

public class EmployeeManagementSystemApplication implements CommandLineRunner {
	
	@Autowired
	EmployeeReadServiceImpl empread;
	
	@Autowired
	EmployeeCreateServiceImpl empcreate;
	
	@Autowired
	EmployeeCountServiceImpl empcount;
	
	@Autowired
	EmployeeDeleteServiceImpl empdelete;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystemApplication.class, args);
		System.out.println("HELLO World");
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("inside main method");
		//readServiceImplMethodExecution();
		
		//createServiceImplMethodExecution();
		//deleteServiceImplMethodExecution();
	}

	private void deleteServiceImplMethodExecution() {
		log.info("count the number of employees->{}",empcount.countEmployees());
		log.info("Dleted one Employee->{}",empdelete.deleteOneEmployee(Employee.
				builder().id(1).name("john").email("john@gmail.com").build()));
		log.info("Prune Employee Table->{}",empdelete.pruneTable());
		List<Employee> employees=new ArrayList<>();
		employees.add(Employee.builder().id(9).name("xyz").email("xyz@gmail.com").build());
		employees.add(Employee.builder().id(10).name("hans").email("hans@gmail.com").build());
		log.info("Delete All these->{}",
				empdelete.deleteAllThese(employees));
		
		log.info("Delete All in Batch->{}",empdelete.DeleteAllInBatch());
	}

	private void createServiceImplMethodExecution() {
		log.info("Persist a single employee->{}",
				empcreate.addSingleEmployee(
						Employee.builder().id(8).name("abc").email("abc@gmail.com").build()));
		List<Employee> employees=new ArrayList<>();
		employees.add(Employee.builder().id(9).name("xyz").email("xyz@gmail.com").build());
		employees.add(Employee.builder().id(10).name("hans").email("hans@gmail.com").build());
		log.info("Persist all employees->{}",
				empcreate.addAllEmployees(employees));
		log.info("Add Employees with save and flush->{}",
				empcreate.addEmployeesWithSaveAndFlush(
						Employee.builder().id(11).name("cielo").email("cielo@gmail.com").build()));
	}
	private void readServiceImplMethodExecution()
	{
		log.info("Fetch All Employees->{}",empread.getAllEmployees());
		log.info("Fetch All Employees with no email->{}",empread.getAllEmployeeswithNoEmail());
		log.info("Fetch employees in Page format->{}",
				empread.getEmployeesPaged().get().collect(Collectors.toList()));
		log.info("Fetch employees in  Custome Page format->{}",
				empread.getEmployeesCustomPaged(0,2).get().collect(Collectors.toList()));
		log.info("Fetch employees with lasted added order->{}",
				empread.getEmployeesWithLatestAddedOrder());
		log.info("Fetch employees with Custome sorted by id->{}",
				empread.getEmployeesCustomSortedById(Direction.ASC));
	}

}
