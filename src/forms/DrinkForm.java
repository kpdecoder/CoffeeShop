package forms;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import models.Drink;
import services.DrinkServices;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionEvent;

public class DrinkForm {

	private JFrame drinkframe;
	private JTextField txtdrinkName;
	private JTextField txtdrinkPrice;
	// private List<Drink> drinkList = new ArrayList<>();
	private JComboBox comboBoxCategory;
	private Drink drink;
	private DrinkServices drinkService;
	private JTable tblDrink;
	private DefaultTableModel dtm = new DefaultTableModel();
	private List<Drink> drinkList = new ArrayList<>();
	private List<Drink> filtereddrinkList = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrinkForm window = new DrinkForm();
					window.drinkframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DrinkForm() {
		initialize();
		initializeDependency();
		this.setTableDesign();
		this.loadAllDrink(Optional.empty());

	}

	private void initializeDependency() {
		this.drinkService = new DrinkServices();
	}

	private void setTableDesign() {
		dtm.addColumn("ID");
		dtm.addColumn("Name");
		dtm.addColumn("Category");
		dtm.addColumn("Price");
		this.tblDrink.setModel(dtm);
	}

	private void loadAllDrink(Optional<List<Drink>> optionalDrink) {

		this.dtm = (DefaultTableModel) this.tblDrink.getModel();
		this.dtm.getDataVector().removeAllElements();
		this.dtm.fireTableDataChanged();
		this.drinkList = this.drinkService.findAllDrink();
		this.filtereddrinkList = optionalDrink.orElseGet(() -> this.drinkList).stream().collect(Collectors.toList());
		filtereddrinkList.forEach(e -> {
			Object[] row = new Object[4];
			row[0] = e.getDrink_id();
			row[1] = e.getDrink_name();
			row[2] = e.getDrink_category();
			row[3] = e.getDrink_price();
			dtm.addRow(row);

		});
		this.tblDrink.setModel(dtm);

	}

	private void resetFormData() {
		txtdrinkName.setText("");
		comboBoxCategory.setSelectedItem("");
		txtdrinkPrice.setText("");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		drinkframe = new JFrame();
		drinkframe.setBounds(100, 100, 1000, 500);
		drinkframe.setTitle("Drink Menu");
		drinkframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drinkframe.getContentPane().setLayout(null);

		JLabel lbldrinkName = new JLabel("Name");
		lbldrinkName.setBounds(26, 29, 100, 22);
		drinkframe.getContentPane().add(lbldrinkName);

		JLabel lbldrinkCategory = new JLabel("Category");
		lbldrinkCategory.setBounds(26, 85, 100, 22);
		drinkframe.getContentPane().add(lbldrinkCategory);

		txtdrinkName = new JTextField();
		txtdrinkName.setBounds(154, 31, 100, 22);
		drinkframe.getContentPane().add(txtdrinkName);
		txtdrinkName.setColumns(10);

		JLabel lbldrinkPrice = new JLabel("Price");
		lbldrinkPrice.setBounds(23, 152, 100, 22);
		drinkframe.getContentPane().add(lbldrinkPrice);

		txtdrinkPrice = new JTextField();
		txtdrinkPrice.setBounds(155, 153, 99, 20);
		drinkframe.getContentPane().add(txtdrinkPrice);
		txtdrinkPrice.setColumns(10);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Drink drink = new Drink();
				drinkService = new DrinkServices();

				drink.setDrink_name(txtdrinkName.getText());
				drink.setDrink_category(comboBoxCategory.getSelectedItem().toString());
				drink.setDrink_price(Double.parseDouble(txtdrinkPrice.getText()));
				if (!drink.getDrink_category().isBlank() && !drink.getDrink_name().isBlank()
						&& drink.getDrink_price() != 0) {
					drinkService.createDrink(drink);
				} else {
					JOptionPane.showMessageDialog(null, "Enter Required Field");
				}

			}
		});

		btnAdd.setBounds(37, 211, 89, 23);
		drinkframe.getContentPane().add(btnAdd);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(149, 211, 89, 23);
		drinkframe.getContentPane().add(btnUpdate);
		btnUpdate.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				drink.setDrink_name(txtdrinkName.getText());
				drink.setDrink_category(comboBoxCategory.getSelectedItem().toString());
				drink.setDrink_price(Double.parseDouble(txtdrinkPrice.getText()));
				// drink.setEmpSalary(Integer.parseInt(txtSalary.getText()));
				if (!drink.getDrink_name().isBlank() && !drink.getDrink_category().isBlank()
						&& drink.getDrink_price() != 0) {
					drinkService.updateDrink(String.valueOf(drink.getDrink_id()), drink);
					resetFormData();
					loadAllDrink(Optional.empty());
					drink = null;
				}

			}

		});

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				// employee.setEmpName(txtName.getText());
				// employee.setEmpAddress(txtAddress.getText());
				// employee.setEmpSalary(Integer.parseInt(txtSalary.getText()));
				if (!drink.getDrink_category().isBlank() && !drink.getDrink_name().isBlank()
						&& drink.getDrink_price() != 0) {
					drinkService.delete(String.valueOf(drink.getDrink_id()), drink);
					resetFormData();
					loadAllDrink(Optional.empty());
					drink = null;
				}

			}

		});

		btnDelete.setBounds(98, 238, 89, 23);
		drinkframe.getContentPane().add(btnDelete);

		comboBoxCategory = new JComboBox();

		comboBoxCategory.setBounds(154, 85, 100, 22);
		comboBoxCategory.addItem("-SELECT-");
		comboBoxCategory.addItem("HOT");
		comboBoxCategory.addItem("COLD");

		drinkframe.getContentPane().add(comboBoxCategory);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(300, 29, 351, 232);
		drinkframe.getContentPane().add(scrollPane);

		tblDrink = new JTable();
		tblDrink.setBounds(105, 52, 295, 135);
		scrollPane.setViewportView(tblDrink);
		this.tblDrink.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
			if (!tblDrink.getSelectionModel().isSelectionEmpty()) {
				String id = tblDrink.getValueAt(tblDrink.getSelectedRow(), 0).toString();
				drink = drinkService.findDrinkById(id);
				txtdrinkName.setText(drink.getDrink_name());
				comboBoxCategory.setSelectedItem(drink.getDrink_category());
				txtdrinkPrice.setText(drink.getDrink_price() + "");
			}
		});

	}
}
