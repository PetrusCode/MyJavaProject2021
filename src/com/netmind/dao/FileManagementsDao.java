package com.netmind.dao;

import java.io.File;
import java.io.IOException;

public class FileManagementsDao {
	StudentDao arr = new StudentDao();
	private static File file = null;

	public static synchronized boolean addTxtStudent(String Filename)

			throws IOException {
		boolean ifFileIsCreated = false;
		file = new File(Filename);

		if (file.exists()) {
			System.out.println("Ya existe el archivo" + Filename);

		} else {
			try {
				System.out.println("Se ha añadido un nuevo registro");
				ifFileIsCreated = file.createNewFile();

			} catch (IOException e) {
				System.out.println(e.getMessage());
				throw e;
			}

		}
		return ifFileIsCreated;
	}

	public static String getFileName() {
		return file.getName();
	}
}
