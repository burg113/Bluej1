package Classes;

import Classes.Figurstift;
import sum.kern.*;


public class FigurstiftProgramm {
    // Objektdeklarationen
    Figurstift meinStift;
    Bildschirm derBildschirm;

    public FigurstiftProgramm(int screenWidth, int screenHeight) {
        derBildschirm = new Bildschirm(screenWidth,screenHeight);
        meinStift = new Figurstift();

        fuehreAus();
    }

    // Dienste
    public void fuehreAus() {
        /*
        meinStift.bewegeBis(100, 100);
        meinStift.schreibeText("Hallo Welt");
        meinStift.bewegeBis(200, 100);
        meinStift.zeichneQuadrat(50);
        meinStift.bewegeBis(50, 200);
        meinStift.zeichneQuadrat(70);
        */

        meinStift.bewegeBis(100, 100);
        meinStift.zeichneRing(50,80);


        // Aufraeumen
        meinStift.gibFrei();
        derBildschirm.gibFrei();
    }
}