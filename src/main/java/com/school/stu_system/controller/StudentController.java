package com.school.stu_system.controller;

import com.school.stu_system.domain.Student;
import com.school.stu_system.service.CourseService;
import com.school.stu_system.service.DepartmentService;
import com.school.stu_system.service.StudentService;
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
@Api(tags="学生数据接口")
public class StudentController{
    @Autowired
    StudentService studentService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    CourseService courseService;
    
    
    @ApiOperation(value="查询所有的学生信息")
    @GetMapping(value = "/students")
    public MyResponse findAllStudents()
    {
        return  new MyResponse<>(true,studentService.findAllStudents(), MyResponseEnums.OPERATE_SUCCESS  );
    }
    
    
    @ApiOperation(value="查询某一学生信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "student_id", value = "学生号", required = true, paramType = "path")
    })
    @GetMapping(value = "/students/{student_id}")
    public MyResponse findStudentById(@PathVariable("student_id") Integer student_id)
    {
        return  new MyResponse<>(true,studentService.findStudentById(student_id) , MyResponseEnums.OPERATE_SUCCESS );
    }

    
    @ApiOperation(value="添加某一学生信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "student", value = "学生实体", required = true, paramType = "body")
    })
    @PostMapping(value = "/students")
    public MyResponse createStudent(@RequestBody Student student)
    {
        return  new MyResponse<>(true,studentService.createStudent(student) , MyResponseEnums.OPERATE_SUCCESS );
    }
    
    
    @ApiOperation(value="更新某一学生信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "student", value = "学生实体", required = true,paramType = "body")
    })
    @PutMapping(value = "/students")
    public MyResponse updateStudent(@RequestBody Student student)
    {
        return  new MyResponse<>(true,studentService.updateStudent(student) , MyResponseEnums.OPERATE_SUCCESS );
    }
    
    
    @ApiOperation(value="删除某一学生信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "student_id", value = "学生号", required = true, paramType = "path")
    })
    @DeleteMapping(value = "/students/{student_id}")
    public MyResponse deleteStudent(@PathVariable("student_id") Integer student_id)
    {
        return  new MyResponse<>(true,studentService.deleteStudent(student_id), MyResponseEnums.OPERATE_SUCCESS );
    }


    @ApiOperation(value="查询某一学院的学生信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "department_id", value = "学院号", required = true, paramType = "path")
    })
    @GetMapping(value = "/departments/{department_id}/students")
    public MyResponse findStudentsByDepartment(@PathVariable("department_id") Integer department_id)
    {
        return  new MyResponse<>(true,departmentService.findStudentsByDepartment(department_id), MyResponseEnums.OPERATE_SUCCESS );
    }

    @ApiOperation(value="查询选择某一课程的学生信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "course_id", value = "课程号", required = true, paramType = "path")
    })
    @GetMapping(value = "/courses/{course_id}/students")
    public MyResponse findStudentsByCourse(@PathVariable("course_id") Integer course_id)
    {
        return  new MyResponse<>(true,courseService.findStudentsByCourse(course_id), MyResponseEnums.OPERATE_SUCCESS );
    }

    @ApiOperation(value="某一学生选择某一课程")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "student_id", value = "学生号", required = true,paramType = "path"),
            @ApiImplicitParam(name = "course_id", value = "课程号", required = true,paramType = "path")
    })
    @PostMapping(value = "/courses/{course_id}/students/{student_id}/select")
    public MyResponse selectCourseByStudent(@PathVariable("student_id") Integer student_id, @PathVariable("course_id") Integer course_id)
    {
        return  new MyResponse<>(true,studentService.selectCourseByStudent(student_id,course_id), MyResponseEnums.OPERATE_SUCCESS );
    }



    @ApiOperation(value="某一学生退选某一课程")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "student_id", value = "学生号", required = true, paramType = "path"),
            @ApiImplicitParam(name = "course_id", value = "课程号", required = true, paramType = "path")
    })
    @PostMapping(value = "/courses/{course_id}/students/{student_id}/withdraw")
    public MyResponse withdrawCourseByStudent(@PathVariable("student_id") Integer student_id, @PathVariable("course_id") Integer course_id)
    {
        return  new MyResponse<>(true,studentService.withdrawCourseByStudent(student_id,course_id), MyResponseEnums.OPERATE_SUCCESS );
    }


}
