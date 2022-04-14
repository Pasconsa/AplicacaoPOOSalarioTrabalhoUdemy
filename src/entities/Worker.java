package entities;                //11 criar class worker

import java.util.ArrayList;        //20 import arraylist
import java.util.Calendar;         //28 import calender
import java.util.List;				//16 import list

import entities.enums.WorkerLevel;   //13 import worklevel

public class Worker {               //12 atributos

	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	//associação
	private Department department;       //14 Associação 1por1
	private List<HourContract> contracts = new ArrayList<>();  //15 Associação 1porlista
																//19 lista contatros instanciar na classe
	//17 construtor padrão
	public Worker() {
	}
	
	//18 construtor argumentos (automatico)   não marcar o que seja lista no caso os contratos
	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	
	//21 gerar geters e setters automatico
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}                          //set contract foi apagado pois não queremos que a lista seja trocada ou alterada

	
	//metodos
	//21 criar metodo associado ao worker add
	public void addContract(HourContract contract) { //aadcontract recebe hourcontract como argumento
		contracts.add(contract);                     // pega lista contract adiciona como argumento(contract)
	}
	
	public void removeContract(HourContract contract) {  //22 remover contract do worker
		contracts.remove(contract);
	}
	
	
	//23 metodo quanto ganhou por mes
	public double income(int year, int month) {  //24 somar salario base + contract do mes 
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();        //27 adicionar um calender
		for (HourContract c : contracts) {
			cal.setTime(c.getDate());                 //29 a data contrato é a data do calendario
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);  
			if (year == c_year && month == c_month) {  //30 ano arg for = ano contrato e mes = mes contrato
				sum += c.totalValue();					//26 ai valor c entra na soma
			}
		}
		return sum;
	}
}