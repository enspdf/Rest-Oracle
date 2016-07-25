package co.me.shackox.manager;

import java.util.List;

import co.me.shackox.model.Department;
import co.me.shackox.model.Status;

public interface DepartmentManager {
	
	List<Department> getDepartments() throws Exception;
	
	Department getDepartmentByID(Department department) throws Exception;
	
	Status saveDepartment(Department department) throws Exception;
	
	//Status updateDepartment(Department department) throws Exception;
	
	Status deleteDepartment(Department department) throws Exception;

}
