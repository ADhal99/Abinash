package com.abd.FirstBoot.service;
import com.abd.FirstBoot.error.DepartmentNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abd.FirstBoot.entity.Department;
import com.abd.FirstBoot.error.DepartmentNotFoundException;
import com.abd.FirstBoot.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
	private DepartmentRepository departmentRepository;
	@Override
	public Department saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentRepository.save(department);
	}
	@Override
	public List<Department> fetchDepartments() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}
	@Override
	public Department fetchDepartmentById(Long deptId) throws DepartmentNotFoundException{
		// TODO Auto-generated method stub
		Optional<Department> department=departmentRepository.findById(deptId);
		if(!department.isPresent()) {
			throw new DepartmentNotFoundException("Department Not available...");
		}
		return department.get();
	}
	@Override
	public void deleteDepartmentById(Long deptId) {
		// TODO Auto-generated method stub
		departmentRepository.deleteById(deptId);
	}
	@Override
	public Department updateDepartmentById(Long deptId,Department department) {
		// TODO Auto-generated method stub
		Department depDB=departmentRepository.findById(deptId).get();
		if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
			depDB.setDepartmentName(department.getDepartmentName());
		}
		if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
			depDB.setDepartmentAddress(department.getDepartmentAddress());
		}
		if(Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
			depDB.setDepartmentCode(department.getDepartmentCode());
		}
		return departmentRepository.save(depDB);
	}
	@Override
	public Department fetchDepartmentByName(String deptName) {
		// TODO Auto-generated method stub
		return departmentRepository.findByDepartmentNameIgnoreCase(deptName);
	}
	

}
