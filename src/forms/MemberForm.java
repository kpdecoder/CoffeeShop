package forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import java.awt.Color;

public class MemberForm {

	private JFrame frmMember;
	private JTextField textName;
	private JTextField textPhone;
	private JTextField textEmail;
	private JTextField textAddress;
	private JTextField textAmount;
	private JTextField textSearch;
	private JTable tblMember;
	private DefaultTableModel dtm = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberForm window = new MemberForm();
					window.frmMember.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MemberForm() {
		initialize();
		this.setTableDesign();
	}

	private void setTableDesign() {
		dtm.addColumn("ID");
		dtm.addColumn("Name");
		dtm.addColumn("Phone");
		dtm.addColumn("Email");
		dtm.addColumn("Address");
		dtm.addColumn("Date Of Birth");
		dtm.addColumn("Start Date");
		dtm.addColumn("Amount");
		dtm.addColumn("Status");
		this.tblMember.setModel(dtm);
	}

	private void resetFormData() {
		textName.setText("");
		textPhone.setText("");
		textEmail.setText("");
		textAddress.setText("");
		textAmount.setText("");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMember = new JFrame();
		frmMember.getContentPane().setBackground(new Color(255, 250, 250));
		frmMember.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frmMember.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 12));
		frmMember.setTitle("Member");
		frmMember.setBounds(130, 120, 1100, 465);
		frmMember.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMember.getContentPane().setLayout(null);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblName.setBounds(10, 10, 100, 20);
		frmMember.getContentPane().add(lblName);

		textName = new JTextField();
		textName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textName.setBounds(10, 32, 160, 20);
		frmMember.getContentPane().add(textName);
		textName.setColumns(10);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblPhone.setBounds(10, 54, 100, 20);
		frmMember.getContentPane().add(lblPhone);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblEmail.setBounds(10, 98, 100, 20);
		frmMember.getContentPane().add(lblEmail);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblAddress.setBounds(10, 142, 100, 20);
		frmMember.getContentPane().add(lblAddress);

		JLabel lblDateOfBirth = new JLabel("Date Of Birth");
		lblDateOfBirth.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblDateOfBirth.setBounds(10, 186, 100, 20);
		frmMember.getContentPane().add(lblDateOfBirth);

		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblStartDate.setBounds(10, 230, 100, 20);
		frmMember.getContentPane().add(lblStartDate);

		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblAmount.setBounds(10, 274, 100, 20);
		frmMember.getContentPane().add(lblAmount);

		textPhone = new JTextField();
		textPhone.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textPhone.setColumns(10);
		textPhone.setBounds(10, 76, 160, 20);
		frmMember.getContentPane().add(textPhone);

		textEmail = new JTextField();
		textEmail.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textEmail.setColumns(10);
		textEmail.setBounds(10, 120, 160, 20);
		frmMember.getContentPane().add(textEmail);

		textAddress = new JTextField();
		textAddress.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textAddress.setColumns(10);
		textAddress.setBounds(10, 164, 160, 20);
		frmMember.getContentPane().add(textAddress);

		textAmount = new JTextField();
		textAmount.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textAmount.setColumns(10);
		textAmount.setBounds(10, 296, 160, 20);
		frmMember.getContentPane().add(textAmount);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnAdd.setBounds(10, 348, 75, 20);
		frmMember.getContentPane().add(btnAdd);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetFormData();
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnCancel.setBounds(95, 348, 75, 20);
		frmMember.getContentPane().add(btnCancel);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnUpdate.setBounds(10, 390, 75, 20);
		frmMember.getContentPane().add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnDelete.setBounds(95, 390, 75, 20);
		frmMember.getContentPane().add(btnDelete);

		JLabel lblSearchByName = new JLabel("Search by name :");
		lblSearchByName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblSearchByName.setBounds(719, 10, 100, 20);
		frmMember.getContentPane().add(lblSearchByName);

		textSearch = new JTextField();
		textSearch.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textSearch.setColumns(10);
		textSearch.setBounds(829, 10, 160, 20);
		frmMember.getContentPane().add(textSearch);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSearch.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnSearch.setBounds(999, 9, 75, 20);
		frmMember.getContentPane().add(btnSearch);

		tblMember = new JTable();
		tblMember.setFont(new Font("Times New Roman", Font.PLAIN, 13));
//		tblMember.setBounds(180, 57, 894, 428);
//		frmMember.getContentPane().add(tblMember);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(180, 56, 894, 354);
		frmMember.getContentPane().add(scrollPane);
		scrollPane.setViewportView(tblMember);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(10, 208, 160, 20);
		frmMember.getContentPane().add(dateChooser);

		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(10, 252, 160, 20);
		frmMember.getContentPane().add(dateChooser_1);

		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblStatus.setBounds(10, 321, 50, 20);
		frmMember.getContentPane().add(lblStatus);

		ButtonGroup btg = new ButtonGroup();

		JRadioButton rdbtnOn = new JRadioButton("On");
		rdbtnOn.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		rdbtnOn.setBounds(62, 321, 50, 21);
		frmMember.getContentPane().add(rdbtnOn);

		JRadioButton rdbtnOff = new JRadioButton("Off");
		rdbtnOff.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		rdbtnOff.setBounds(120, 322, 50, 21);
		frmMember.getContentPane().add(rdbtnOff);

		btg.add(rdbtnOn);
		btg.add(rdbtnOff);
	}
}
