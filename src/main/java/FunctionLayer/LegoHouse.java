/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

import java.util.List;

/**
 *
 * @author leage
 */
public class LegoHouse {
    List<LegoHouseLayer> house; 

    public LegoHouse(List<LegoHouseLayer> house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return "Dit hus ser således ud" + house + '}';
    }

    public List<LegoHouseLayer> getHouse() {
        return house;
    }

    public void setHouse(List<LegoHouseLayer> house) {
        this.house = house;
    }
    
    
}
