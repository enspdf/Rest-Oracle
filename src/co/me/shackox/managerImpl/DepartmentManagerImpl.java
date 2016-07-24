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
		department.setDepartment_id(departmentReq.getDepartment_id());
		Connection conn = db.getConnection();
		department = dao.getDepartmentById(conn, department);
		return department;
	}
	
	@Override
	public Status saveDepartment(Department department) throws Exception {
		Status statusRes = new Status();
		Department departmentReq = new Department();
		departmentReq.setDepartment_name(department.getDepartment_name());
		departmentReq.setManager_id(department.getManager_id());
		departmentReq.setLocation_id(departmentReq.getLocation_id());
		Connection conn = db.getConnection();
		statusRes = dao.saveDepartment(conn, departmentReq);
		return statusRes;
	}

}
