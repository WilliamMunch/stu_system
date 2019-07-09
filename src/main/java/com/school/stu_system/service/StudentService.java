package com.school.stu_system.service;

import com.school.stu_system.domain.Student;
import com.school.stu_system.repository.StudentDao;
import com.school.stu_system.util.UnicomResponseEnums;
import com.school.stu_system.util.UnicomRuntimeException;
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
        Optional<Student> student_op = studentDao.findById(id);
        if(student_op.isPresent())
        {
            studentDao.delete(student_op.get());
            return student_op.get();
        }
        else{
            throw new UnicomRuntimeException(UnicomResponseEnums.NO_RECORD);

        }

    }

    /*
    改
    */
    public Student updateStudent(Student student)
    {
        Optional<Student> student_op = studentDao.findById(student.getId());
        if(student_op.isPresent())
        {
            return studentDao.saveAndFlush(student);

        }
        else{
            throw new UnicomRuntimeException(UnicomResponseEnums.NO_RECORD);

        }





    }
    /*
    查1条
    */
    public Student findStudentById(Integer id)
    {
        Optional<Student> student_op = studentDao.findById(id);
        if(student_op.isPresent())
        {
            return student_op.get();
        }
        else{
            throw new UnicomRuntimeException(UnicomResponseEnums.NO_RECORD);

        }
    }
    /*
    查全部
    */
    public List<Student> findAllStudents()
    {
        return studentDao.findAll();
    }
}
