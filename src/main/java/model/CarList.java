package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author sylw - srglod
 * CIS175 - Spring 2023
 * Jan 27, 2023
 */

@Entity 
@Table(name="cars")

public class CarList {
	
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	
	@Column(name="make")
	private String make;
	
	@Column(name="model")
	private String model;
	
	@Column(name="liters")
	private double liters;
	
	@Column(name="cylinders")
	private int cylinders;
	
	@Column(name="turbo")
	private boolean turbo;
	
	public CarList(){
		super();
	}
	
	public CarList(String make, String model, double liters, int cylinders, boolean turbo ){
		super();
		this.make = make;
		this.model = model;
		this.liters = liters;
		this.cylinders = cylinders;
		this.turbo = turbo;

	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getLiters() {
		return liters;
	}
	public void setLiters(double liters) {
		this.liters = liters;
	}
	public int getCylinders() {
		return cylinders;
	}
	public void setCylinders(int cylinders) {
		this.cylinders = cylinders;
	}
	public boolean getTurbo() {
		return turbo;
	}
	public void setTurbo(boolean turbo) {
		this.turbo = turbo;
	}
	
	public String returnCarDetails( ) {
		return "Make: " + this.make + "\n" + "Model: "+ this. model + "\n" + "Liters: " + this.liters + "\n" + "Cylinders: " + this.cylinders +"\n" + "turbo: " + this.turbo;
	}
	

}
