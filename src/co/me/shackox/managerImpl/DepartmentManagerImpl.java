package co.me.shackox.managerImpl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import co.me.shackox.config.DatabaseConnection;
import co.me.shackox.daoImpl.DepartmentDaoJdbc;
import co.me.shackox.manager.DepartmentManager;
import co.me.shackox.model.Department;
import co.me.shackox.model.Status;

public class DepartmentManagerImpl implements DepartmentManager {
	
	DatabaseConnection db = new DatabaseConnection();
	DepartmentDaoJdbc dao = new DepartmentDaoJdbc();

	@Override
	public List<Department> getDepartments() throws Exception {
		List<Department> departments = new ArrayList<Department>();
		Connection conn = db.getConnection();
		departments = dao.getDepartments(conn);
		return departments;
	}
	
	@Override
	public Department getDepartmentByID(Department departmentReq) throws Exception {
		Department department = new Department();
		Connection conn = db.getConnection();
		department = dao.getDepartmentById(conn, departmentReq);
		return department;
	}
	
	@Override
	public Status saveDepartment(Department department) throws Exception {
		Status statusRes = new Status();
		Connection conn = db.getConnection();
		statusRes = dao.saveDepartment(conn, department);
		return statusRes;
	}

}
