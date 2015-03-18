import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Tworzy graficzny interfejs gry i obs³uguje zdarzenia klikniêc przycisków
 * 
 * @author Piotr Wrona
 * @version 1.2
 *
 */
public class MainGUI extends JFrame implements ActionListener{


	JPanel panel;
	static JButton dodajSlowa, dodajTekst, wylicz, autor;

	/**
	 * Konstruuje ekran gry
	 */	
	public MainGUI() {     
		super("Zliczacz slow");		
		setSize(300,300);
		setLocation(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		oknoGlowne();  
    }
		
	/**
	 * Tworzy elementy na ekranie
	 */	
	public void oknoGlowne() {
	
		panel = new JPanel(null);
		panel.setBackground(Color.DARK_GRAY);
		
		dodajSlowa = new JButton("dodaj slowa");
		dodajSlowa.addActionListener(this);
		dodajSlowa.setBounds(50,50,200,20);
		panel.add(dodajSlowa);

		dodajTekst = new JButton("dodaj tekst");
		dodajTekst.addActionListener(this);
		dodajTekst.setBounds(50,80,200,20);
		panel.add(dodajTekst);
		
		wylicz = new JButton("oblicz slowa");
		wylicz.addActionListener(this);
		wylicz.setBounds(50,110,200,20);
		panel.add(wylicz);
			
		add(panel);
        setResizable(false);
        setVisible(true);
			
	}
	
	
	
	/**
	 * Obs³uga przycisków
	 */
	public void actionPerformed(ActionEvent e){
		Object zdarzenie = e.getSource();
		
		if(zdarzenie==dodajSlowa){
			ZliczaczSlow.dodajSlowa();
			//System.out.println("..dodano pary slow");
		}
		
		if(zdarzenie==dodajTekst){
			ZliczaczSlow.dodajTekst();
			//ZliczaczSlow.wypiszTekst();	
			//System.out.println("..dodano tekst");
		}
		
		if(zdarzenie==wylicz){
			try {
				ZliczaczSlow.liczSlowa();
			} catch (IOException e1) {
				System.out.println("Err03: nie zaladowano plikow");
				e1.printStackTrace();
			}
			//System.out.println("..wyliczam slowa pomiedzy");
		}			
	}

	
	public static void main(String[] args) {
		new MainGUI();
	}

}
