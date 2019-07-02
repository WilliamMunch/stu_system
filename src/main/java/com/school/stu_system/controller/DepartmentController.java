package com.school.stu_system.controller;

import com.school.stu_system.domain.Department;
import com.school.stu_system.domain.Student;
import com.school.stu_system.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;





    @GetMapping
    public ResponseEntity<List<Department>> findAllDepartments()
    {
        return new ResponseEntity<List<Department>>(departmentService.findAllDepartments(), HttpStatus.OK);
    }


    @GetMapping(value = "/{department_id}")
    public ResponseEntity<Department> findDepartmentById(@PathVariable("department_id") Integer department_id)
    {
        return new ResponseEntity<Department>(departmentService.findDepartmentById(department_id), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Department> createDepartment(@RequestBody Department department)
    {
        return new ResponseEntity<>(departmentService.createDepartment(department), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Department> updateDepartment(@RequestBody Department department)
    {
        return new ResponseEntity<>(departmentService.updateDepartment(department), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{department_id}")
    public ResponseEntity<Department> deleteDepartment(@PathVariable("department_id") Integer department_id)
    {
        return new ResponseEntity<>(departmentService.deleteDepartment(department_id), HttpStatus.NO_CONTENT);
    }
    @GetMapping(value = "/students/{department_id}")
    public ResponseEntity<List<Student>> findStudentByDepartment(@PathVariable("department_id") Integer department_id)
    {
        return new ResponseEntity<List<Student>>(departmentService.findStudentByDepartment(department_id), HttpStatus.OK);
    }



}
