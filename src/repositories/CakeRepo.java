package repositories;

import java.util.List;

import models.Cake;

public interface CakeRepo {
	void createCake(Cake cake);
	void updateCake(String id,Cake cake);
	List<Cake> findAllCake();
	Cake findById(String id);
	void delete(String id);
	void delete(String id,Cake cake);
	

}
