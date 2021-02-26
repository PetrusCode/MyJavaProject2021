package com.netmind.presentation;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.netmind.business.StudentBl;
import com.netmind.dao.FileManagementsDao;
import com.netmind.model.EnumStudent;
import com.netmind.model.Student;

public class Menu {

	public static void studentMenu() throws IOException {
		StudentBl studentBl = new StudentBl();
		Scanner scanner = new Scanner(System.in);
		int opcion = 0;

		do {

			try {

				opcion = Integer.parseInt(JOptionPane.showInputDialog(
						"Que opcion quiere seleccionar?" + "\n 1.Agregar \n 2.Calular estudiante con mayor "
								+ "edad \n 3.Calular la media de edad \n 4.Exit"));

			} catch (Exception e) {
				System.out.println("Introduzca un numero " + e);

			}
			EnumStudent enumStudent = EnumStudent.values()[opcion];
			switch (enumStudent) {

				case ADD_STUDENT:
					Student student = new Student();
					addnewStudents(student, scanner);
					studentBl.add(student);
					break;
				case CALCULATE_STUDENT_MAX_AGE:
					System.out.println("Calcular el estudiante con mayor edad");
					break;
				case CALCULATE_AVERAGE_AGE:
					System.out.println("Calcular la media de edad de todos los estudiantes ");
					break;

				default:
					break;
			}
		} while (opcion != EnumStudent.EXIT.ordinal());
		System.out.println("Salir");
		scanner.close();
	}

	private static void addnewStudents(Student student, Scanner scanner) throws IOException {
		System.out.println("Agregar nuevo estudiante");

		System.out.println("Nombre");
		student.setName(scanner.nextLine());

		System.out.println("Apellido");
		student.setSurname(scanner.nextLine());
		System.out.println("Introduce fecha de nacimiento");

		try {
			student.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine()));
		} catch (ParseException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("Introduce nombre del archivo");
		try {
			FileManagementsDao.addTxtStudent("./txtDb/" + scanner.nextLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}

	}
}
