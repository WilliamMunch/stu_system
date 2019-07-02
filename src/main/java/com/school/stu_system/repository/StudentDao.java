package com.school.stu_system.repository;

import com.school.stu_system.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentDao extends JpaRepository<Student,Integer> {

//    @Query(value ="select * from t_student  where department_id=?1",nativeQuery = true)
//    List<Student> findByDepartment( @Param("department_id") Integer department_id);

}
