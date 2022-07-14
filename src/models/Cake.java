package models;

import java.util.ArrayList;
import java.util.List;

public class Cake {
		private int cake_id;
		private String cake_name;
		private String cake_category;
		private double cake_price ;
		private int cake_quantity;
		//private DrinkRole role;
		public Cake() {
			
		}
		public Cake(int cake_id,String cake_name,String cake_category,double cake_price,int cake_quantity) {
			super();
			this.cake_id=cake_id;
			this.cake_name=cake_name;
			this.cake_category=cake_category;
			this.cake_price=cake_price;
			this.cake_quantity=cake_quantity;
			
			
			
			
			
			
		}
		public int getCake_id() {
			return cake_id;
		}

		public void setCake_id(int cake_id) {
			this.cake_id=cake_id;
		}
		public String getCake_name() {
			return cake_name;
		}

		public void setCake_name(String cake_name) {
			this.cake_name=cake_name;
		}
		public String getCake_category() {
			return cake_category;
		}

		public void setCake_category(String cake_category) {
			this.cake_category=cake_category;
		}
		
		public double getCake_price() {
			return cake_price;
		}

		public void setCake_price(double cake_price) {
			this.cake_price=cake_price;
		}
		public int getCake_quantity() {
			return cake_quantity;
		}

		public void setCake_Quantity(int cake_quantity) {
			this.cake_quantity=cake_quantity;
		}
		
		
		

}
