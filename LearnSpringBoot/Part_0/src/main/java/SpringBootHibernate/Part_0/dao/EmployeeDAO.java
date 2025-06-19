
package SpringBootHibernate.Part_0.dao;

import java.util.List;

import  SpringBootHibernate.Part_0.model.Employee;

public interface EmployeeDAO {
	
	List<Employee> get();
	
	Employee get(int id);
	
	void save(Employee employee);
	
	void delete(int id); 
}
