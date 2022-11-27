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
        int schritte = fliegeSuchen();
        this.fliegeFressen();
        rueckweg(schritte);
    }
    
    public void rueckweg(int schritte) {
        this.linksDrehen();
        this.linksDrehen();
        
        for (int i = 0; i < schritte; i++) {
            this.schritt();
        }
    }

    public int fliegeSuchen() {
        int count = 0;
        while (!fliegeAmPlatz()) {
            this.schritt();
            count++;
        }
        return count;
    }
}
