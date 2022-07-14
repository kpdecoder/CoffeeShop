package models;

public class Employee extends PersonInfo{
	
	private UserRole emp_role;
	private String emp_username;
	private String emp_password;
	private Double emp_salary;
	private boolean active;
	
	public Employee() {
		super();
	}

	public Employee(UserRole role, String username, String password, Double salary, boolean active) {
		super();
		this.emp_role = role;
		this.emp_username = username;
		this.emp_password = password;
		this.emp_salary = salary;
		this.active = active;
	}

	public UserRole getEmp_role() {
		return emp_role;
	}

	public void setEmp_role(UserRole emp_role) {
		this.emp_role = emp_role;
	}

	public String getEmp_username() {
		return emp_username;
	}

	public void setEmp_username(String emp_username) {
		this.emp_username = emp_username;
	}

	public String getEmp_password() {
		return emp_password;
	}

	public void setEmp_password(String emp_password) {
		this.emp_password = emp_password;
	}

	public Double getEmp_salary() {
		return emp_salary;
	}

	public void setEmp_salary(Double emp_salary) {
		this.emp_salary = emp_salary;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	
	
}
