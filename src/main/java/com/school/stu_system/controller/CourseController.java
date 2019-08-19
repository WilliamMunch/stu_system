package com.school.stu_system.controller;

import com.school.stu_system.domain.Course;
import com.school.stu_system.service.StudentService;
import com.school.stu_system.service.DepartmentService;
import com.school.stu_system.service.CourseService;
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
@Api(tags = "课程数据接口")
public class CourseController {
    @Autowired
    StudentService studentService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    CourseService courseService;

    @ApiOperation(value = "查询所有课程信息")
    @GetMapping(value = "/courses")
    public MyResponse findAllCourses() {
        return new MyResponse<>(true, courseService.findAllCourses(), MyResponseEnums.OPERATE_SUCCESS);
    }


    @ApiOperation(value = "查询某一课程信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "course_id", value = "课程号", required = true, paramType = "path")
    })
    @GetMapping(value = "/courses/{course_id}")
    public MyResponse findCourseById(@PathVariable("course_id") Integer course_id) {
        return new MyResponse<>(true, courseService.findCourseById(course_id), MyResponseEnums.OPERATE_SUCCESS);
    }

    @ApiOperation(value = "添加某一课程信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "course", value = "课程实体", required = true, paramType = "body")
    })
    @PostMapping(value = "/courses")
    public MyResponse createCourse(@RequestBody Course course) {
        return new MyResponse<>(true, courseService.createCourse(course), MyResponseEnums.OPERATE_SUCCESS);
    }


    @ApiOperation(value = "更新某一课程信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "course", value = "课程实体", required = true, paramType = "body")
    })
    @PutMapping(value = "/courses")
    public MyResponse updateCourse(@RequestBody Course course) {
        return new MyResponse<>(true, courseService.updateCourse(course), MyResponseEnums.OPERATE_SUCCESS);
    }


    @ApiOperation(value = "删除某一课程信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "course_id", value = "课程号", required = true, paramType = "path")
    })
    @DeleteMapping(value = "/courses/{course_id}")
    public MyResponse deleteCourse(@PathVariable("course_id") Integer course_id) {
        return new MyResponse<>(true, courseService.deleteCourse(course_id), MyResponseEnums.OPERATE_SUCCESS);
    }


    @ApiOperation(value = "查询某一学生选择的所有课程信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "student_id", value = "学生号", required = true, paramType = "path")
    })
    @GetMapping(value = "/students/{student_id}/courses")
    public MyResponse findCoursesByStudent(@PathVariable("student_id") Integer student_id) {
        return new MyResponse<>(true, studentService.findCoursesByStudent(student_id), MyResponseEnums.OPERATE_SUCCESS);
    }

}
