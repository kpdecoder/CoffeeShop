package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

//import com.mysql.cj.xdevapi.Statement;

import config.DBConfig;
//import mapper.StaffMapper;
import models.Drink;
import repositories.DrinkRepo;
//import models.Staff;
//import models.UserRole;
//import repositories.StaffRepo;

public class DrinkServices implements DrinkRepo {
	public final DBConfig dbConfig;
	//public final StaffMapper staffMapper;
	
	public DrinkServices() {
		this.dbConfig=new DBConfig();
		//this.staffMapper=new StaffMapper();
	}

	public void createDrink(Drink drink) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps=this.dbConfig.getConnection()
					.prepareStatement("INSERT INTO drink (drink_name,drink_category,drink_price) VALUES (?,?,?)");
			ps.setString(1, drink.getDrink_name());
			ps.setString(2,drink.getDrink_category());
			
			ps.setDouble(3, drink.getDrink_price());
			//ps.setString(4, staff.getRole().toString());
			//ps.setString(5, staff.getUserName());
			//ps.setString(6, staff.getPassword());
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null, "Insert Success");
			ps.close();
		} catch (SQLException e) {
			// TODO: handle exception
			//JOptionPane.showMessageDialog(null, "Already Exists");
			e.printStackTrace();
		}		                                                                                                                                                                             
	}
	public Drink findDrinkById(String id) {
		Drink drink=new Drink();
		try(Statement st=this.dbConfig.getConnection().createStatement()){
			String query="SELECT * FROM drink WHERE drink_id= " +id + ";";
			ResultSet rs=st.executeQuery(query);
			while(rs.next()) {
				drink.setDrink_id(rs.getInt("drink_id"));
				drink.setDrink_name(rs.getString("drink_name"));
				drink.setDrink_category(rs.getString("drink_category"));
				drink.setDrink_price(rs.getDouble("drink_price"));
			}
			}
		catch(Exception e) {
			e.printStackTrace();
		}
		return drink;
	}
	@Override
	public void updateDrink(String id, Drink drink) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps=this.dbConfig.getConnection().prepareStatement("UPDATE drink SET drink_name=?,drink_category=?,drink_price=? WHERE drink_id=?");
			ps.setString(1, drink.getDrink_name());
			ps.setString(2, drink.getDrink_category());
			ps.setDouble(3, drink.getDrink_price());
			ps.setString(4, id);
			ps.executeUpdate();
			ps.close();
		}catch(Exception e) {
			e.printStackTrace(); 
		}
		
	}

	@Override
	public List<Drink> findAllDrink() {
		// TODO Auto-generated method stub
		List<Drink>drinkList=new ArrayList<>();
		try(Statement st=this.dbConfig.getConnection().createStatement()) {
				String query="SELECT * FROM drink";
				ResultSet rs=st.executeQuery(query);
				while(rs.next()) {
					Drink drink=new Drink();
					drink.setDrink_id(rs.getInt("drink_id"));
					drink.setDrink_name(rs.getString("drink_name"));
					drink.setDrink_category(rs.getString("drink_category"));
					drink.setDrink_price(rs.getDouble("drink_price"));
					//drinkMenu.add(this.drinkMapper.mapToDrink(drink,rs));
					drinkList.add(drink);
				}
		}catch(Exception e) {
				e.printStackTrace();
			}
		return drinkList;
	}

	@Override
	public Drink findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(String id,Drink drink) {
		try {
			PreparedStatement ps=this.dbConfig.getConnection().prepareStatement("DELETE from drink WHERE drink_id=?");
			//ps.setString(1, employee.getEmpName());
			//ps.setString(2, employee.getEmpAddress());
			//ps.setInt(3, employee.getEmpSalary());
			ps.setString(1, id);
			ps.executeUpdate();
			ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}
		
	}


	


