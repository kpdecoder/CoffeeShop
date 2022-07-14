package shared.utils;

import models.Employee;

public class CurrentUserHolder {

	private static Employee employee;
	
	private CurrentUserHolder() {}
	
	public static Employee getCurrentUser() {
		return employee;
	}
	
	public static void setLoggedInUser(Employee employee) {
		CurrentUserHolder.employee = employee;
	}
}