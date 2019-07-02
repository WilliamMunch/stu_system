package com.school.stu_system.service;

import com.school.stu_system.domain.Student;
import com.school.stu_system.repository.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;



@Service
public class StudentService {
    @Autowired
    StudentDao studentDao;



    /*
    增
    */
    public Student createStudent(Student student)
    {
        return studentDao.saveAndFlush(student);
    }
    /*
    删
    */
    public Student deleteStudent(Integer id)
    {
        Optional<Student> student = studentDao.findById(id);
        if(student.isPresent())
        {
            studentDao.delete(student.get());
            return student.get();
        }
        else
            return null;
    }

    /*
    改
    */
    public Student updateStudent(Student student)
    {
        return studentDao.saveAndFlush(student);
    }
    /*
    查1条
    */
    public Student findStudentById(Integer id)
    {
        Optional<Student> student = studentDao.findById(id);
        if(student.isPresent())
        {
            return student.get();
        }
        else
            return null;
    }
    /*
    查全部
    */
    public List<Student> findAllStudents()
    {
        return studentDao.findAll();
    }
}
