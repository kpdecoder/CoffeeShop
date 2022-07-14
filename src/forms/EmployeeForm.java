package forms;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import models.Employee;
import models.UserRole;
import services.EmployeeService;

import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JRadioButton;
import java.awt.Color;

public class EmployeeForm {

	public JFrame frmEmployee;
	private JTextField textName;
	private JLabel lblPhone;
	private JTextField textPhone;
	private JLabel lblEmail;
	private JTextField textEmail;
	private JLabel lblAddress;
	private JTextField textAddress;
	private JLabel lblDateOfBirth;
	private JLabel lblRole;
	private JLabel lblUserName;
	private JLabel lblPassword;
	private JLabel lblSalary;
	private JLabel lblStartDate;
	private JTextField textUserName;
	private JTextField textPassword;
	private JTextField textSalary;
	private JButton btnAdd;
	private JButton btnCancel;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JLabel lblSearch;
	private JTextField textSearch;
	private JButton btnSearch;
	private DefaultTableModel dtm = new DefaultTableModel();
	private JTable tblEmployee;
	private JScrollPane scrollPane;
	private Employee employee;
	private EmployeeService employeeService;
	private List<Employee> originalEmployeeList = new ArrayList<>();
	private Object dbConfig;
	private JLabel lblStatus;
	private JRadioButton rdbtnOn;
	private JRadioButton rdbtnOff;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeForm window = new EmployeeForm();
					window.frmEmployee.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EmployeeForm() {
		initialize();
		initializeDependency();
		this.setTableDesign();

	}

	public void initializeDependency() {
		this.employeeService = new EmployeeService();
	}

	private void setTableDesign() {
		dtm.addColumn("ID");
		dtm.addColumn("Name");
		dtm.addColumn("Phone");
		dtm.addColumn("Email");
		dtm.addColumn("Address");
		dtm.addColumn("Date Of Birth");
		dtm.addColumn("Role");
		dtm.addColumn("Username");
		dtm.addColumn("Password");
		dtm.addColumn("Salary");
		dtm.addColumn("Start Date");
		dtm.addColumn("Status");
		this.tblEmployee.setModel(dtm);
	}

