
package ohtu;

import javax.swing.JTextField;

public class Erotus extends KomentoLuokka {

    public Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        super(sovellus, tuloskentta, syotekentta);
    }
    
    @Override
    public void suorita() {
        int syote = haeSyote();
        laitaSyoteMuistiin(syote);
        sovellus.miinus(syote);
        paivitaTulos(sovellus.tulos());
    }

    @Override
    public void peru() {
        sovellus.plus(edellinenSyote);
        paivitaTulos(sovellus.tulos());
    }
    
}
