package com.school.stu_system.repository;

import com.school.stu_system.domain.Course;
import com.school.stu_system.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseDao extends JpaRepository<Course,Integer> {

}
