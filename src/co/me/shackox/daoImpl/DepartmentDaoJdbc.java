package co.me.shackox.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.me.shackox.dao.DepartmentDao;
import co.me.shackox.model.Department;
import co.me.shackox.model.Status;

public class DepartmentDaoJdbc implements DepartmentDao {

	PreparedStatement statement;
	ResultSet rs;

	@Override
	public List<Department> getDepartments(Connection connection) throws SQLException {
		List<Department> departments = new ArrayList<Department>();
		statement = connection.prepareStatement("SELECT * FROM DEPARTMENTS");
		rs = statement.executeQuery();
		try {
			while (rs.next()) {
				Department department = new Department();
				department.setDepartment_id(rs.getLong("DEPARTMENT_ID"));
				department.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
				department.setManager_id(rs.getLong("MANAGER_ID"));
				department.setLocation_id(rs.getLong("LOCATION_ID"));
				departments.add(department);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connection.close();
		return departments;
	}

	@Override
	public Department getDepartmentById(Connection connection, Department department) throws SQLException {
		Department departmentRes = new Department();
		int index = 1;
		statement = connection.prepareStatement("SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID = ?");
		statement.setLong(index++, department.getDepartment_id());
		try {
			rs = statement.executeQuery();
			while (rs.next()) {
				departmentRes.setDepartment_id(rs.getLong("DEPARTMENT_ID"));
				departmentRes.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
				departmentRes.setManager_id(rs.getLong("MANAGER_ID"));
				departmentRes.setLocation_id(rs.getLong("LOCATION_ID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connection.close();
		return departmentRes;
	}

	@Override
	public Status saveDepartment(Connection connection, Department department) throws SQLException {
		Status statusRes = new Status();
		int index = 1;
		statement = connection.prepareStatement(
				"INSERT INTO DEPARTMENTS (DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID) VALUES (?, ?, ?, ?)");
		statement.setLong(index++, department.getDepartment_id());
		statement.setString(index++, department.getDepartment_name());
		statement.setLong(index++, department.getManager_id());
		statement.setLong(index++, department.getLocation_id());
		try {
			if (statement.executeUpdate() > 0) {
				statusRes.setStatus(201);
				statusRes.setError(false);
				statusRes.setMessage("Data saved!");
			}
		} catch (SQLException e) {
			statusRes.setStatus(500);
			statusRes.setError(true);
			statusRes.setMessage(e.getMessage());
			e.printStackTrace();
		}
		connection.close();
		return statusRes;
	}

}
