package com.abd.FirstBoot.service;

import java.util.List;

import com.abd.FirstBoot.entity.Department;
import com.abd.FirstBoot.error.DepartmentNotFoundException;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public java.util.List<Department> fetchDepartments();

	public Department fetchDepartmentById(Long deptId) throws DepartmentNotFoundException;

	public void deleteDepartmentById(Long deptId);

	public Department updateDepartmentById(Long deptId,Department department);

	public Department fetchDepartmentByName(String deptName);

}
