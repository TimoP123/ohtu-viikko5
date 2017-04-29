
package ohtu;

import javax.swing.JTextField;

public class Nollaa extends KomentoLuokka {

    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        super(sovellus, tuloskentta, syotekentta);
    }
    
    @Override
    public void suorita() {        
        laitaSyoteMuistiin(sovellus.tulos());
        sovellus.nollaa();
        paivitaTulos(sovellus.tulos());
    }
    
    @Override
    public void peru() {
        paivitaTulos(edellinenSyote);
    }
}
