
package ohtu;

import javax.swing.JTextField;

public class Summa extends KomentoLuokka {

    public Summa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        super(sovellus, tuloskentta, syotekentta);
    }
    
    @Override
    public void suorita() {
        int syote = haeSyote();
        laitaSyoteMuistiin(syote);
        sovellus.plus(syote);
        paivitaTulos(sovellus.tulos());
    }

    @Override
    public void peru() {
        sovellus.miinus(edellinenSyote);
        paivitaTulos(sovellus.tulos());
    }
    
}
