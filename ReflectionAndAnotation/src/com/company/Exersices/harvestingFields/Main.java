package com.company.Exersices.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Class<RichSoilLand> clazz = RichSoilLand.class;
		Field[] fields = clazz.getDeclaredFields();

		Scanner sc = new Scanner(System.in);

		String input = sc.nextLine();
		while (!input.equals("HARVEST")) {
			switch (input) {
				case "public":
					for (Field field : fields) {
						if (Modifier.isPublic(field.getModifiers())) {
							System.out.printf("%s %s %s%n",
									Modifier.toString(field.getModifiers()),
									field.getType().getSimpleName(),
									field.getName());
						}
					}
					break;

				case "private":
					for (Field field : fields) {
						if (Modifier.isPrivate(field.getModifiers())) {
							System.out.printf("%s %s %s%n",
									Modifier.toString(field.getModifiers()),
									field.getType().getSimpleName(),
									field.getName());
						}
					}
					break;

				case "protected":
					for (Field field : fields) {
						if (Modifier.isProtected(field.getModifiers())) {
							System.out.printf("%s %s %s%n",
									Modifier.toString(field.getModifiers()),
									field.getType().getSimpleName(),
									field.getName());
						}
					}
					break;

				case "all":
					for (Field field : fields) {
						System.out.printf("%s %s %s%n",
								Modifier.toString(field.getModifiers()),
								field.getType().getSimpleName(),
								field.getName());
					}
					break;
			}

			input = sc.nextLine();
		}
	}
}
