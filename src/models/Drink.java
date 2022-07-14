package models;
import java.util.ArrayList;
import java.util.List;

public class Drink {
		private int drink_id;
		private String drink_category;
		private String drink_name;
		private double drink_price;
		//private DrinkRole role;
		public Drink() {
			
		}
		public Drink(int drink_id,String drink_name,String drink_category,double drink_price) {
			super();
			this.drink_id=drink_id;
			this.drink_name=drink_name;
			this.drink_category=drink_category;
			
			this.drink_price=drink_price;
		}
		public int getDrink_id() {
			return drink_id;
		}

		public void setDrink_id(int drink_id) {
			this.drink_id=drink_id;
		}
		public String getDrink_name() {
			return drink_name;
		}

		public void setDrink_name(String drink_name) {
			this.drink_name=drink_name;
		}
		public String getDrink_category() {
			return drink_category;
		}

		public void setDrink_category(String drink_category) {
			this.drink_category=drink_category;
		}
		
		public double getDrink_price() {
			return drink_price;
		}

		public void setDrink_price(double drink_price) {
			this.drink_price=drink_price;
		}
		
		
		
		

}
