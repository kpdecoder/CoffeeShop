package forms;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import models.Cake;
import models.Drink;
import services.CakeServices;
import services.DrinkServices;

import javax.swing.JComboBox;

public class CakeForm {

	private JFrame cakeframe;
	private JTextField txtcakeName;
	private JTextField txtcakePrice;
	private JTextField txtcakeQuantity;
	private JComboBox comboBoxcakeCategory;
	private DefaultTableModel dtm = new DefaultTableModel();
	private List<Cake> cakeList = new ArrayList<>();
	private List<Cake> filteredcakeList = new ArrayList<>();
	private CakeServices cakeService;
	private JTable tblCake;
	private Cake cake;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CakeForm window = new CakeForm();
					window.cakeframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CakeForm() {
		initialize();
		initializeDependency();
		this.setTableDesign();
		this.loadAllCake(Optional.empty());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeDependency() {
		this.cakeService = new CakeServices();
	}

	private void setTableDesign() {
		dtm.addColumn("ID");
		dtm.addColumn("Name");
		dtm.addColumn("Category");
		dtm.addColumn("Price");
		dtm.addColumn("Quantity");
		this.tblCake.setModel(dtm);
	}

	private void loadAllCake(Optional<List<Cake>> optionalCake) {

		this.dtm = (DefaultTableModel) this.tblCake.getModel();
		this.dtm.getDataVector().removeAllElements();
		this.dtm.fireTableDataChanged();
		this.cakeList = this.cakeService.findAllCake();
		this.filteredcakeList = optionalCake.orElseGet(() -> this.cakeList).stream().collect(Collectors.toList());
		filteredcakeList.forEach(e -> {
			Object[] row = new Object[5];
			row[0] = e.getCake_id();
			row[1] = e.getCake_name();
			row[2] = e.getCake_category();
			row[3] = e.getCake_price();
			row[4] = e.getCake_quantity();
			dtm.addRow(row);

		});
		this.tblCake.setModel(dtm);

	}

	private void resetFormData() {
		txtcakeName.setText("");
		comboBoxcakeCategory.setSelectedItem("");
		txtcakePrice.setText("");
		txtcakeQuantity.setText("");
	}

	private void initialize() {
		cakeframe = new JFrame();
		cakeframe.setBounds(100, 100, 1000, 500);
		cakeframe.setTitle("Cake Menu");
		cakeframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cakeframe.getContentPane().setLayout(null);

		JLabel lblcakeName = new JLabel("Name");
		lblcakeName.setBounds(26, 29, 100, 20);
		cakeframe.getContentPane().add(lblcakeName);

		JLabel lblcakeCategory = new JLabel("Category");
		lblcakeCategory.setBounds(26, 74, 100, 20);
		cakeframe.getContentPane().add(lblcakeCategory);

		JLabel lblcakePrice = new JLabel("Price");
		lblcakePrice.setBounds(26, 124, 100, 20);
		cakeframe.getContentPane().add(lblcakePrice);

		JLabel lblcakeQuantity = new JLabel("Quantity");
		lblcakeQuantity.setBounds(28, 171, 98, 20);
		cakeframe.getContentPane().add(lblcakeQuantity);

		JButton btncakeAdd = new JButton("Add");
		btncakeAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cake cake = new Cake();
				CakeServices cakeService = new CakeServices();

				cake.setCake_name(txtcakeName.getText());
				cake.setCake_category(comboBoxcakeCategory.getSelectedItem().toString());
				cake.setCake_price(Double.parseDouble(txtcakePrice.getText()));
				cake.setCake_Quantity(Integer.parseInt(txtcakePrice.getText()));
				if (!cake.getCake_name().isBlank() && !cake.getCake_category().isBlank() && cake.getCake_price() != 0
						&& cake.getCake_quantity() != 0) {
					cakeService.createCake(cake);
				} else {
					JOptionPane.showMessageDialog(null, "Enter Required Field");
				}

			}
		});
		btncakeAdd.setBounds(69, 224, 91, 21);
		cakeframe.getContentPane().add(btncakeAdd);

		JButton btncakeUpdate = new JButton("Update");
		btncakeUpdate.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				cake.setCake_name(txtcakeName.getText());
				cake.setCake_category(comboBoxcakeCategory.getSelectedItem().toString());
				cake.setCake_price(Double.parseDouble(txtcakePrice.getText()));
				cake.setCake_Quantity(Integer.parseInt(txtcakeQuantity.getText()));
				// drink.setEmpSalary(Integer.parseInt(txtSalary.getText()));
				if (!cake.getCake_name().isBlank() && !cake.getCake_category().isBlank() && cake.getCake_price() != 0
						&& cake.getCake_quantity() != 0) {
					cakeService.updateCake(String.valueOf(cake.getCake_id()), cake);
					resetFormData();
					loadAllCake(Optional.empty());
					cake = null;
				}

			}

		});

		btncakeUpdate.setBounds(172, 224, 91, 21);
		cakeframe.getContentPane().add(btncakeUpdate);

		JButton btncakeDelete = new JButton("Delete");
		btncakeDelete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				// employee.setEmpName(txtName.getText());
				// employee.setEmpAddress(txtAddress.getText());
				// employee.setEmpSalary(Integer.parseInt(txtSalary.getText()));
				if (!cake.getCake_name().isBlank() && !cake.getCake_category().isBlank() && cake.getCake_price() != 0
						&& cake.getCake_quantity() != 0) {
					cakeService.delete(String.valueOf(cake.getCake_id()), cake);
					resetFormData();
					loadAllCake(Optional.empty());
					cake = null;
				}

			}

		});

		btncakeDelete.setBounds(87, 255, 91, 26);
		cakeframe.getContentPane().add(btncakeDelete);

		txtcakeName = new JTextField();
		txtcakeName.setBounds(138, 27, 116, 26);
		cakeframe.getContentPane().add(txtcakeName);
		txtcakeName.setColumns(10);

		txtcakePrice = new JTextField();
		txtcakePrice.setBounds(138, 122, 117, 26);
		cakeframe.getContentPane().add(txtcakePrice);
		txtcakePrice.setColumns(10);

		txtcakeQuantity = new JTextField();
		txtcakeQuantity.setBounds(138, 169, 116, 26);
		cakeframe.getContentPane().add(txtcakeQuantity);
		txtcakeQuantity.setColumns(10);

		comboBoxcakeCategory = new JComboBox();
		comboBoxcakeCategory.addItem("Select");
		comboBoxcakeCategory.addItem("Small");
		comboBoxcakeCategory.addItem("Medium");
		comboBoxcakeCategory.addItem("Large");
		// comboBoxcakeCategory.addItem("Cheese Cake");

		comboBoxcakeCategory.setBounds(138, 74, 115, 21);
		cakeframe.getContentPane().add(comboBoxcakeCategory);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(277, 49, 400, 232);
		cakeframe.getContentPane().add(scrollPane);

		tblCake = new JTable();
		tblCake.setBounds(110, 52, 295, 135);
		scrollPane.setViewportView(tblCake);
		this.tblCake.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
			if (!tblCake.getSelectionModel().isSelectionEmpty()) {
				String id = tblCake.getValueAt(tblCake.getSelectedRow(), 0).toString();
				cake = cakeService.findCakeById(id);
				txtcakeName.setText(cake.getCake_name());
				comboBoxcakeCategory.setSelectedItem(cake.getCake_category());
				txtcakePrice.setText(cake.getCake_price() + "");
				txtcakeQuantity.setText(cake.getCake_quantity() + "");
			}
		});

	}
}
