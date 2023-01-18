package com.example.crud.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employee_tbl")
public class Employee {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int age;
	private int salary;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int getSalary() {
		return salary;
	}
	public void setName(String n) {
		name=n;
	}
	public void setAge(int a) {
		age=a;
	}
	public void setSalary(int s) {
		salary=s;
	}
	
	

}
