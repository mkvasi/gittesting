/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;


/**
 *
 * @author leage
 */
public class LegoHouseLayer {
 LegoHouseSide sideWest; 
 LegoHouseSide sideEast;
 LegoHouseSide sideNorth;
 LegoHouseSide sideSouth;
 

    public LegoHouseLayer(LegoHouseSide sideWest, LegoHouseSide sideEast, LegoHouseSide sideNorth, LegoHouseSide sideSouth) {
        this.sideWest = sideWest;
        this.sideEast = sideEast;
        this.sideNorth = sideNorth; 
        this.sideSouth = sideSouth;
    }

    public LegoHouseSide getSideWest() {
        return sideWest;
    }

    public void setSideWest(LegoHouseSide sideWest) {
        this.sideWest = sideWest;
    }

    public LegoHouseSide getSideEast() {
        return sideEast;
    }

    public void setSideEast(LegoHouseSide sideEast) {
        this.sideEast = sideEast;
    }

    public LegoHouseSide getSideNorth() {
        return sideNorth;
    }

    public void setSideNorth(LegoHouseSide sideNorth) {
        this.sideNorth = sideNorth;
    }

    public LegoHouseSide getSideSouth() {
        return sideSouth;
    }

    public void setSideSouth(LegoHouseSide sideSouth) {
        this.sideSouth = sideSouth;
    }

    @Override
    public String toString() {
        return "side 1: " + sideWest + "\n side 2: " + sideEast + "\n side 3: " + sideNorth + "\n side 4: " + sideSouth + "\n" ;
    }
 
 
    
}