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

    public int modus = 1;

    public void act() {
        this.fliegenFressen(modus);
    }

    public void fliegenFressen(int modus) {
        while (!hindernisVorn()) {
            
            this.schritt();
            
            if (!this.fliegeAmPlatz()) {
                continue;
            }
            
            switch (modus) {
                case 1: 
                    if (true) {
                        this.fliegeFressen();
                    }
                
                case 2: 
                    if (!hindernisLinks() && !hindernisRechts()) {
                        this.fliegeFressen();
                    }

                case 3: 
                    if ((hindernisLinks() && !hindernisRechts()) || (!hindernisLinks() && hindernisRechts()) || (!hindernisLinks() && !hindernisRechts())) {
                        this.fliegeFressen();
                    }
                    
                case 4: 
                    if (hindernisLinks() && hindernisRechts()) {
                        this.fliegeFressen();
                    }
                
                case 5: 
                    if ((hindernisLinks() && hindernisRechts()) || (!hindernisLinks() && !hindernisRechts())) {
                        this.fliegeFressen();
                    }
            }
        }
    }
}
