package zad3.zad3;


public class LiczbaRzymska {

	private Integer liczba;

	public Integer getLiczba() {
		return liczba;
	}

	public void setLiczba(Integer liczba) {
		this.liczba = liczba;
	}

	public String toString() {
		if (liczba<0)
		{
			return null;
		}
		else{
		String rzymska = "";
		int liczby[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String rzym[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		int n=liczba;
		for(int i = 0; liczba > 0; i++)
		{
			n = liczba/liczby[i];
			if ((liczba > 0) && (liczba <= 3999)) {
				for (int j = 1; j <= n; j++) {
					rzymska = rzymska + rzym[i];
				}
			}
			liczba = liczba % liczby[i];
		}
		return rzymska.toString();
		}
	}
	}