import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Klasse für Spinnen-Welt-Objekte.
 */
public class SpinnenWelt extends World
{

    /**
     * Erzeugt eine Welt mit 20x15 Feldern der Größe 40.
     * Die Welt ist mit gelben Bodenplatten belegt und von Hindernissen umrahmt.
     */
    public SpinnenWelt() {
        super(20, 15, 40);
        setBackground("images/bodenplatte.png");
        randZiehen();
        prepare();
    }

    /**
     * Erzeugt eine Welt mit breite x hoehe Feldern der Größe 40.
     * Die Welt ist mit gelben Bodenplatten belegt und von Hindernissen umrahmt.
     * @param breite die Breite der Welt
     * @param hoehe  die Höhe der Welt
     */
    public SpinnenWelt(int breite, int hoehe) {
        super(breite, hoehe, 40);
        setBackground("images/bodenplatte.png");
        randZiehen();
    }

    /**
     * Setzt ein Hindernis auf (x,y) sofern der Platz innerhalb der Welt liegt.
     * @param x die Spalte
     * @param y die Zeile
     */
    public void hindernisSetzen(int x, int y) {
        if(!(x < 1 || x > getWidth() -2 || y < 2 || y > getHeight() -2)) {
            addObject(new Hindernis(),x,y);
        }
    }

    /**
     * Entfernt ein Hindernis von (x,y) sofern der Platz innerhalb der Welt liegt und dort eins liegt.
     * @param x die Spalte
     * @param y die Zeile
     */
    public void hindernisEntfernen(int x, int y) {
        if(!(x < 1 || x > getWidth() -2 || y < 2 || y > getHeight() -2)) {
            List hindernisse = getObjectsAt(x,y,Hindernis.class);
            if(hindernisse.size() > 0) {
                removeObject((Actor)hindernisse.get(0));
            }
        }
    }

    /**
     * Setzt eine Klatsche auf (x,y) sofern der Platz innerhalb der Welt liegt.
     * @param x die Spalte
     * @param y die Zeile
     */
    public void klatscheSetzen(int x, int y) {
        if(!(x < 1 || x > getWidth() -2 || y < 2 || y > getHeight() -2)) {
            addObject(new Klatsche(),x,y);
        }
    }

    /**
     * Entfernt eine Klatsche von (x,y) sofern der Platz innerhalb der Welt liegt und dort eine liegt.
     * @param x die Spalte
     * @param y die Zeile
     */
    public void klatscheEntfernen(int x, int y) {
        if(!(x < 1 || x > getWidth() -2 || y < 2 || y > getHeight() -2)) {
            List klatschen = getObjectsAt(x,y,Klatsche.class);
            if(klatschen.size() > 0) {
                removeObject((Actor)klatschen.get(0));
            }
        }
    }

    /**
     * Setzt eine Fliege auf (x,y) sofern der Platz innerhalb der Welt liegt.
     * @param x die Spalte
     * @param y die Zeile
     */
    public void fliegeSetzen(int x, int y) {
        if(!(x < 1 || x > getWidth() -2 || y < 2 || y > getHeight() -2)) {
            addObject(new Fliege(),x,y);
        }
    }

    /**
     * Entfernt eine Fliege von (x,y) sofern der Platz innerhalb der Welt liegt und dort eine liegt.
     * @param x die Spalte
     * @param y die Zeile
     */
    public void fliegeEntfernen(int x, int y) {
        if(!(x < 1 || x > getWidth() -2 || y < 2 || y > getHeight() -2)) {
            List fliegen = getObjectsAt(x,y,Fliege.class);
            if(fliegen.size() > 0) {
                removeObject((Actor)fliegen.get(0));
            }
        }
    }

    /**
     * Setzt eine Spinne ohne Fliegen auf (x,y) sofern der Platz innerhalb der Welt liegt.
     * @param x die Spalte
     * @param y die Zeile
     */
    public void spinneSetzen(int x, int y) {
        if(!(x < 1 || x > getWidth() -2 || y < 2 || y > getHeight() -2)) {
            addObject(new Spinne(),x,y);
        }
    }

