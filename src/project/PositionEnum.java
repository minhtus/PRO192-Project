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
public enum PositionEnum {
    PROFESSOR (1.25), ASSOCIATE_PROFESSOR(0.5), HONOR_PROFESSOR(0.75);
    
    private double SUPPOS;

    private PositionEnum(double SUPPOS) {
        this.SUPPOS = SUPPOS;
    }

    public double getSUPPOS() {
        return SUPPOS;
    }
    
}
