package com.netmind.presentation;

import java.util.Scanner;
import java.util.UUID;

import javax.swing.JOptionPane;

import com.netmind.business.StudentBl;
import com.netmind.model.Student;

public class Menu {

	static Scanner scanner = new Scanner(System.in);

	public static Student menu(Student student) {
		int opcion = 0;

		do {

			try {
				opcion = Integer.parseInt(JOptionPane
						.showInputDialog("¿Que opcion quiere seleccionar?"
								+ "\n 1.Agregar \n 2.Calular estudiante con mayor edad \n 3.Calular la media de edad \n 2.Exit"));
			} catch (Exception e) {
				System.out.println("Introduzca un numero " + e);

			}
			if (opcion == 1) {
				StudentBl studentBl = new StudentBl();
				System.out.println("Agregar nuevo estudiante");

				String uuid = UUID.randomUUID().toString();

				student.setIdStudent(uuid);
				System.out.println("Nombre");

				String name = scanner.nextLine();
				student.setName(name);

				System.out.println("Apellido");

				String surname = scanner.nextLine();
				student.setSurname(surname);

				System.out.println("Fecha de nacimiento (dd/mm/yy");
				String dateOfBirth = scanner.nextLine();

			} else if (opcion == 2) {
				System.out.println("Calcular el estudiante con mayor edad");
			} else if (opcion == 3) {
				System.out.println(
						"Calcular la media de edad de todos los estudiantes ");
			} else if (opcion == 4) {
				System.out.println("Salir");
			}
		} while ((opcion == 1 == false) && (opcion == 2 == false)
				&& (opcion == 3 == false) && (opcion == 4 == false));
		return student;
	}

}
