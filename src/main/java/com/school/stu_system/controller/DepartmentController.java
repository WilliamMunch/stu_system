package com.school.stu_system.controller;

import com.school.stu_system.domain.Department;
import com.school.stu_system.service.DepartmentService;
import com.school.stu_system.domain.MyResponse;
import com.school.stu_system.domain.MyResponseEnums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;





    @GetMapping(value = "/departments")
    public MyResponse findAllDepartments()
    {
        return  new MyResponse<>(true, departmentService.findAllDepartments(), MyResponseEnums.OPERATE_SUCCESS );
    }


    @GetMapping(value = "/departments/{department_id}")
    public MyResponse findDepartmentById(@PathVariable("department_id") Integer department_id)
    {
        return new MyResponse<>(true,departmentService.findDepartmentById(department_id), MyResponseEnums.OPERATE_SUCCESS );
    }


    @PostMapping(value = "/departments")
    public MyResponse createDepartment(@RequestBody Department department)
    {
        return new MyResponse<>(true,departmentService.createDepartment(department), MyResponseEnums.OPERATE_SUCCESS );
    }
    @PutMapping(value = "/departments")
    public MyResponse updateDepartment(@RequestBody Department department)
    {
        return  new MyResponse<>(true,departmentService.updateDepartment(department), MyResponseEnums.OPERATE_SUCCESS );
    }

    @DeleteMapping(value = "/departments/{department_id}")
    public MyResponse deleteDepartment(@PathVariable("department_id") Integer department_id)
    {
        return  new MyResponse<>(true,departmentService.deleteDepartment(department_id), MyResponseEnums.OPERATE_SUCCESS );
    }




}