    /**
     * Setzt eine Spinne mit einer gegebenen Anzahl Fliegen auf (x,y) sofern der Platz innerhalb der Welt liegt.
     * @param x die Spalte
     * @param y die Zeile
     */
    public void spinneSetzen(int x, int y, int fliegen) {
        if(!(x < 1 || x > getWidth() -2 || y < 2 || y > getHeight() -2)) {
            addObject(new Spinne(fliegen),x,y);
        }
    }

    /**
     * Entfernt eine Spinne von (x,y) sofern der Platz innerhalb der Welt liegt und dort eine liegt.
     * @param x die Spalte
     * @param y die Zeile
     */
    public void spinneEntfernen(int x, int y) {
        if(!(x < 1 || x > getWidth() -2 || y < 2 || y > getHeight() -2)) {
            List spinnen = getObjectsAt(x,y,Spinne.class);
            if(spinnen.size() > 0) {
                removeObject((Actor)spinnen.get(0));
            }
        }
    }

    private void randZiehen() {
        for(int i=0;i<getWidth();i++) {
            addObject(new Hindernis(),i,0);
            addObject(new Hindernis(),i,getHeight()-1);
        }
        for(int i=1;i<getHeight();i++) {
            addObject(new Hindernis(),0,i);
            addObject(new Hindernis(),getWidth()-1,i);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Spinne spinne = new Spinne();
        addObject(spinne,2,7);
        Fliege fliege = new Fliege();
        addObject(fliege,9,3);
        Hindernis hindernis = new Hindernis();
        addObject(hindernis,6,6);
        Klatsche klatsche = new Klatsche();
        addObject(klatsche,4,3);
        Klatsche klatsche2 = new Klatsche();
        addObject(klatsche2,11,7);
        Hindernis hindernis2 = new Hindernis();
        addObject(hindernis2,6,7);
        Hindernis hindernis3 = new Hindernis();
        addObject(hindernis3,7,5);
        Hindernis hindernis4 = new Hindernis();
        addObject(hindernis4,8,4);
        Hindernis hindernis5 = new Hindernis();
        addObject(hindernis5,3,2);
        Hindernis hindernis6 = new Hindernis();
        addObject(hindernis6,2,1);
        Spinne spinne2 = new Spinne();
        addObject(spinne2,7,6);
        Spinne spinne3 = new Spinne();
        addObject(spinne3,11,2);
        Spinne spinne4 = new Spinne();
        addObject(spinne4,6,2);
        Fliege fliege2 = new Fliege();
        addObject(fliege2,8,8);
        Fliege fliege3 = new Fliege();
        addObject(fliege3,13,7);
        Fliege fliege4 = new Fliege();
        addObject(fliege4,2,5);
        Fliege fliege5 = new Fliege();
        addObject(fliege5,2,2);
        
        addObject(hindernis6,13,8);
        Hindernis hindernis7 = new Hindernis();
        addObject(hindernis7,13,7);
        Hindernis hindernis8 = new Hindernis();
        addObject(hindernis8,13,6);
        Hindernis hindernis9 = new Hindernis();
        addObject(hindernis9,13,4);
        Hindernis hindernis10 = new Hindernis();
        addObject(hindernis10,13,3);
        Hindernis hindernis11 = new Hindernis();
        addObject(hindernis11,13,5);
        Hindernis hindernis12 = new Hindernis();
        addObject(hindernis12,16,8);
        Hindernis hindernis13 = new Hindernis();
        addObject(hindernis13,18,8);
        Hindernis hindernis14 = new Hindernis();
        addObject(hindernis14,18,7);
        Hindernis hindernis15 = new Hindernis();
        addObject(hindernis15,18,6);
        Hindernis hindernis16 = new Hindernis();
        addObject(hindernis16,22,8);
        Hindernis hindernis17 = new Hindernis();
        addObject(hindernis17,22,7);
        Hindernis hindernis18 = new Hindernis();
        addObject(hindernis18,25,8);
        Hindernis hindernis19 = new Hindernis();
        addObject(hindernis19,25,7);
        Hindernis hindernis20 = new Hindernis();
        addObject(hindernis20,25,6);
        Hindernis hindernis21 = new Hindernis();
        addObject(hindernis21,25,5);
    }
}