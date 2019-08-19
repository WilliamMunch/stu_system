package com.school.stu_system.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "t_student")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Student implements Serializable {

    private static final long serialVersionUID = 6407320892506939654L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer id;

    @Column(length = 100, name = "student_name", nullable = false)
    private String name;

    //双向多对一
    //单双向的区别是在A获取B的信息的同时，B能否获取A的信息，能=>双，否=>单
    @JoinColumn(name = "department_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Department department;

/*

记住@OneToMany这个标签最后的英文单词,如果是要得到Many的一方，我不管你前面是什么，只要后面的单词是Many，也就是说要得到多的一方，你们就给我记住，
默认的加载策略就是延迟加载(Many记录可能上几万条，立即加载的话可能对效率影响大，所以延迟加载)。
    反过来，如果后面是One呢？因为它是加载一的一方，这对性能影响不是很大，所以它的默认加载策略是立即加载。
 */

    //双向多对多
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "t_student_course",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "course_id"))
    @JsonIgnore
    private Set<Course> courses;


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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }

}
