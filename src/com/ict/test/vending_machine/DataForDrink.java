package com.ict.test.vending_machine;

public class DataForDrink {
	private String GTIN; // GTIN //EAN-13 바코드
	private String Name; // 상품 이름
	private String manufacturer; // 제조사,생산자
	private String merchandiser; // 판매자
	private String productDescription; // 상품설명

	// 포장정보 및 규격정보
	private double width; // 가로 //cm
	private double length; // 세로 //cm
	private double height; // 높이 //cm
	private double volume; // 용량 //ml
	private double netWeigth; // 순중량 g
	private double grossWeight; // 총중량 g

	public DataForDrink() {
		// TODO Auto-generated constructor stub
	}

	public DataForDrink(DataForGTIN source) {
		super();
		GTIN = source.getGTIN();
		Name = source.getProductName();
		this.manufacturer = source.getManufacturer();
		this.merchandiser = source.getMerchandiser();
		this.productDescription = source.getProductDescription();
		this.width = source.getWidth();
		this.length = source.getLength();
		this.height = source.getHeight();
		this.volume = source.getVolume();
		this.netWeigth = source.getNetWeigth();
		this.grossWeight = source.getGrossWeight();
	}

	public DataForDrink(String gTIN, String name, String manufacturer, String merchandiser, String productDescription,
			double width, double length, double height, double volume, double netWeigth, double grossWeight) {
		super();
		GTIN = gTIN;
		Name = name;
		this.manufacturer = manufacturer;
		this.merchandiser = merchandiser;
		this.productDescription = productDescription;
		this.width = width;
		this.length = length;
		this.height = height;
		this.volume = volume;
		this.netWeigth = netWeigth;
		this.grossWeight = grossWeight;
	}

	public String getGTIN() {
		return GTIN;
	}

	public void setGTIN(String gTIN) {
		GTIN = gTIN;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getMerchandiser() {
		return merchandiser;
	}

	public void setMerchandiser(String merchandiser) {
		this.merchandiser = merchandiser;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getNetWeigth() {
		return netWeigth;
	}

	public void setNetWeigth(double netWeigth) {
		this.netWeigth = netWeigth;
	}

	public double getGrossWeight() {
		return grossWeight;
	}

	public void setGrossWeight(double grossWeight) {
		this.grossWeight = grossWeight;
	}
}
