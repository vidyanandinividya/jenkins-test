package wiprofsd.webdev.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import wiprofsd.webdev.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

	
}
