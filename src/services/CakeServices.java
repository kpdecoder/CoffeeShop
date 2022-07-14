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
 import models.Cake;
import models.Drink;
import repositories.CakeRepo;

public class CakeServices implements CakeRepo{
	public final DBConfig dbConfig;
		public CakeServices() {
	
				this.dbConfig=new DBConfig();
}
		public void createCake(Cake cake) {
			// TODO Auto-generated method stub
			try {
				PreparedStatement ps=this.dbConfig.getConnection()
						.prepareStatement("INSERT INTO cake (cake_name,cake_category,cake_price,cake_quantity) VALUES (?,?,?,?)");
				ps.setString(1, cake.getCake_name());
				ps.setString(2,cake.getCake_category());
				
				ps.setDouble(3, cake.getCake_price());
				ps.setDouble(4, cake.getCake_quantity());
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
		
		public void updateCake(String id, Cake cake) {
			// TODO Auto-generated method stub
			try {
				PreparedStatement ps=this.dbConfig.getConnection().prepareStatement("UPDATE cake SET cake_name=?,cake_category=?,cake_price=?, cake_quantity=? WHERE cake_id=?");
				ps.setString(1, cake.getCake_name());
				ps.setString(2, cake.getCake_category());
				ps.setDouble(3, cake.getCake_price());
				ps.setDouble(4, cake.getCake_quantity());
				ps.setString(5, id);
				ps.executeUpdate();
				ps.close();
			}catch(Exception e) {
				e.printStackTrace(); 
			}
			
		}
			
			
		
		
		public Cake findCakeById(String id) {
			Cake cake=new Cake();
			try(Statement st=this.dbConfig.getConnection().createStatement()){
				String query="SELECT * FROM cake WHERE cake_id= " +id + ";";
				ResultSet rs=st.executeQuery(query);
				while(rs.next()) {
				cake.setCake_id(rs.getInt("cake_id"));
					cake.setCake_name(rs.getString("cake_name"));
					cake.setCake_category(rs.getString("cake_category"));
					cake.setCake_price(rs.getDouble("cake_price"));
					cake.setCake_Quantity(rs.getInt("cake_quantity"));
				}
				}
			catch(Exception e) {
				e.printStackTrace();
			}
			return cake;
		}
		public List<Cake> findAllCake() {
			// TODO Auto-generated method stub
			List<Cake>cakeList=new ArrayList<>();
			try(Statement st=this.dbConfig.getConnection().createStatement()) {
					String query="SELECT * FROM cake";
					ResultSet rs=st.executeQuery(query);
					while(rs.next()) {
						Cake cake=new Cake();
						cake.setCake_id(rs.getInt("cake_id"));
						cake.setCake_name(rs.getString("cake_name"));
						cake.setCake_category(rs.getString("cake_category"));
						cake.setCake_price(rs.getDouble("cake_price"));
						cake.setCake_Quantity(rs.getInt("cake_quantity"));
						//drinkMenu.add(this.drinkMapper.mapToDrink(drink,rs));
						cakeList.add(cake);
					}
			}catch(Exception e) {
					e.printStackTrace();
				}
			return cakeList;
		}
		public Cake findById(String id) {
			// TODO Auto-generated method stub
			return null;
		}
		
		public void delete(String id) {
			// TODO Auto-generated method stub
			
		
		}
		public void delete(String id, Cake cake) {
			// TODO Auto-generated method stub
			try {
				PreparedStatement ps=this.dbConfig.getConnection().prepareStatement("DELETE from cake WHERE cake_id=?");
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
	
}
	