package entities;              //01 criar class department

public class Department {

	private String name;       //02 name e criar construtor vazio
	
	public Department() {
	}

	public Department(String name) {  //03 criar construtor argumentos
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}