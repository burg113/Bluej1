package Classes;

import sum.kern.*;

/**
 * Ein Figurstift ist ein Stift, der auch Quadrate zeichnen kann.
 *
 * @author Lenn
 * @version 21.4.2021
 */

public class Figurstift extends Stift
{
    // Objekte

    // Attribute

    // Konstruktor
    /**
     * ein Figurstift wird erzeugt
     */
    public Figurstift()
    {
        super();
    }

    // Dienste
    /**
     * unabhaengig vom Zustand des Stifts wird ein Quadrat gezeichnet.
     * @param pGroesse die Seitenlaenge des Quadrats
     */
    public void zeichneQuadrat(double pGroesse) {
        this.zeichneRechteck(pGroesse, pGroesse);
    }

    /**
     * es wird ein Ring gezeichnet
     * @param innerRadius der Innenradius des Rings
     * @param outerRadius der Außenradius des Rings
     */

    public void zeichneRing(double innerRadius, double outerRadius){
        zeichneKreis(innerRadius);
        zeichneKreis(outerRadius);
    }


}
