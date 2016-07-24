package co.me.shackox.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import co.me.shackox.model.Department;
import co.me.shackox.model.Status;

public interface DepartmentDao {
	
	List<Department> getDepartments(Connection connection) throws SQLException;
	
	Department getDepartmentById(Connection connection, Department department) throws SQLException;
	
	Status saveDepartment(Connection connection, Department department) throws SQLException;

}
