package com.school.stu_system.controller;

import com.school.stu_system.domain.Department;
import com.school.stu_system.service.DepartmentService;
import com.school.stu_system.domain.MyResponse;
import com.school.stu_system.domain.MyResponseEnums;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "")
@Api(tags = "学院数据接口")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;


    @ApiOperation(value = "查询所有学院信息")
    @GetMapping(value = "/departments")
    public MyResponse findAllDepartments() {
        return new MyResponse<>(true, departmentService.findAllDepartments(), MyResponseEnums.OPERATE_SUCCESS);
    }


    @ApiOperation(value = "查询某一学院信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "department_id", value = "学院号", required = true, paramType = "path")
    })
    @GetMapping(value = "/departments/{department_id}")
    public MyResponse findDepartmentById(@PathVariable("department_id") Integer department_id) {
        return new MyResponse<>(true, departmentService.findDepartmentById(department_id), MyResponseEnums.OPERATE_SUCCESS);
    }


    @ApiOperation(value = "添加某一学院信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "department", value = "学院实体", required = true, paramType = "body")
    })
    @PostMapping(value = "/departments")
    public MyResponse createDepartment(@RequestBody Department department) {
        return new MyResponse<>(true, departmentService.createDepartment(department), MyResponseEnums.OPERATE_SUCCESS);
    }


    @ApiOperation(value = "更新某一学院信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "department", value = "学院实体", required = true, paramType = "body")
    })
    @PutMapping(value = "/departments")
    public MyResponse updateDepartment(@RequestBody Department department) {
        return new MyResponse<>(true, departmentService.updateDepartment(department), MyResponseEnums.OPERATE_SUCCESS);
    }


    @ApiOperation(value = "删除某一学院信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "department_id", value = "学院号", required = true, paramType = "path")
    })
    @DeleteMapping(value = "/departments/{department_id}")
    public MyResponse deleteDepartment(@PathVariable("department_id") Integer department_id) {
        return new MyResponse<>(true, departmentService.deleteDepartment(department_id), MyResponseEnums.OPERATE_SUCCESS);
    }


}
