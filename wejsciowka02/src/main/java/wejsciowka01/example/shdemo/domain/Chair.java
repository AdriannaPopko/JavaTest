package wejsciowka01.example.shdemo.domain;

public class Chair {
	
	private ChairManager chm;
	
	public String chairName;
	public double chairPrice;
	public boolean chair_on_stock;
	
	public Chair(String chairName, double chairPrice)
	{
		this.chairName = chairName;
		this.chairPrice = chairPrice;
		this.chair_on_stock = true;
		
	}
	
	public String getName() {
		return chairName;
	}

	public void setName(String chairName) {
		this.chairName = chairName;
	}

	public double getPrice() {
		return chairPrice;
	}

	public void setPrice(double chairPrice) {
		this.chairPrice = chairPrice;
	}

}
