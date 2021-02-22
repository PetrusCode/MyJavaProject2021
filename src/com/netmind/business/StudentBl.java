package com.netmind.business;

import java.util.Date;

import com.netmind.dao.StudentDao;
import com.netmind.model.Student;

public class StudentBl {

	public int calculaAge(Date fecha) {
		Date actual = new Date();

		actual.setHours(0);

		fecha.setHours(0);

		fecha.setYear(actual.getYear());
		int resta = actual.getYear() - fecha.getYear();

		return resta;
	}

	public boolean add(Student student) {

		StudentDao studentDao = new StudentDao();

		return studentDao.add(student);

	}
}
