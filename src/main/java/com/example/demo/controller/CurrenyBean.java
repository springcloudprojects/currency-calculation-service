package com.example.demo.controller;

public class CurrenyBean {

	private Integer id;
	private String from;
	private String to;
	private int conversionMultiply;
	private int quantity;
	private int calculatedAmount;
	private int port;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public int getConversionMultiply() {
		return conversionMultiply;
	}
	public void setConversionMultiply(int conversionMultiply) {
		this.conversionMultiply = conversionMultiply;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getCalculatedAmount() {
		return calculatedAmount;
	}
	public void setCalculatedAmount(int calculatedAmount) {
		this.calculatedAmount = calculatedAmount;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	
}