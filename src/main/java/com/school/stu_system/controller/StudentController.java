package com.school.stu_system.controller;

import com.school.stu_system.domain.Student;
import com.school.stu_system.service.CourseService;
import com.school.stu_system.service.DepartmentService;
import com.school.stu_system.service.StudentService;
import com.school.stu_system.domain.MyResponse;
import com.school.stu_system.domain.MyResponseEnums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "")
public class StudentController{
    @Autowired
    StudentService studentService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    CourseService courseService;

    @GetMapping(value = "/students")
    public MyResponse findAllStudents()
    {
        return  new MyResponse<>(true,studentService.findAllStudents(), MyResponseEnums.OPERATE_SUCCESS  );
    }


    @GetMapping(value = "/students/{student_id}")
    public MyResponse findStudentById(@PathVariable("student_id") Integer student_id)
    {
        return  new MyResponse<>(true,studentService.findStudentById(student_id) , MyResponseEnums.OPERATE_SUCCESS );
    }


    @PostMapping(value = "/students")
    public MyResponse createStudent(@RequestBody Student student)
    {
        return  new MyResponse<>(true,studentService.createStudent(student) , MyResponseEnums.OPERATE_SUCCESS );
    }
    @PutMapping(value = "/students")
    public MyResponse updateStudent(@RequestBody Student student)
    {
        return  new MyResponse<>(true,studentService.updateStudent(student) , MyResponseEnums.OPERATE_SUCCESS );
    }

    @DeleteMapping(value = "/students/{student_id}")
    public MyResponse deleteStudent(@PathVariable("student_id") Integer student_id)
    {
        return  new MyResponse<>(true,studentService.deleteStudent(student_id), MyResponseEnums.OPERATE_SUCCESS );
    }



    @GetMapping(value = "/departments/{department_id}/students")
    public MyResponse findStudentsByDepartment(@PathVariable("department_id") Integer department_id)
    {
        return  new MyResponse<>(true,departmentService.findStudentsByDepartment(department_id), MyResponseEnums.OPERATE_SUCCESS );
    }
    @GetMapping(value = "/courses/{course_id}/students")
    public MyResponse findStudentsByCourse(@PathVariable("course_id") Integer course_id)
    {
        return  new MyResponse<>(true,courseService.findStudentsByCourse(course_id), MyResponseEnums.OPERATE_SUCCESS );
    }


    @PostMapping(value = "/courses/{course_id}/students/{student_id}/select")
    public MyResponse selectCourseByStudent(@PathVariable("student_id") Integer student_id, @PathVariable("course_id") Integer course_id)
    {
        return  new MyResponse<>(true,studentService.selectCourseByStudent(student_id,course_id), MyResponseEnums.OPERATE_SUCCESS );
    }
    @PostMapping(value = "/courses/{course_id}/students/{student_id}/withdraw")
    public MyResponse withdrawCourseByStudent(@PathVariable("student_id") Integer student_id, @PathVariable("course_id") Integer course_id)
    {
        return  new MyResponse<>(true,studentService.withdrawCourseByStudent(student_id,course_id), MyResponseEnums.OPERATE_SUCCESS );
    }


}
