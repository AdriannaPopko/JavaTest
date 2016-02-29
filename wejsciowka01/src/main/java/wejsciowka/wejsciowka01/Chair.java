package wejsciowka.wejsciowka01;

public class Chair{

	private String typ;
	private String kolor;
	private String producent;

	public Chair(){
		}
	
	
    public Chair( String typ, String kolor, String producent){
		this.typ = typ;
		this.kolor = kolor;
		this.producent = producent;
    }
    
    	public String getTyp() {
    		return typ;
    	}

    	public void setTyp(String typ) {
    		this.typ = typ;
    }
    	public String getKolor() {
    		return kolor;
    	}

    	public void setKolor(String kolor) {
    		this.kolor = kolor;
    }
    	public String getProducent() {
    		return producent;
    	}

    	public void setProducent(String producent) {
    		this.producent = producent;
    }
}
