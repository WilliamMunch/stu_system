package com.school.stu_system.controller;

import com.school.stu_system.domain.Student;
import com.school.stu_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@RequestMapping(value = "/students")
public class StudentController{
    @Autowired
    StudentService studentService;

    
    

    
    @GetMapping
    public ResponseEntity<List<Student>> findAllStudents()
    {
        return new ResponseEntity<List<Student>>(studentService.findAllStudents(), HttpStatus.OK);
    }

  
    @GetMapping(value = "/{student_id}")
    public ResponseEntity<Student> findStudentById(@PathVariable("student_id") Integer student_id)
    {
        return new ResponseEntity<Student>(studentService.findStudentById(student_id), HttpStatus.OK);
    }

   
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student)
    {
        return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Student> updateStudent(@RequestBody Student student)
    {
        return new ResponseEntity<>(studentService.updateStudent(student), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{student_id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable("student_id") Integer student_id)
    {
        return new ResponseEntity<>(studentService.deleteStudent(student_id), HttpStatus.NO_CONTENT);
    }

}
