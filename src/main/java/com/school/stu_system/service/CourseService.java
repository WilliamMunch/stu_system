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


@Service
public class CourseService {
    @Autowired
    CourseDao courseDao;
    @Autowired
    StudentDao studentDao;


    /*
    增
    */
    public Course createCourse(Course course)
    {
        course.setId(null);//确保saveAndFlush不会走更新，只走新增这条路
        return courseDao.saveAndFlush(course);
    }
    /*
    删
    */
    public Course deleteCourse(Integer id)
    {
        Optional<Course> course_op = courseDao.findById(id);
        if(course_op.isPresent())
        {
            courseDao.delete(course_op.get());
            return course_op.get();
        }
        else{
            throw new MyRuntimeException(MyResponseEnums.NO_RECORD);

        }
    }

    /*
    改
    */
    public Course updateCourse(Course course)
    {
        Optional<Course> course_op = courseDao.findById(course.getId());
        if(course_op.isPresent())
        {
            UpdateUtil.copyNullProperties(course_op.get(), course);
            return courseDao.saveAndFlush(course);
        }
        else{
            throw new MyRuntimeException(MyResponseEnums.NO_RECORD);

        }




    }
    /*
    查1条
    */
    public Course findCourseById(Integer id)
    {
        Optional<Course> course_op = courseDao.findById(id);
        if(course_op.isPresent())
        {
            return course_op.get();
        }
        else{
            throw new MyRuntimeException(MyResponseEnums.NO_RECORD);

        }
    }
    /*
    查全部
    */
    public List<Course> findAllCourses()
    {
        return courseDao.findAll();
    }
    /*
    查询一门课下的所有学生
     */

    public Set<Student> findStudentsByCourse(Integer courseId) {

        return findCourseById(courseId).getStudents();

    }


}
