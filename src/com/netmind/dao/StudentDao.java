package com.netmind.dao;

import java.io.BufferedWriter;
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
		try {
			addStudentsinFile(student);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arrayStudent.add(student);

	}

	public boolean addStudentsinFile(Student student) throws IOException {
		try (FileWriter writer = new FileWriter("./txtDb/" + FileManagementsDao.getFileName(), true);
				BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
			bufferedWriter.write(student.toString());
			bufferedWriter.write(System.lineSeparator());

		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}

		return true;
	}

}