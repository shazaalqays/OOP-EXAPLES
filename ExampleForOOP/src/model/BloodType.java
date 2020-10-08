/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author YOGA
 */
public enum BloodType {
    APLUS("A+"),
    BPLUS("B+"),
    ZEROPLUS("0+"),
    ABPLUS("AB+"),
    AMIN("A-"),
    BMIN("B-"),
    ZEROMIN("0-");
    
    
    private String type;

    BloodType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