	private void resetFormData() {
		textName.setText("");
		textPhone.setText("");
		textEmail.setText("");
		textAddress.setText("");
//		textRole.setText("");
		textUserName.setText("");
		textPassword.setText("");
		textSalary.setText("");

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEmployee = new JFrame();
		frmEmployee.getContentPane().setBackground(new Color(255, 250, 250));
		frmEmployee.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frmEmployee.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frmEmployee.setTitle("Employee ");
		frmEmployee.setBounds(10, 50, 1350, 615);
		frmEmployee.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEmployee.getContentPane().setLayout(null);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblName.setBounds(10, 10, 100, 20);
		frmEmployee.getContentPane().add(lblName);

		textName = new JTextField();
		textName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textName.setBounds(10, 32, 160, 20);
		frmEmployee.getContentPane().add(textName);
		textName.setColumns(10);

		lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblPhone.setBounds(10, 54, 100, 20);
		frmEmployee.getContentPane().add(lblPhone);

		textPhone = new JTextField();
		textPhone.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textPhone.setColumns(10);
		textPhone.setBounds(10, 76, 160, 20);
		frmEmployee.getContentPane().add(textPhone);

		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblEmail.setBounds(10, 98, 100, 20);
		frmEmployee.getContentPane().add(lblEmail);

		textEmail = new JTextField();
		textEmail.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textEmail.setColumns(10);
		textEmail.setBounds(10, 120, 160, 20);
		frmEmployee.getContentPane().add(textEmail);

		lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblAddress.setBounds(10, 142, 100, 20);
		frmEmployee.getContentPane().add(lblAddress);

		textAddress = new JTextField();
		textAddress.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textAddress.setColumns(10);
		textAddress.setBounds(10, 164, 160, 20);
		frmEmployee.getContentPane().add(textAddress);

		lblDateOfBirth = new JLabel("Date Of Birth");
		lblDateOfBirth.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblDateOfBirth.setBounds(10, 186, 100, 20);
		frmEmployee.getContentPane().add(lblDateOfBirth);

		lblRole = new JLabel("Role");
		lblRole.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblRole.setBounds(10, 230, 100, 20);
		frmEmployee.getContentPane().add(lblRole);

		lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblUserName.setBounds(10, 274, 100, 20);
		frmEmployee.getContentPane().add(lblUserName);

		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblPassword.setBounds(10, 318, 100, 20);
		frmEmployee.getContentPane().add(lblPassword);

		lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblSalary.setBounds(10, 362, 100, 20);
		frmEmployee.getContentPane().add(lblSalary);

		lblStartDate = new JLabel("Start Date");
		lblStartDate.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblStartDate.setBounds(10, 406, 100, 20);
		frmEmployee.getContentPane().add(lblStartDate);

		textUserName = new JTextField();
		textUserName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textUserName.setColumns(10);
		textUserName.setBounds(10, 296, 160, 20);
		frmEmployee.getContentPane().add(textUserName);

		textPassword = new JTextField();
		textPassword.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textPassword.setColumns(10);
		textPassword.setBounds(10, 340, 160, 20);
		frmEmployee.getContentPane().add(textPassword);

		textSalary = new JTextField();
		textSalary.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textSalary.setColumns(10);
		textSalary.setBounds(10, 384, 160, 20);
		frmEmployee.getContentPane().add(textSalary);

		JDateChooser dateChooserDOB = new JDateChooser();
		dateChooserDOB.setBounds(10, 208, 160, 20);
		frmEmployee.getContentPane().add(dateChooserDOB);

		JDateChooser dateChooserSD = new JDateChooser();
		dateChooserSD.setBounds(10, 428, 160, 20);
		frmEmployee.getContentPane().add(dateChooserSD);

		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Employee employee = new Employee();

				employee.setEmp_name(textName.getText());
				employee.setEmp_phone(textPhone.getText());
				employee.setEmp_email(textEmail.getText());
				employee.setEmp_address(textAddress.getText());

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String date = sdf.format(dateChooserDOB.getDate());
				employee.setEmp_dateOfBirth(date);
				System.out.println(date);

				employee.setEmp_username(textUserName.getText());
				employee.setEmp_password(textPassword.getText());
				employee.setEmp_salary(Double.parseDouble(textSalary.getText()));

				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
				String date2 = sdf2.format(dateChooserSD.getDate());
				employee.setEmp_startDate(date2);
				System.out.println(date2);

				if (!employee.getEmp_name().isBlank() && !employee.getEmp_phone().isBlank()) {

					employeeService.createEmployee(employee);
					resetFormData();
					textName.requestFocus();
				} else {
					JOptionPane.showMessageDialog(null, "Enter Required Field");
				}

			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnAdd.setBounds(10, 503, 75, 20);
		frmEmployee.getContentPane().add(btnAdd);

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetFormData();
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnCancel.setBounds(95, 503, 75, 20);
		frmEmployee.getContentPane().add(btnCancel);

		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnUpdate.setBounds(10, 534, 75, 20);
		frmEmployee.getContentPane().add(btnUpdate);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnDelete.setBounds(95, 534, 75, 20);
		frmEmployee.getContentPane().add(btnDelete);

		lblSearch = new JLabel("Search by name :");
		lblSearch.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblSearch.setBounds(959, 32, 100, 20);
		frmEmployee.getContentPane().add(lblSearch);

		textSearch = new JTextField();
		textSearch.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textSearch.setBounds(1069, 32, 160, 20);
		frmEmployee.getContentPane().add(textSearch);
		textSearch.setColumns(10);

		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnSearch.setBounds(1239, 32, 85, 20);
		frmEmployee.getContentPane().add(btnSearch);

		tblEmployee = new JTable();
		tblEmployee.setFont(new Font("Times New Roman", Font.PLAIN, 13));
//		tblEmployee.setBounds(200, 73, 1059, 481);
//		frmEmployee.getContentPane().add(tblEmployee);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(180, 76, 1144, 478);
		frmEmployee.getContentPane().add(scrollPane);
		scrollPane.setViewportView(tblEmployee);

		JComboBox comboBoxRole = new JComboBox();
		comboBoxRole.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		comboBoxRole.setBounds(10, 252, 160, 20);
		frmEmployee.getContentPane().add(comboBoxRole);
		comboBoxRole.addItem("Select");
		comboBoxRole.addItem("Manager");
		comboBoxRole.addItem("Staff");
		comboBoxRole.addItem("Cashier");
		comboBoxRole.addItem("Waiter");

		lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblStatus.setBounds(10, 454, 50, 20);
		frmEmployee.getContentPane().add(lblStatus);

		ButtonGroup btg = new ButtonGroup();

		rdbtnOn = new JRadioButton("On");
		rdbtnOn.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		rdbtnOn.setBounds(67, 454, 45, 21);
		frmEmployee.getContentPane().add(rdbtnOn);

		rdbtnOff = new JRadioButton("Off");
		rdbtnOff.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		rdbtnOff.setBounds(125, 454, 45, 21);
		frmEmployee.getContentPane().add(rdbtnOff);

		btg.add(rdbtnOn);
		btg.add(rdbtnOff);

	}
}
