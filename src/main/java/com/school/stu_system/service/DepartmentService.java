package com.school.stu_system.service;

import com.school.stu_system.domain.Department;
import com.school.stu_system.domain.Student;
import com.school.stu_system.repository.DepartmentDao;
import com.school.stu_system.repository.StudentDao;
import com.school.stu_system.util.UnicomResponseEnums;
import com.school.stu_system.util.UnicomRuntimeException;
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
        Optional<Department> department_op = departmentDao.findById(id);
        if(department_op.isPresent())
        {
            departmentDao.delete(department_op.get());
            return department_op.get();
        }
        else{
            throw new UnicomRuntimeException(UnicomResponseEnums.NO_RECORD);

        }
    }

    /*
    改
    */
    public Department updateDepartment(Department department)
    {
        Optional<Department> department_op = departmentDao.findById(department.getId());
        if(department_op.isPresent())
        {
            return departmentDao.saveAndFlush(department);
        }
        else{
            throw new UnicomRuntimeException(UnicomResponseEnums.NO_RECORD);

        }




    }
    /*
    查1条
    */
    public Department findDepartmentById(Integer id)
    {
        Optional<Department> department_op = departmentDao.findById(id);
        if(department_op.isPresent())
        {
            return department_op.get();
        }
        else{
            throw new UnicomRuntimeException(UnicomResponseEnums.NO_RECORD);

        }
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

            return findDepartmentById(departmentId).getStudents();

    }
}
