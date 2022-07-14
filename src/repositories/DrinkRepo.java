package repositories;

import java.util.List;

import models.Drink;

public interface DrinkRepo {
	void createDrink(Drink drink);
	void updateDrink(String id,Drink drink);
	List<Drink> findAllDrink();
	Drink findById(String id);
	void delete(String id);
	void delete(String id, Drink drink);

}
