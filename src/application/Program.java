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

public class Program {                                                      //31criar class program

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);                                      //32 criar scanner e locale.set e importar
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");       //40 criar simple date format
		
	
		System.out.print("Enter department's name: ");                 //33 entrar com nome departament
		String departmentName = sc.nextLine();
		
		
		System.out.println("Enter worker data:");  
		//error
		
		
		System.out.print("Name: ");									//34 entrar nome trabalhador
		String workerName = sc.nextLine();
		
		System.out.print("Level: ");                                 //35 entrar level
		String workerLevel = sc.nextLine();
		
		System.out.print("Base salary: ");                            //36 base salary
		double baseSalary = sc.nextDouble();
		
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		//37 instanciar departament e worker 
			//instanciou objeto tipo worker: dados objeto nome digitei ; instancia worker level digitei; valor salario base digitado 
		      //associado esse objeto worker vai ter outro objeto departamento e o nome vai ser o digitado
		
		System.out.print("How many contracts to this worker? ");   //38 quantos contratos
		int n = sc.nextInt();
		
		
		
		for (int i=1; i<=n; i++) {                           //39 para ler os dados dos contratos
			System.out.println("Enter contract #" + i + " data:");
			System.out.print("Date (DD/MM/YYYY): ");
			
			Date contractDate = sdf.parse(sc.next());  //41 entrar com uma data vai ser que usuario digitar
			
			System.out.print("Value per hour: ");  //42valor por hora
			double valuePerHour = sc.nextDouble();
			
			System.out.print("Duration (hours): ");  //43 duração
			int hours = sc.nextInt();
			
			HourContract contract = new HourContract(contractDate, valuePerHour, hours); //44 com os 3 print  pode instanciar
			worker.addContract(contract);             //45 associar contrato com trabalhador
		}
		
		
		
		
		System.out.println();
		System.out.print("Enter month and year to calculate income (MM/YYYY): "); //46 entrar mes ano calcular salario
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2)); //47 reportar na posição 3
		int year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("Name: " + worker.getName());   //48 nome trabalhador
		System.out.println("Department: " + worker.getDepartment().getName());   //49 pegar acesso ao departamento
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));  
		//50 valores que ganhou mes e ano
		
		sc.close();
	}
}