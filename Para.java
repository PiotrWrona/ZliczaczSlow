import java.util.ArrayList;

/**
 * Klasa tworzy pary s��w, kt�re nale�y sprawdzi�
 * 
 * @author Piotr Wrona
 * @version 1.2
 *
 */

public class Para {

	
	String pierwszeSlowo;
	String drugieSlowo;
	
	/**
	 * Konstruktot tworzy obiekt Para - pary s��w do sprawdzenia
	 * @param pierwszeSlowo po tym s�owie nastepuje zliczanie s��w
	 * @param drugieSlowo do tego s�owa zliczane s� s�owa
	 */
	public Para(String pierwszeSlowo, String drugieSlowo) {
		this.pierwszeSlowo = pierwszeSlowo.toLowerCase();
		this.drugieSlowo = drugieSlowo.toLowerCase();
		dodajPara(this);
	}
		
	public static ArrayList<Para> listaPar = new ArrayList<Para>();
	/**
	 * Tworzy list� par
	 * @param para para s��w do listy
	 */
	public void dodajPara(Para para) {	
		//System.out.println("dodano: " + para);
		listaPar.add(para);
	}
		
	/**
	 * U�ywane przy wypisywaniu wyniku
	 */
	public String toString(){
		return (pierwszeSlowo + " " + drugieSlowo);
	}
	
}
