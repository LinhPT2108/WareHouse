/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entities;

/**
 *
 * @author pc
 */
public class Unit {
    private int unitID;
    private String unitName;

    public Unit() {
    }

    public Unit(int unitID, String unitName) {
        this.unitID = unitID;
        this.unitName = unitName;
    }

    @Override
    public String toString() {
        return this.unitName;
    }

    public int getUnitID() {
        return unitID;
    }

    public void setUnitID(int unitID) {
        this.unitID = unitID;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
    
    
}
