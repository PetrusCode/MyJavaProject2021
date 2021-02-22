package com.netmind.dao;

import java.util.ArrayList;

import com.netmind.model.Student;

public class StudentDao {
	public static ArrayList<Student> arrayStudent = new ArrayList<Student>();

	public boolean add(Student student) {
		return arrayStudent.add(student);

	}
}
