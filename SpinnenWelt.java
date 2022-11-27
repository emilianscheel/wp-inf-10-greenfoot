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

        Tarantel tarantel = new Tarantel();
        addObject(tarantel,5,13);
        Klatsche klatsche = new Klatsche();
        addObject(klatsche,6,13);
        Klatsche klatsche2 = new Klatsche();
        addObject(klatsche2,7,12);
        Klatsche klatsche3 = new Klatsche();
        addObject(klatsche3,8,11);
        Klatsche klatsche4 = new Klatsche();
        addObject(klatsche4,9,10);
        Klatsche klatsche5 = new Klatsche();
        addObject(klatsche5,10,9);
        Klatsche klatsche6 = new Klatsche();
        addObject(klatsche6,11,8);
        Klatsche klatsche7 = new Klatsche();
        addObject(klatsche7,12,7);
        Klatsche klatsche8 = new Klatsche();
        addObject(klatsche8,13,6);
        Klatsche klatsche9 = new Klatsche();
        addObject(klatsche9,7,13);
        Klatsche klatsche10 = new Klatsche();
        addObject(klatsche10,9,11);
        Klatsche klatsche11 = new Klatsche();
        addObject(klatsche11,8,12);
        Klatsche klatsche12 = new Klatsche();
        addObject(klatsche12,10,10);
        Klatsche klatsche13 = new Klatsche();
        addObject(klatsche13,11,9);
        Klatsche klatsche14 = new Klatsche();
        addObject(klatsche14,12,8);
        Klatsche klatsche15 = new Klatsche();
        addObject(klatsche15,13,7);
    }
}