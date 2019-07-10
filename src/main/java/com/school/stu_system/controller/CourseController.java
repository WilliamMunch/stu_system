package com.school.stu_system.controller;

import com.school.stu_system.domain.Course;
import com.school.stu_system.service.StudentService;
import com.school.stu_system.service.DepartmentService;
import com.school.stu_system.service.CourseService;
import com.school.stu_system.domain.MyResponse;
import com.school.stu_system.domain.MyResponseEnums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "")
public class CourseController{
    @Autowired
    StudentService studentService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    CourseService courseService;

    @GetMapping(value = "/courses")
    public MyResponse findAllCourses()
    {
        return  new MyResponse<>(true,courseService.findAllCourses() , MyResponseEnums.OPERATE_SUCCESS );
    }


    @GetMapping(value = "/courses/{course_id}")
    public MyResponse findCourseById(@PathVariable("course_id") Integer course_id)
    {
        return  new MyResponse<>(true,courseService.findCourseById(course_id) , MyResponseEnums.OPERATE_SUCCESS );
    }


    @PostMapping(value = "/courses")
    public MyResponse createCourse(@RequestBody Course course)
    {
        return  new MyResponse<>(true,courseService.createCourse(course) , MyResponseEnums.OPERATE_SUCCESS );
    }
    @PutMapping(value = "/courses")
    public MyResponse updateCourse(@RequestBody Course course)
    {
        return  new MyResponse<>(true,courseService.updateCourse(course) , MyResponseEnums.OPERATE_SUCCESS );
    }

    @DeleteMapping(value = "/courses/{course_id}")
    public MyResponse deleteCourse(@PathVariable("course_id") Integer course_id)
    {
        return  new MyResponse<>(true,courseService.deleteCourse(course_id), MyResponseEnums.OPERATE_SUCCESS );
    }

    @GetMapping(value = "/students/{student_id}/courses")
    public MyResponse findCoursesByStudent(@PathVariable("student_id") Integer student_id)
    {
        return  new MyResponse<>(true,studentService.findCoursesByStudent(student_id), MyResponseEnums.OPERATE_SUCCESS );
    }

}
