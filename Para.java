import java.util.ArrayList;

/**
 * Klasa tworzy pary s³ów, które nale¿y sprawdziæ
 * 
 * @author Piotr Wrona
 * @version 1.2
 *
 */

public class Para {

	
	String pierwszeSlowo;
	String drugieSlowo;
	
	/**
	 * Konstruktot tworzy obiekt Para - pary s³ów do sprawdzenia
	 * @param pierwszeSlowo po tym s³owie nastepuje zliczanie s³ów
	 * @param drugieSlowo do tego s³owa zliczane s¹ s³owa
	 */
	public Para(String pierwszeSlowo, String drugieSlowo) {
		this.pierwszeSlowo = pierwszeSlowo.toLowerCase();
		this.drugieSlowo = drugieSlowo.toLowerCase();
		dodajPara(this);
	}
		
	public static ArrayList<Para> listaPar = new ArrayList<Para>();
	/**
	 * Tworzy listê par
	 * @param para para s³ów do listy
	 */
	public void dodajPara(Para para) {	
		//System.out.println("dodano: " + para);
		listaPar.add(para);
	}
		
	/**
	 * U¿ywane przy wypisywaniu wyniku
	 */
	public String toString(){
		return (pierwszeSlowo + " " + drugieSlowo);
	}
	
}
