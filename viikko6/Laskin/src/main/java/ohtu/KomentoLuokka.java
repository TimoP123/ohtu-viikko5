
package ohtu;

import javax.swing.JTextField;

public class KomentoLuokka implements Komento {
    
    Sovelluslogiikka sovellus;
    JTextField tuloskentta;
    JTextField syotekentta;
    int edellinenSyote;
    
    public KomentoLuokka(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }
    
    public int haeSyote() {
        try {
            int syote = Integer.parseInt(syotekentta.getText());
            return syote;
        } catch (Exception e) {
        }

        return 0;
    }
    
    public void paivitaTulos(int tulos) {
        this.tuloskentta.setText("" + tulos);
        this.syotekentta.setText("");
    }
    
    public void laitaSyoteMuistiin(int syote) {
        this.edellinenSyote = syote;
    }

    @Override
    public void suorita() {
        
    }

    @Override
    public void peru() {
        
    }
}
