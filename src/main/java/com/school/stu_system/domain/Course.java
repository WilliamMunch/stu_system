package com.school.stu_system.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @program: stu_system
 * @description:
 * @author: William Munch
 * @create: 2019-07-09 16:16
 **/
@Entity
@Table(name = "t_course")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })

public class Course  implements Serializable {

    private static final long serialVersionUID = -4310210227936391905L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="course_id")
    private Integer id;

    @Column(length = 100,name="course_name",nullable = false)
    private String name;

    //双向多对多
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "t_student_course",
            joinColumns = @JoinColumn(name="course_id",referencedColumnName="course_id"),
            inverseJoinColumns = @JoinColumn(name="student_id",referencedColumnName="student_id"))
    @JsonIgnore
    private Set<Student> students;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
