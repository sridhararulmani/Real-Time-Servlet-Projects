package com.jsp.carProject;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {
	@Id
	private int carId;
	private String carModel;
	private String carBrand;
	private int carPirce;

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public int getCarPirce() {
		return carPirce;
	}

	public void setCarPirce(int carPirce) {
		this.carPirce = carPirce;
	}
}
