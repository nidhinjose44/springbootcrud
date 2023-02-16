package com.example.learning;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository("departmentRepository")
public interface DepartmentRepository extends JpaRepository<Department,Long> {

	Optional<Department> findByDepartmentNameAndDepartmentCode(String name,String code);
	
	
	//public List<Department> findByDepartmentName(String name);

}
