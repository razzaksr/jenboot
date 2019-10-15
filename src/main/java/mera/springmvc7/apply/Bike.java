package mera.springmvc7.apply;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name="bikes")
public class Bike 
{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bid;
	private String model;
	private int price, milage;
	
	@Override
	public String toString() {
		return "Bike [bid=" + bid + ", model=" + model + ", price=" + price + ", milage=" + milage + "]";
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getMilage() {
		return milage;
	}
	public void setMilage(int milage) {
		this.milage = milage;
	}
}
