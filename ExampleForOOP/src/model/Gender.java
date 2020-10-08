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
public enum Gender {
    M("Man"),
    W("Woman");
    
    public String g;

    private Gender(String g) {
        this.g = g;
    }

    public String getG() {
        return g;
    }
    
}
