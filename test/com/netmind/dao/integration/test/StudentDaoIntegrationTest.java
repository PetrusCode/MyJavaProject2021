package com.netmind.dao.integration.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

import org.junit.Test;

import com.netmind.dao.FileManagementsDao;
import com.netmind.dao.StudentDao;
import com.netmind.model.Student;

public class StudentDaoIntegrationTest {

	@Test
	public void testAdd() throws Exception {
		Student student = new Student();
		student.setIdStudent(1);
		student.setName("pedro");
		student.setSurname("miliano");
		student.setAge(29);
		student.setDateOfBirth(LocalDate.parse("1991-12-31"));
		StudentDao studentDao = new StudentDao();
		FileManagementsDao.addTxtStudent("./txtDb/StudentsTest.txt");
		studentDao.addStudentsinFile(student);

		Student searchStudent = testAddStudentsinFile(student.getUuid());
		assertEquals(student, searchStudent);
	}

	private Student testAddStudentsinFile(UUID uuid) throws Exception {
		boolean gotIt = false;

		File file = new File("./txtDb/StudentsTest.txt");
		String[] alumnostring = null;

		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNext() && gotIt == false) {
				String line = scanner.nextLine();
				alumnostring = line.split(",");

				if (alumnostring[0].equals(uuid.toString()))
					;
				gotIt = true;
			}
		} catch (IOException e) {
			throw e;
		}

		Student student = new Student(uuid);
		if (gotIt == true) {
			student.setIdStudent(Integer.parseInt(alumnostring[1].trim()));
			student.setName(alumnostring[2].trim());
			student.setSurname(alumnostring[3].trim());
			student.setAge(Integer.parseInt(alumnostring[4].trim()));
			student.setDateOfBirth(LocalDate.parse(alumnostring[5].trim()));
		}

		return student;
	}

}
