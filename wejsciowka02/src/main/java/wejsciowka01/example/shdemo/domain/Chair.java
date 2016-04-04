package wejsciowka01.example.shdemo.domain;

public class Chair {
	
	public String chairName;
	public float chairPrice;
	public boolean chair_on_stock;
	
	public Chair(String chairName, float chairPrice)
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

	public float getPrice() {
		return chairPrice;
	}

	public void setPrice(float chairPrice) {
		this.chairPrice = chairPrice;
	}

	

}
