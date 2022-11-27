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
        this.laufen();
    }

    public void laufen() {
        while (!this.klatscheVorn() && !this.hindernisVorn()) {
            this.schritt();
            
            if (this.fliegeAmPlatz()) {
                this.fliegeFressen();
                return;
            }
        }
        
        // Hindernis umgehen
        this.linksDrehen();
        this.schritt();
        this.rechtsDrehen();
        this.schritt();
        this.schritt();
        this.rechtsDrehen();
        
        while (this.klatscheVorn() || this.hindernisVorn()) {
            this.linksDrehen();
            this.schritt();
            this.rechtsDrehen();
        }
        
        this.schritt();
        this.linksDrehen();
        
        if (this.fliegeAmPlatz()) {
            this.fliegeFressen();
        }
        else {
            this.laufen();
        }
    }
}
