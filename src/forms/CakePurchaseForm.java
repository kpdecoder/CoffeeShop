package forms;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class CakePurchaseForm {

	private JFrame frmCakePurchase;
	private JTextField textCakeName;
	private JTextField textQuantity;
	private JTextField textPrice;
	private JTable tableCakePurchase;
	private DefaultTableModel dtm = new DefaultTableModel();
	private JTextField textNetAmount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CakePurchaseForm window = new CakePurchaseForm();
					window.frmCakePurchase.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CakePurchaseForm() {
		initialize();
		this.setTableDesign();
	}

	private void setTableDesign() {
		dtm.addColumn("Cake Name");
		dtm.addColumn("Category");
		dtm.addColumn("Quantity");
		dtm.addColumn("Price");
		dtm.addColumn("Total");
		this.tableCakePurchase.setModel(dtm);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCakePurchase = new JFrame();
		frmCakePurchase.getContentPane().setBackground(new Color(255, 255, 240));
		frmCakePurchase.setTitle("Cake Purchase");
		frmCakePurchase.setBounds(270, 140, 1000, 570);
		frmCakePurchase.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCakePurchase.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\CoffeeShop\\img\\cake.png"));
		lblNewLabel.setBounds(43, 22, 100, 89);
		frmCakePurchase.getContentPane().add(lblNewLabel);

		JLabel lblStaffName = new JLabel("Staff Name");
		lblStaffName.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblStaffName.setBounds(10, 116, 100, 20);
		frmCakePurchase.getContentPane().add(lblStaffName);

		JLabel lblName_1 = new JLabel("Cake Name");
		lblName_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblName_1.setBounds(10, 233, 100, 20);
		frmCakePurchase.getContentPane().add(lblName_1);

		JLabel lblCakeCategory = new JLabel("Cake Category");
		lblCakeCategory.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblCakeCategory.setBounds(10, 293, 100, 20);
		frmCakePurchase.getContentPane().add(lblCakeCategory);

		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblQuantity.setBounds(10, 353, 100, 20);
		frmCakePurchase.getContentPane().add(lblQuantity);

		textCakeName = new JTextField();
		textCakeName.setColumns(10);
		textCakeName.setBounds(10, 263, 160, 20);
		frmCakePurchase.getContentPane().add(textCakeName);

		textQuantity = new JTextField();
		textQuantity.setColumns(10);
		textQuantity.setBounds(10, 383, 160, 20);
		frmCakePurchase.getContentPane().add(textQuantity);

		JComboBox comboBoxCakeCategory = new JComboBox();
		comboBoxCakeCategory.setBounds(10, 323, 160, 20);
		frmCakePurchase.getContentPane().add(comboBoxCakeCategory);

		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblPrice.setBounds(10, 413, 100, 20);
		frmCakePurchase.getContentPane().add(lblPrice);

		textPrice = new JTextField();
		textPrice.setColumns(10);
		textPrice.setBounds(10, 443, 160, 20);
		frmCakePurchase.getContentPane().add(textPrice);

		JComboBox comboBoxStaff = new JComboBox();
		comboBoxStaff.setBounds(10, 145, 160, 20);
		frmCakePurchase.getContentPane().add(comboBoxStaff);

		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemove.setBackground(new Color(255, 255, 204));
		btnRemove.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnRemove.setBounds(10, 485, 75, 20);
		frmCakePurchase.getContentPane().add(btnRemove);

		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(204, 255, 204));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnAdd.setBounds(95, 485, 75, 20);
		frmCakePurchase.getContentPane().add(btnAdd);

		JLabel lblPurchaseDate = new JLabel("Purchase Date");
		lblPurchaseDate.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblPurchaseDate.setBounds(10, 175, 100, 20);
		frmCakePurchase.getContentPane().add(lblPurchaseDate);

		JDateChooser dateChooserCakePurchase = new JDateChooser();
		dateChooserCakePurchase.setBounds(10, 203, 160, 20);
		frmCakePurchase.getContentPane().add(dateChooserCakePurchase);

		tableCakePurchase = new JTable();
		tableCakePurchase.setBackground(Color.WHITE);
		tableCakePurchase.setFont(new Font("Times New Roman", Font.PLAIN, 13));
//		tableCakePurchase.setBounds(200, 145, 761, 320);
//		frmCakePurchase.getContentPane().add(tableCakePurchase);

		JScrollPane scrollPaneCakePurchase = new JScrollPane();
		scrollPaneCakePurchase.setBounds(200, 145, 761, 287);
		frmCakePurchase.getContentPane().add(scrollPaneCakePurchase);
		scrollPaneCakePurchase.setViewportView(tableCakePurchase);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSave.setBackground(new Color(204, 255, 153));
		btnSave.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnSave.setBounds(886, 485, 75, 20);
		frmCakePurchase.getContentPane().add(btnSave);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancel.setBackground(new Color(255, 255, 153));
		btnCancel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnCancel.setBounds(801, 485, 75, 20);
		frmCakePurchase.getContentPane().add(btnCancel);

		textNetAmount = new JTextField();
		textNetAmount.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textNetAmount.setBounds(200, 443, 761, 20);
		frmCakePurchase.getContentPane().add(textNetAmount);
		textNetAmount.setColumns(10);

	}
}
