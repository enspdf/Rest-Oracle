package co.me.shackox.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;

import co.me.shackox.managerImpl.DepartmentManagerImpl;
import co.me.shackox.model.Department;
import co.me.shackox.model.Status;

@Path("api")
public class ws {

	Gson gson = new Gson();

	@GET
	@Path("departments")
	@Produces(MediaType.APPLICATION_JSON)
	public String departments() {
		String departments = null;
		List<Department> listDepartments = new ArrayList<Department>();
		try {
			listDepartments = new DepartmentManagerImpl().getDepartments();
			// departments = gson.toJson(listDepartments);
			departments = new JSONArray(listDepartments).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return departments;
	}

	@GET
	@Path("departments/{department_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String departmentsById(@PathParam("department_id") Long department_id) {
		Department departmentReq = new Department();
		String department = null;
		try {
			if (department_id != null) {
				departmentReq.setDepartment_id(department_id);
				Department depart = new DepartmentManagerImpl().getDepartmentByID(departmentReq);
				// department = gson.toJson(depart);
				department = new JSONObject(depart).toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return department;
	}

	@POST
	@Path("departments")
	@Produces(MediaType.APPLICATION_JSON)
	public String saveDepartments(@FormParam("department_name") String department_name,
			@FormParam("manager_id") Long manager_id, @FormParam("location_id") Long location_id) {
		Department department = new Department();
		String status = null;
		try {
			if(department_name != null && manager_id != null && location_id != null ) {
				department.setDepartment_name(department_name);
				department.setManager_id(manager_id);
				department.setLocation_id(location_id);
				Status statusRes = new DepartmentManagerImpl().saveDepartment(department);
				status = new JSONObject(statusRes).toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
