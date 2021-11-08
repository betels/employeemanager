package tech.getarrays.employeemanager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.getarrays.employeemanager.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	//void deleteEmployeeById(Long id);

	Employee findEmployeeById(Long id);

	

}
