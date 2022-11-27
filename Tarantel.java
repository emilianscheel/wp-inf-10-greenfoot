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
        this.alleeDurchlaufen();
    }

    public void alleeDurchlaufen() {
        while (this.hindernisRechts() || this.hindernisLinks()) {
            this.schritt();
        }
    }
}
