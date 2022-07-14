package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import config.DBConfig;
import models.UserRole;
import models.Employee;
import repositories.EmployeeRepo;
import shared.mapper.EmployeeMapper;

public class EmployeeService implements EmployeeRepo{
	
	private final EmployeeMapper employeeMapper;
	private final DBConfig dbConfig;

	public EmployeeService() {
        this.employeeMapper = new EmployeeMapper();
        this.dbConfig = new DBConfig();
    }

	@Override
	public void createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		try {

            PreparedStatement ps = this.dbConfig.getConnection()
                    .prepareStatement("INSERT INTO employee (emp_name, emp_phone, emp_email, emp_address, emp_DOB, emp_role, emp_username, emp_password, emp_salary, emp_startdate, emp_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            ps.setString(1, employee.getEmp_name());
            ps.setString(2, employee.getEmp_phone());
            ps.setString(3, employee.getEmp_email());
            ps.setString(4, employee.getEmp_address());
            ps.setString(5, employee.getEmp_dateOfBirth());
            ps.setString(6, UserRole.STAFF.toString());
            ps.setString(7, employee.getEmp_username());
            ps.setString(8, employee.getEmp_password());
            ps.setDouble(9, employee.getEmp_salary());
            ps.setString(10, employee.getEmp_startDate());
            ps.setBoolean(11, true);
            ps.executeUpdate();
            ps.close();
            JOptionPane.showMessageDialog(null, "Inserted successfully");
        } catch (Exception e) {
            if (e instanceof SQLException) {
                JOptionPane.showMessageDialog(null, "Already Exists");
            }
        }
	}

	@Override
	public void updateEmployee(String id, Employee employee) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void blockEmployee(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Employee> findAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee findEmployeeById(String id) {
		// TODO Auto-generated method stub
		Employee employee = new Employee();

        try (Statement st = this.dbConfig.getConnection().createStatement()) {

            String query = "SELECT * FROM employee WHERE emp_id = " + id + ";";

            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                this.employeeMapper.mapToEmployee(employee, rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return employee;
    
	}
}
