package com.resturant.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Booking {
	private String customerName;
	private int tableSize;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")

	private Date endTime;
	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")

	private Date startTime;
//
//    // Constructor, getters, and setters
//    public Booking(String customerName, int tableSize, Date dateTime) {
//        this.customerName = customerName;
//        this.tableSize = tableSize;
//        this.dateTime = dateTime;
//    }

	// Getters and setters
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getTableSize() {
		return tableSize;
	}

	public void setTableSize(int tableSize) {
		this.tableSize = tableSize;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	
}
