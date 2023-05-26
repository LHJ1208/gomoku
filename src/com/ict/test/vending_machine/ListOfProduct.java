package com.ict.test.vending_machine;

import java.time.LocalDate;
import java.util.HashMap;

public class ListOfProduct {
	private HashMap<String, DataForGTIN> productList;

	public ListOfProduct() {
		// TODO Auto-generated constructor stub
		productList = new HashMap<>();

		DataForGTIN pepsi01 = new DataForGTIN();
		{
			pepsi01.setGTIN("8801056175900");
			pepsi01.setProductName("롯데칠성음료(주) 펩시제로 슈거 라임향 355ml");
			LocalDate date01 = LocalDate.of(2021, 06, 07);
			pepsi01.setDateOfFinalModification(date01);
			pepsi01.setManufacturer("롯데칠설음료(주)");
			pepsi01.setReleaseDate(null);
			pepsi01.setMerchandiser("롯데칠성음료(주)");
			pepsi01.setCompanyAddress("서울특별시 서초구 서초대로70길 15 (서초동)");
			pepsi01.setCompanyMainNumber("02-3479-9114");
			pepsi01.setCompanyWebsiteAddress("http://www.lottechilsung.co.kr");

			pepsi01.setWidth(6.5);
			pepsi01.setLength(6.5);
			pepsi01.setHeight(12.5);
			pepsi01.setVolume(355);
			pepsi01.setNetWeigth(-1);
			pepsi01.setGrossWeight(360);
		}
		productList.put(pepsi01.getGTIN(), pepsi01);
	}

	public HashMap<String, DataForGTIN> getProductList() {
		return productList;
	}

	public void setProductList(HashMap<String, DataForGTIN> productList) {
		this.productList = productList;
	}
}
