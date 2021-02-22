package com.netmind.presentation;

import java.util.Scanner;

import com.netmind.business.StudentBl;
import com.netmind.model.Student;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Los text de integracion son los que prueban el codigo real y los
		// servicios reales
		Scanner scanner = new Scanner(System.in);
		Student student = new Student();
		StudentBl studentBl = new StudentBl();

		System.out.println(
				"¿Que opcion quiere seleccionar?\n 1.Agrgar \n 2.Exit");

		Menu.menu(student);

		studentBl.add(student);
		System.out.println(student);

	}

}
