package com.school.stu_system.controller;

import com.school.stu_system.domain.Department;
import com.school.stu_system.domain.Student;
import com.school.stu_system.service.DepartmentService;
import com.school.stu_system.util.ResponseBean;
import com.school.stu_system.util.ResponseBean;
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
    public ResponseBean findAllDepartments()
    {
        return  new ResponseBean<>(true, departmentService.findAllDepartments());
    }


    @GetMapping(value = "/{department_id}")
    public ResponseBean findDepartmentById(@PathVariable("department_id") Integer department_id)
    {
        return new ResponseBean<>(true,departmentService.findDepartmentById(department_id));
    }


    @PostMapping
    public ResponseBean createDepartment(@RequestBody Department department)
    {
        return new ResponseBean<>(true,departmentService.createDepartment(department));
    }
    @PutMapping
    public ResponseBean updateDepartment(@RequestBody Department department)
    {
        return  new ResponseBean<>(true,departmentService.updateDepartment(department));
    }

    @DeleteMapping(value = "/{department_id}")
    public ResponseBean deleteDepartment(@PathVariable("department_id") Integer department_id)
    {
        return  new ResponseBean<>(true,departmentService.deleteDepartment(department_id));
    }
    @GetMapping(value = "/students/{department_id}")
    public ResponseBean findStudentByDepartment(@PathVariable("department_id") Integer department_id)
    {
        return  new ResponseBean<>(true,departmentService.findStudentByDepartment(department_id));
    }



}
