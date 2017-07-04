/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 *
 * @author Tu Nguyen
 */
public enum EducationLevel { 
    BACHELOR(0) , MASTER (0.1), DOCTOR(0.25);
    
    private double SUPLEV;

    private EducationLevel(double SUPLEV) {
        this.SUPLEV = SUPLEV;
    }

    public double getSUPLEV() {
        return SUPLEV;
    }
    
    
}
