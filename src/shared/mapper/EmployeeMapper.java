package shared.mapper;

import models.Employee;

import java.sql.ResultSet;

public class EmployeeMapper {

    public Employee mapToEmployee(Employee employee, ResultSet rs) {
        try {
            employee.setEmp_id(rs.getInt("emp_id"));
            employee.setEmp_name(rs.getString("emp_name"));
            employee.setEmp_phone(rs.getString("emp_phone"));
            employee.setEmp_email(rs.getString("emp_email"));
            employee.setEmp_address(rs.getString("emp_address"));
            employee.setEmp_dateOfBirth(rs.getString("emp_DOB"));
            employee.setEmp_username(rs.getString("emp_username"));
            employee.setEmp_password(rs.getString("emp_password"));
            employee.setEmp_salary(rs.getDouble("emp_password"));
            employee.setEmp_startDate(rs.getString("emp_startdate"));
            employee.setActive(rs.getBoolean("emp_status"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }
}