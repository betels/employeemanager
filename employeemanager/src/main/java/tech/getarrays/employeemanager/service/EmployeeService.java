package tech.getarrays.employeemanager.service;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.getarrays.employeemanager.Repository.EmployeeRepository;
import tech.getarrays.employeemanager.exception.UserNotFoundException;
import tech.getarrays.employeemanager.model.Employee;

@Service
public class EmployeeService {
	
	private final EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		
		this.employeeRepository = employeeRepository;
	}
	
	public Employee addEmployee(Employee employee) {
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepository.save(employee);
	}
	
	public List<Employee> findAllEmployee(){
		return employeeRepository.findAll();
	}
	
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

    public Employee findEmployeeById(Long id) {
    	Employee employee = employeeRepository.findEmployeeById(id);
    	if(employee == null) {
    		throw new UserNotFoundException("User by id " + id + " was not found");
    	}
        return employee;
    }

	
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}

}
