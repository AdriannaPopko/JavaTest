package wejsciowka.wejsciowka01;

public class Chair
{
    private String model;
    private int ilosc;
    private boolean dostepnosc = false;
	
	public Chair(String name, int number) {
		model = name;
		ilosc = number;
		dostepnosc = true;
	}
}