package com.ict.test.vending_machine;

import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Iterator;

public class ListOfDrink {
	HashMap<String, DataForDrink> drinkList;

	public ListOfDrink() {
		// TODO Auto-generated constructor stub
	}

	public ListOfDrink(ListOfProduct target) {
		drinkList = new HashMap<>();
		
		for (String k : target.getProductList().keySet()) {
			DataForDrink drink = new DataForDrink(target.getProductList().get(k));
			drinkList.put(k, drink);
		}
	}

	public HashMap<String, DataForDrink> getDrinkList() {
		return drinkList;
	}

	public void setDrinkList(HashMap<String, DataForDrink> drinkList) {
		this.drinkList = drinkList;
	}
}
