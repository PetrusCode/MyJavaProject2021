package com.netmind.dao;

import java.io.FileWriter;
import java.io.IOException;
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
		addStudentsinFile(student);

		return arrayStudent.add(student);

	}

	public void addStudentsinFile(Student student) {
		try (FileWriter writer = new FileWriter("./txtDb/Students.txt", true);) {
			writer.write(student.toString());
			writer.write(System.lineSeparator());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}