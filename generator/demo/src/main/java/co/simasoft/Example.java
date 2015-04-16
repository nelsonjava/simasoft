package co.simasoft;

import java.util.Date;
import java.io.Serializable;

// Example class to calculate ser
public class Example implements Serializable {

    private long id;
    private double price;
    private String description;
    private Date date;
    private int quantity;

    public long getId() {
    	return id;
    }

    public void setId(long id) {
    	this.id = id;
    }

    public double getPrice() {
    	return price;
    }

    public void setPrice(double price) {
    	this.price = price;
    }

    public String getDescription() {
    	return description;
    }

    public void setDescription(String description) {
    	this.description = description;
    }

    public Date getDate() {
    	return date;
    }

    public void setDate(Date date) {
    	this.date = date;
    }

    public int getQuantity() {
    	return quantity;
    }

    public void setQuantity(int quantity) {
    	this.quantity = quantity;
    }

}