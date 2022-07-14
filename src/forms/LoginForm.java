package forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.Font;
import javax.swing.JTextField;

import models.Employee;
import services.AuthService;
import services.EmployeeService;
import shared.utils.CurrentUserHolder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginForm {

	private JFrame frmLogin;
	private JTextField textUserName;
	private JPasswordField textPassword;
	private Employee employee;
	private EmployeeService employeeService;
	private AuthService authService;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm window = new LoginForm();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginForm() {
		initialize();
		initializeDependency();
	}

	private void resetFormData() {
		textUserName.setText("");
		textPassword.setText("");
	}

	private void initializeDependency() {
		this.employeeService = new EmployeeService();
		this.authService = new AuthService();
	}

	public LoginForm(Employee employee) {
		this.employee = employee;
		initialize();
		initializeDependency();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(470, 200, 450, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);

		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblUserName.setBounds(71, 89, 100, 20);
		frmLogin.getContentPane().add(lblUserName);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblPassword.setBounds(71, 141, 100, 20);
		frmLogin.getContentPane().add(lblPassword);

		textUserName = new JTextField();
		textUserName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textUserName.setBounds(202, 89, 182, 20);
		frmLogin.getContentPane().add(textUserName);
		textUserName.setColumns(10);

		textPassword = new JPasswordField();
		textPassword.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textPassword.setColumns(10);
		textPassword.setBounds(202, 141, 182, 20);
		frmLogin.getContentPane().add(textPassword);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textUserName.getText();
				String password = String.valueOf(textPassword.getPassword());

				if (!username.isBlank() && !password.isBlank()) {
					String loggedInUserId = authService.login(username, password);
					if (!loggedInUserId.isBlank()) {
						CurrentUserHolder.setLoggedInUser(employeeService.findEmployeeById(loggedInUserId));
						JOptionPane.showMessageDialog(null, "Successfully Login");
						frmLogin.setVisible(false);
						EmployeeForm employeeForm = new EmployeeForm();
						employeeForm.frmEmployee.setVisible(true);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Enter required Fields");
				}

			}
		});
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnLogin.setBounds(202, 207, 85, 20);
		frmLogin.getContentPane().add(btnLogin);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetFormData();
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnCancel.setBounds(299, 207, 85, 20);
		frmLogin.getContentPane().add(btnCancel);

		JLabel lblNewLabel = new JLabel("313C Coffee and Backery");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(110, 34, 250, 23);
		frmLogin.getContentPane().add(lblNewLabel);
	}
}
