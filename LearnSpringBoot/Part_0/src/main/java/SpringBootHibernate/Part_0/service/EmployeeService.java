package SpringBootHibernate.Part_0.service;

import java.util.List;

import SpringBootHibernate.Part_0.model.Employee;

public interface EmployeeService {
	
	List<Employee> get();
	
	Employee get(int id);
	
	void save(Employee employee);
	
	void delete(int id); 
}