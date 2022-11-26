import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import javax.swing.JOptionPane;

/**
 * Write a description of class Tarantel here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tarantel extends Spinne {
    /**
     * Act - do whatever the Tarantel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public int kontostand = 0;

    public void act() {
        this.fliegeInWaldSuchen();
    }
    
    public void fliegeInWaldSuchen() {
        
        

    }

    public void fliegenEliminieren() {
    
        // Fliegen aufspüren
        World world = getWorld();
        List<Fliege> fliegen = world.getObjects(Fliege.class);

        // Sich jede Fliege einzelnt vornehmnen.
        for (int i = 0; i < fliegen.size(); i++) {

            // Zur Fliege hinteleportieren.
            setLocation(fliegen.get(i).getX(), fliegen.get(i).getY());

            // Fliege eliminieren.
            fliegeFressen();

            // Kontostand erhöhen.
            kontostand ++;

            // Info-Meldung für den Zuschauer geben.
            JOptionPane.showMessageDialog(null, "-1 addiert auf Anzahl Fliegen", "log",
                    JOptionPane.ERROR_MESSAGE);

            // Warten, bis die nächste Fliege gefressen wird.
            warten(1000);
        }

        JOptionPane.showMessageDialog(null, "Mein Kontostand liegt bei " + kontostand + "; Währung: tote Fliegen",
                "log",
                JOptionPane.ERROR_MESSAGE);
    }
}
