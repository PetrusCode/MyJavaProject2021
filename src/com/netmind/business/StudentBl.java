package com.netmind.business;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import com.netmind.dao.StudentDao;
import com.netmind.model.Student;

public class StudentBl {
	Student student = new Student();

	public boolean add(Student student) throws IOException {

		StudentDao studentDao = new StudentDao();

		student.setAge(calculaAge(student.getDateOfBirth()));

		return studentDao.add(student);

	}

	public static int calculaAge(LocalDate dateOfBirth) {

		Period edad = Period.between(dateOfBirth, LocalDate.now());

		return edad.getYears();

	}
}
