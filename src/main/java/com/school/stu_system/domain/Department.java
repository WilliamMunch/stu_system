package com.school.stu_system.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "t_department")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
//在此标记不生成json对象的属性
//因为jsonplugin用的是java的内审机制.hibernate会给被管理的pojo加入一个hibernateLazyInitializer属性,
//jsonplugin会把hibernateLazyInitializer也拿出来操作,并读取里面一个不能被反射操作的属性会产生异常.
public class Department implements Serializable {

	private static final long serialVersionUID = 7932156691949526024L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="department_id")
	private Integer id;

	@Column(length = 100,name="department_name",nullable = false)
	private String name;



	@OneToMany(mappedBy = "department",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Student> students;
	//list是有序的，set是无序的，前者可以重复，后者不可以
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
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

	public Department() {
		super();
	}

}
