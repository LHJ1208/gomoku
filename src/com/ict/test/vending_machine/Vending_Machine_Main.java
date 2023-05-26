package com.ict.test.vending_machine;

public class Vending_Machine_Main {
	public static void main(String[] args) {
		ListOfDrink drinkList = new ListOfDrink(new ListOfProduct());

		for(String k : drinkList.getDrinkList().keySet()) {
			System.out.println(drinkList.getDrinkList().get(k).getName());
		}
	}
}
