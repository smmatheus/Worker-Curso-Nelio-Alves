package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {
	
	public static void main(String[]args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in); 
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Entre com o nome do departamento");
		String departmentName = sc.nextLine();
		System.out.println("Entre com o nome do trabalhador");
		System.out.println("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.println("Salario Base");
		Double salarioBase = sc.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), salarioBase, new Department(departmentName));
		
		System.out.println("Quantos contratos o trabalhador tem?");
		int n = sc.nextInt();
		
		for(int i=1; i<n; i++) {
			System.out.println("Entre com o contrato #" + i + "data:");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Valor por horas: ");
			double valorPorHoras = sc.nextDouble();
			System.out.print("Horas: ");
			int horas = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valorPorHoras, horas);
			worker.addContract(contract);
		}
		
		System.out.println();
		System.out.println("Entre com mes e ano para calcular o salario (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: " + worker.getName());
		System.out.println("Departamento: " + worker.getDepartment().getNome());
		System.out.println("Renda de: " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
		
		
		
		
		sc.close();
	}
}
