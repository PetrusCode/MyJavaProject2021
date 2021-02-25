package com.netmind.dao;

import java.util.ArrayList;

import com.netmind.model.Student;

public class StudentDao {
	private static ArrayList<Student> arrayStudent = null;

	static {
		arrayStudent = new ArrayList<Student>();
	}

	public boolean add(Student student) {
		for (int iterator = 0; iterator < arrayStudent.size(); iterator++) {
			System.out.println(arrayStudent.get(iterator));

		}
		return arrayStudent.add(student);
	}

	public boolean addStudentsinFile(Student student) {
		return arrayStudent.add(student);

	}

}