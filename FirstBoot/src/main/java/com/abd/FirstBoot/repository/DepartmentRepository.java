package com.abd.FirstBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abd.FirstBoot.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
	public Department findByDepartmentNameIgnoreCase(String deptName);

}
