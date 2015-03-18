import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


/**
 * Klasa odpowiedzialna za zliczanie liczby s³ów znajduj¹cych siê pomiêdzy danymi parami s³ów
 * 
 * @author Piotr Wrona
 * @version 1.2
 *
 */

public class ZliczaczSlow {

	
	static double liczbaSlowTekstu = 0;
	
	/**
	 * Pobiera pary s³ów z pliku o okreœlonej lokazlizacji
	 */
	public static void dodajSlowa() {
		
		JFileChooser fc = new JFileChooser(new File("."));
		fc.showDialog(null, "dodaj pary slow");
		String miejscePliku = fc.getSelectedFile().getAbsolutePath();
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(miejscePliku));
		} catch (FileNotFoundException e) {
			System.out.println("Err01a: nie zaladowano pliku par slow");
			e.printStackTrace();
		}
		try {
			while(in.ready()){
				String tempString = in.readLine();
				String[] pocietyTempString = tempString.split(" ");
				Para p = new Para(pocietyTempString[0], pocietyTempString[1]);
			}	
			JOptionPane.showMessageDialog(null, "dodano pary wyrazow \n", "Pary", JOptionPane.INFORMATION_MESSAGE);
		} catch (IOException e) {
			System.out.println("Err02a: bledna baza");
			e.printStackTrace();
		}
	}

	

	static String[] pelnyTekst;
	/**
	 * Pobiera tekst do sprawdzenia z pliku o okreœlonej lokazlizacji
	 */
	public static void dodajTekst() {
		
		JFileChooser fc = new JFileChooser(new File("."));
		fc.showDialog(null, "dodaj tekst");
		String miejscePliku = fc.getSelectedFile().getAbsolutePath();
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(miejscePliku));
		} catch (FileNotFoundException e) {
			System.out.println("Err01b: nie zaladowano pliku par slow");
			e.printStackTrace();
		}
		try {
			String tempString = "";
			while(in.ready()){
				tempString += in.readLine() + " ";
			}	
			pelnyTekst = tempString.toLowerCase().split(" ");
			if (pelnyTekst.length != 0){
				JOptionPane.showMessageDialog(null, "dodano tekst \n", "Tekst", JOptionPane.INFORMATION_MESSAGE);
			}
			
		} catch (IOException e) {
			System.out.println("Err02b: bledna baza");
			e.printStackTrace();
		}
		 
	}
	
	
	/*
	public static void wypiszTekst() {
		liczbaSlowTekstu = pelnyTekst.length;
		System.out.println("liczba slow w z pliku tekstowego " + liczbaSlowTekstu);
		for(int i=0; i<liczbaSlowTekstu; i++){
			System.out.print(pelnyTekst[i] + " ");
		}
	}*/

	
	/**
	 * Liczy s³owa znajduj¹ce siê pomiêdzy dana par¹ s³ów
	 * @throws IOException
	 */
	public static void liczSlowa() throws IOException{

		liczbaSlowTekstu = pelnyTekst.length;
		
		File wynik = new File("." + "//wynik.txt");	 
		if (!wynik.exists()) {
			wynik.createNewFile();
		}

		FileWriter fw = new FileWriter(wynik.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);			
		
		double liczbaPar = Para.listaPar.size();	
		String pierwszeSlowo;
		String drugieSlowo;
		
		//System.out.println("size: " + Para.listaPar.size());
				
		for (int i=0; i<liczbaPar; i++){
			pierwszeSlowo = Para.listaPar.get(i).pierwszeSlowo;
			drugieSlowo = Para.listaPar.get(i).drugieSlowo;
			//System.out.println("_dla > " + i + "\t" + pierwszeSlowo + " " + drugieSlowo);
			bw.write(pierwszeSlowo + " " + drugieSlowo + " ");
			
			int roznica = 0;
			int posrednia = 0;
			
			for(int j=0; j<liczbaSlowTekstu; j++){
				posrednia = j+1;
				//System.out.println("-- " + liczbaSlowTekstu + "_ " + posrednia);
				if ( (pelnyTekst[j]).startsWith(pierwszeSlowo) || (  ( (pelnyTekst[j]).length()>1) && ((pelnyTekst[j]).substring(1)).startsWith(pierwszeSlowo))){
					//System.out.println(">> " + pierwszeSlowo + "<< >> " + pelnyTekst[j] + " <<");
					//System.out.println("-1- " + pierwszeSlowo + " :na: " + j);
					int korekta = 0;
					for (int k=posrednia; k<liczbaSlowTekstu; k++){
						//System.out.println("=============================>" + (pelnyTekst[k]) + "<==");
						if (!((pelnyTekst[k]).length()>0)){
							korekta++;
							//System.out.println("++++++++++++>" + korekta + "<+++++++");
						}
						//System.out.println("-*- posrednia:  " + k);
						//System.out.println("> > " + drugieSlowo + "< <  > > " + pelnyTekst[k] + " < <");
						if ( (pelnyTekst[k]).startsWith(drugieSlowo) || (  ( (pelnyTekst[k]).length()>1) && ((pelnyTekst[k]).substring(1)).startsWith(drugieSlowo))){
							//System.out.println("-2- " + drugieSlowo + " na " + k);
							roznica = (k-j)-1-korekta;
							bw.write(Integer.toString(roznica) + " ");
							break;
						}
					}
				}
			}
			
			bw.newLine();
		}
				
		bw.close();
		JOptionPane.showMessageDialog(null, "wyniki.txt w katalogu programu \n", "Obliczono", JOptionPane.INFORMATION_MESSAGE);
		//System.out.println("..obliczono");	
	}


}
