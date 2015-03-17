package com.company.css.data;

public abstract class Accessory {
	
	private String accessoryName;
	private String accessoryPriceinDollar;
	private String accessoryPriceinEuro;
	private String accessoryManufacturer;
	private String accessoryStock;
	
	protected Accessory(){
		setAccessoryManufacturer(null);
		setAccessoryName(null);
		setAccessoryPriceinDollar(null);
		setAccessoryPriceinEuro(null);
		setAccessoryStock(null);
	}

    public void setAccessoryName(String accessoryName){
    	this.accessoryName=accessoryName;
    }
    public void setAccessoryPriceinDollar(String accessoryPrice){
    	this.accessoryPriceinDollar=accessoryPrice;
    }
    public void setAccessoryPriceinEuro(String accessoryPrice){
    	this.accessoryPriceinEuro=accessoryPrice;
    }
    public void setAccessoryManufacturer(String accessoryManufacturer){
    	this.accessoryManufacturer=accessoryManufacturer;
    }
    public void setAccessoryStock(String accessoryStock){
    	this.accessoryStock= accessoryStock;
    }
    public String getAccessoryName(){
    	return accessoryName;
    }
    public String getAccessoryPriceinDollar(){
    	return accessoryPriceinDollar;
    }
    public String getAccessoryPriceinEuro(){
    	return accessoryPriceinEuro;
    }
    public String getAccessoryManufacturer(){
    	return accessoryManufacturer;
    }
    public String getAccessoryStock(){
    	return accessoryStock;
    }

}
