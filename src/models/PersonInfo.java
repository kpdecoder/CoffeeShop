package models;
import java.util.Date;
public abstract class PersonInfo {
	private int emp_id;

	private String emp_name;

	private String emp_phone;

	private String emp_email;

	private String emp_address;
	
	private String emp_dateOfBirth;

	private String emp_startDate;
	
	public PersonInfo() {
	}

	public PersonInfo(int id, String name, String phone, String email, String address, String dateOfBirth, String startDate) {
		super();
		this.emp_id = id;
		this.emp_name = name;
		this.emp_phone = phone;
		this.emp_email = email;
		this.emp_address = address;
		this.emp_dateOfBirth = dateOfBirth;
		this.emp_startDate = startDate;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_phone() {
		return emp_phone;
	}

	public void setEmp_phone(String emp_phone) {
		this.emp_phone = emp_phone;
	}

	public String getEmp_email() {
		return emp_email;
	}

	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}

	public String getEmp_address() {
		return emp_address;
	}

	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}

	public String getEmp_dateOfBirth() {
		return emp_dateOfBirth;
	}

	public void setEmp_dateOfBirth(String emp_dateOfBirth) {
		this.emp_dateOfBirth = emp_dateOfBirth;
	}

	public String getEmp_startDate() {
		return emp_startDate;
	}

	public void setEmp_startDate(String emp_startDate) {
		this.emp_startDate = emp_startDate;
	}
}



