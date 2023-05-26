package com.ict.test.vending_machine;

import java.time.LocalDate;

//GTIN (Global Trade Item Number) 검색 시 정보
public class DataForGTIN {
	private String GTIN; // GTIN //EAN-13 바코드
	private String ProductName; // 상품 이름
	private LocalDate dateOfFinalModification; // 최종 수정일
	private String manufacturer; // 제조사,생산자
	private LocalDate releaseDate; // 출시일
	private String merchandiser; // 판매자
	private String companyAddress; // 회사주소
	private String companyMainNumber; // 대표전화
	private String companyWebsiteAddress; // 홈페이지/관련사이트
	private String productDescription; // 상품설명

	// 포장정보 및 규격정보
	private double width; // 가로 //cm
	private double length; // 세로 //cm
	private double height; // 높이 //cm
	private double volume; // 용량 //ml
	private double netWeigth; // 순중량 g
	private double grossWeight; // 총중량 g

	public DataForGTIN() {
		// TODO Auto-generated constructor stub
	}

	public DataForGTIN(String gTIN, String productName, LocalDate dateOfFinalModification, String manufacturer,
			LocalDate releaseDate, String merchandiser, String companyAddress, String companyMainNumber,
			String companyWebsiteAddress, String productDescription, double width, double length, double height,
			double volume, double netWeigth, double grossWeight) {
		super();
		GTIN = gTIN;
		ProductName = productName;
		this.dateOfFinalModification = dateOfFinalModification;
		this.manufacturer = manufacturer;
		this.releaseDate = releaseDate;
		this.merchandiser = merchandiser;
		this.companyAddress = companyAddress;
		this.companyMainNumber = companyMainNumber;
		this.companyWebsiteAddress = companyWebsiteAddress;
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

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public LocalDate getDateOfFinalModification() {
		return dateOfFinalModification;
	}

	public void setDateOfFinalModification(LocalDate dateOfFinalModification) {
		this.dateOfFinalModification = dateOfFinalModification;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getMerchandiser() {
		return merchandiser;
	}

	public void setMerchandiser(String merchandiser) {
		this.merchandiser = merchandiser;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyMainNumber() {
		return companyMainNumber;
	}

	public void setCompanyMainNumber(String companyMainNumber) {
		this.companyMainNumber = companyMainNumber;
	}

	public String getCompanyWebsiteAddress() {
		return companyWebsiteAddress;
	}

	public void setCompanyWebsiteAddress(String companyWebsiteAddress) {
		this.companyWebsiteAddress = companyWebsiteAddress;
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
