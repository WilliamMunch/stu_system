package com.school.stu_system.service;

import com.school.stu_system.domain.Department;
import com.school.stu_system.domain.Student;
import com.school.stu_system.repository.DepartmentDao;
import com.school.stu_system.repository.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class DepartmentService {
    @Autowired
    DepartmentDao departmentDao;
    @Autowired
    StudentDao studentDao;


    /*
    增
    */
    public Department createDepartment(Department department)
    {
        return departmentDao.saveAndFlush(department);
    }
    /*
    删
    */
    public Department deleteDepartment(Integer id)
    {
        Optional<Department> department = departmentDao.findById(id);
        if(department.isPresent())
        {
            departmentDao.delete(department.get());
            return department.get();
        }
        else
            return null;
    }

    /*
    改
    */
    public Department updateDepartment(Department department)
    {
        return departmentDao.saveAndFlush(department);
    }
    /*
    查1条
    */
    public Department findDepartmentById(Integer id)
    {
        Optional<Department> department = departmentDao.findById(id);
        if(department.isPresent())
        {
            return department.get();
        }
        else
            return null;
    }
    /*
    查全部
    */
    public List<Department> findAllDepartments()
    {
        return departmentDao.findAll();
    }
    /*
    查询学院下所有学生
     */
//    public List<Student> findStudentByDepartment(Integer departmentId) {
//        return studentDao.findByDepartment(departmentId);
//    }
    public List<Student> findStudentByDepartment(Integer departmentId) {
        if(findDepartmentById(departmentId)!=null)
            return findDepartmentById(departmentId).getStudents();
        else
            return null;
    }
}
