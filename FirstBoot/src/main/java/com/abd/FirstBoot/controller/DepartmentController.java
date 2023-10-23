package com.abd.FirstBoot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.abd.FirstBoot.entity.Department;
import com.abd.FirstBoot.error.DepartmentNotFoundException;
import com.abd.FirstBoot.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	private final Logger LOGGER=LoggerFactory.getLogger(DepartmentController.class);
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department  department) {
		LOGGER.info("Department ::"+department.getDepartmentName()+" saved successfully");
		return departmentService.saveDepartment(department);
		
	}
	@GetMapping("/departments")
	public List<Department> fetchDepartments(){
		return departmentService.fetchDepartments();
	}
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long deptId) throws DepartmentNotFoundException{
		return departmentService.fetchDepartmentById(deptId);
	}
	@GetMapping("/departments/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String deptName){
		return departmentService.fetchDepartmentByName(deptName);
	}
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") Long deptId){
		departmentService.deleteDepartmentById(deptId);
		return "Department delete successufully....";
	}
	@PutMapping("/departments/{id}")
	public Department updateDepartmentById(@PathVariable("id") Long deptId,@RequestBody Department  department){
		return departmentService.updateDepartmentById(deptId,department);
		
	}

}

