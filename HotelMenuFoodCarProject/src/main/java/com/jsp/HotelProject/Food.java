package com.jsp.HotelProject;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Food {
	@Id
	private int foodCode;
	private String foodName;
	private int foodPrice;

	public int getFoodCode() {
		return foodCode;
	}

	public void setFoodCode(int foodCode) {
		this.foodCode = foodCode;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}

}
