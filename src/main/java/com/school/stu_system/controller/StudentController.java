package com.school.stu_system.controller;

import com.school.stu_system.domain.Student;
import com.school.stu_system.service.StudentService;
import com.school.stu_system.util. ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/students")
public class StudentController{
    @Autowired
    StudentService studentService;


    @GetMapping
    public ResponseBean findAllStudents()
    {
        return  new  ResponseBean<>(true,studentService.findAllStudents() );
    }


    @GetMapping(value = "/{student_id}")
    public ResponseBean findStudentById(@PathVariable("student_id") Integer student_id)
    {
        return  new  ResponseBean<>(true,studentService.findStudentById(student_id) );
    }


    @PostMapping
    public ResponseBean createStudent(@RequestBody Student student)
    {
        return  new  ResponseBean<>(true,studentService.createStudent(student) );
    }
    @PutMapping
    public ResponseBean updateStudent(@RequestBody Student student)
    {
        return  new  ResponseBean<>(true,studentService.updateStudent(student) );
    }

    @DeleteMapping(value = "/{student_id}")
    public ResponseBean deleteStudent(@PathVariable("student_id") Integer student_id)
    {
        return  new  ResponseBean<>(true,studentService.deleteStudent(student_id));
    }

}
