package forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DiscountForm {

	private JFrame Discount;
	private JTextField textDiscountName;
	private JTextField textDiscountValue;
	private JTable tableDiscount;
	private DefaultTableModel dtm = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DiscountForm window = new DiscountForm();
					window.Discount.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DiscountForm() {
		initialize();
		this.setTableDesign();
	}

	private void setTableDesign() {
		dtm.addColumn("ID");
		dtm.addColumn("Discount Name");
		dtm.addColumn("Value");
		dtm.addColumn("Status");
		this.tableDiscount.setModel(dtm);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Discount = new JFrame();
		Discount.getContentPane().setBackground(new Color(255, 204, 255));
		Discount.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Discount.setTitle("Discount");
		Discount.setBounds(420, 250, 700, 400);
		Discount.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Discount.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\CoffeeShop\\img\\Discount.png"));
		lblNewLabel.setBounds(64, 20, 64, 71);
		Discount.getContentPane().add(lblNewLabel);

		JLabel lblDiscountName = new JLabel("Discount Name");
		lblDiscountName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblDiscountName.setBounds(10, 118, 100, 20);
		Discount.getContentPane().add(lblDiscountName);

		textDiscountName = new JTextField();
		textDiscountName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textDiscountName.setBounds(10, 148, 160, 20);
		Discount.getContentPane().add(textDiscountName);
		textDiscountName.setColumns(10);

		JLabel lblDiscountValue = new JLabel("Discount Value");
		lblDiscountValue.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblDiscountValue.setBounds(10, 178, 100, 20);
		Discount.getContentPane().add(lblDiscountValue);

		textDiscountValue = new JTextField();
		textDiscountValue.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		textDiscountValue.setColumns(10);
		textDiscountValue.setBounds(10, 208, 160, 20);
		Discount.getContentPane().add(textDiscountValue);

		JLabel lblNewLabel_1_1_1 = new JLabel("Status");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(10, 238, 45, 20);
		Discount.getContentPane().add(lblNewLabel_1_1_1);

		ButtonGroup btg = new ButtonGroup();

		JRadioButton rdbtnOn = new JRadioButton("On");
		rdbtnOn.setBackground(new Color(255, 204, 255));
		rdbtnOn.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		rdbtnOn.setBounds(64, 238, 45, 20);
		Discount.getContentPane().add(rdbtnOn);

		JRadioButton rdbtnOff = new JRadioButton("Off");
		rdbtnOff.setBackground(new Color(255, 204, 255));
		rdbtnOff.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		rdbtnOff.setBounds(111, 238, 45, 20);
		Discount.getContentPane().add(rdbtnOff);
		btg.add(rdbtnOn);
		btg.add(rdbtnOff);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnAdd.setBounds(10, 283, 70, 20);
		Discount.getContentPane().add(btnAdd);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnCancel.setBounds(100, 283, 70, 20);
		Discount.getContentPane().add(btnCancel);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnUpdate.setBounds(10, 320, 70, 20);
		Discount.getContentPane().add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnDelete.setBounds(100, 320, 70, 20);
		Discount.getContentPane().add(btnDelete);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(204, 118, 472, 222);
		Discount.getContentPane().add(scrollPane);

		tableDiscount = new JTable();
		tableDiscount.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		scrollPane.setViewportView(tableDiscount);
	}
}
