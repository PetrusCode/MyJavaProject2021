package com.netmind.presentation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.UUID;

import javax.swing.JOptionPane;

import com.netmind.business.StudentBl;
import com.netmind.model.Student;

public class Menu {

	public static void studentMenu() {
		StudentBl studentBl = new StudentBl();
		Scanner scanner = new Scanner(System.in);
		int opcion = 0;

		do {

			try {
				opcion = Integer.parseInt(JOptionPane
						.showInputDialog("Que opcion quiere seleccionar?"
								+ "\n 1.Agregar \n 2.Calular estudiante con mayor edad \n 3.Calular la media de edad \n 4.Exit"));
			} catch (Exception e) {
				System.out.println("Introduzca un numero " + e);

			}
			switch (opcion) {
			case 1:
				Student student = new Student();
				addnewStudents(student, scanner);
				studentBl.add(student);
				break;
			case 2:
				System.out.println("Calcular el estudiante con mayor edad");
				break;
			case 3:
				System.out.println(
						"Calcular la media de edad de todos los estudiantes ");
				break;
			case 4:
				System.out.println("Salir");
				scanner.close();
				break;
			}
		} while ((opcion == 1 == false) && (opcion == 2 == false)
				&& (opcion == 3 == false) && (opcion == 4 == false));

	}

	private static void addnewStudents(Student student, Scanner scanner) {
		System.out.println("Agregar nuevo estudiante");

		String uuid = UUID.randomUUID().toString();

		student.setIdStudent(uuid);
		System.out.println("Nombre");
		student.setName(scanner.nextLine());

		System.out.println("Apellido");
		student.setSurname(scanner.nextLine());
		System.out.println("Introduce fecha de nacimiento");

		try {
			student.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy")
					.parse(scanner.nextLine()));
		} catch (ParseException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
}
