package entities;                      //04 criar a classe

import java.util.Date;                 //06 importat Date

public class HourContract {            //05 criar os atributos

	private Date date;
	private Double valuePerHour;
	private Integer hours;
	
	public HourContract() {            //07 criar construtor vazio
	}

	public HourContract(Date date, Double valuePerHour, Integer hours) { //08 criar construtor arguments
		this.date = date;
		this.valuePerHour = valuePerHour;
		this.hours = hours;
	}

	public Date getDate() {             //09 criar geter e seters
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getValuePerHour() {
		return valuePerHour;
	}

	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}

	public Integer getHours() {
		return hours;
	}

	public void setHours(Integer hours) {
		this.hours = hours;
	}
	
	//25 adicionar operação valor de hora por hora ; para realizar no worker
	public double totalValue() {
		return valuePerHour * hours;
	}
}