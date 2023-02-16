package com.example.learning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;


import java.util.List;
import java.util.Optional;

@RestController
public class WeatherController {
	
	@Autowired
	DepartmentRepository departmentRepositoryTest;
	
	@GetMapping("/hello")
	public ResponseEntity<String> hello(){
		throw new BusinessException("BUSINESS","businessEXception");
		//return ResponseEntity.status(HttpStatus.CREATED).body("hello");
	}
	  @PostMapping("/departments")
	  public ResponseEntity<Department> saveDepartment( @RequestBody Department department){
		  departmentRepositoryTest.save(department);
		  return  ResponseEntity.status(HttpStatus.CREATED).body(department);
	  }
	  @GetMapping("/departments")
	  public ResponseEntity<List<Department>> getDepartments( @RequestBody Department department){
		  RestTemplate restTemplate = new RestTemplate();
		  HttpHeaders  header = new HttpHeaders();
		  header.setContentType(MediaType.APPLICATION_JSON);
		  HttpEntity httpEntity = new HttpEntity(header);
		  
		   ResponseEntity<Department> departmentRes = restTemplate.exchange("http://localhost:8080//departments/1",HttpMethod.GET,httpEntity,Department.class);

		  Department departmentResParsed =  departmentRes.getBody();
		  
		  Mono<Department> departmentAsynch  = WebClient.create().get().uri("http://localhost:8080//departments/1").retrieve().bodyToMono(Department.class);
		  departmentAsynch.subscribe(p -> System.out.println(p.getDepartmentAddress()));
		  System.out.println("getting out side blocking");
		   // return  ResponseEntity.status(HttpStatus.OK).body(departmentRepositoryTest.findAll(Sort.by(Sort.Direction.DESC,"departmentName")));
		return  ResponseEntity.status(HttpStatus.OK).body(departmentRepositoryTest.findAll( PageRequest.of(0, 5
				, Sort.by("departmentName"))).getContent());
		  
	  }
	  @GetMapping("/departments/{id}")
	  public ResponseEntity<Department> getDepartment( @PathVariable("id") Long  id){
		  return  ResponseEntity.status(HttpStatus.OK).body(departmentRepositoryTest.findById(id).orElse(new Department()));
		  
	  }
	  @PutMapping("/departments/{id}")
	  public ResponseEntity<Department> getDepartment(@RequestBody Department department, @PathVariable("id") Long  id){
		  Department dep = departmentRepositoryTest.findById(id).get();
		  dep.setDepartmentCode(department.getDepartmentCode());
		  dep.setDepartmentName(department.getDepartmentName());
		  departmentRepositoryTest.save(dep);
		  return  ResponseEntity.status(HttpStatus.OK).body(dep);
		  
	  }
	  @DeleteMapping("/departments/{id}")
	  public String deleteDepartment(@PathVariable("id") Long  id){
		  departmentRepositoryTest.deleteById(id);
		  return  "deleted";  
	  }
	  @GetMapping("/departmentsName/{name}/{code}")
	  public ResponseEntity<Department> getDepartment( @PathVariable("name") String   name,@PathVariable("code") String   code){
		  
		  return  ResponseEntity.status(HttpStatus.OK).body(departmentRepositoryTest.findByDepartmentNameAndDepartmentCode(name,code).orElse(new Department()));
		  
	  }

}
