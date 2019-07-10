package com.school.stu_system.service;

import com.school.stu_system.domain.Course;
import com.school.stu_system.domain.Student;
import com.school.stu_system.repository.CourseDao;
import com.school.stu_system.repository.StudentDao;
import com.school.stu_system.domain.MyResponseEnums;
import com.school.stu_system.domain.MyRuntimeException;
import com.school.stu_system.util.UpdateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.Set;




/*

RESTful api设计规范
/zoos              所有动物园
/zoos/1/animals    id为1的动物园中的所有动物
/zoos/1            id为1的动物园
/zoos/1;2;3        id为1，2，3的动物园

*/



@Service
public class StudentService {
    @Autowired
    StudentDao studentDao;
    @Autowired
    CourseDao courseDao;
    @Autowired
    CourseService courseService;


    /*
    增
    */
    public Student createStudent(Student student)
    {
        student.setId(null);//确保saveAndFlush不会走更新，只走新增这条路

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
            throw new MyRuntimeException(MyResponseEnums.NO_RECORD);

        }

    }

    /*
    改
    */
    public Student updateStudent(Student student)
    {
        Optional<Student> student_op = studentDao.findById(student.getId());
        if(student_op.isPresent())
        { UpdateUtil.copyNullProperties(student_op.get(), student);
            return studentDao.saveAndFlush(student);

        }
        else{
            throw new MyRuntimeException(MyResponseEnums.NO_RECORD);

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
            throw new MyRuntimeException(MyResponseEnums.NO_RECORD);

        }
    }
    /*
    查全部
    */
    public List<Student> findAllStudents()
    {
        return studentDao.findAll();
    }


    /*
    查询一个学生选的所有课
     */

    public Set<Course> findCoursesByStudent(Integer studentId) {

        return findStudentById(studentId).getCourses();

    }
    /*
    一个学生选一门课
     */
    public Student selectCourseByStudent(Integer studentId,Integer courseId)
    {
        Student student=findStudentById(studentId);
        Course course=courseService.findCourseById(courseId);
        Set<Course> courses=student.getCourses();
        courses.add(course);
        student.setCourses(courses);
//        student.setName("选课");
        return updateStudent(student);

    }
    /*
       一个学生退选一门课
        */
    public Student withdrawCourseByStudent(Integer studentId,Integer courseId)
    {
        Student student=findStudentById(studentId);
        Course course=courseService.findCourseById(courseId);
        Set<Course> courses=student.getCourses();
        courses.remove(course);
        student.setCourses(courses);
//        student.setName("退课");
        return updateStudent(student);


    }

}
