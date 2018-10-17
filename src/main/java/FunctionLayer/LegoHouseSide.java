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
public class LegoHouseSide {
   int brick4, brick2, brick1;

    public LegoHouseSide(int brick4, int brick2, int brick1) {
        this.brick4 = brick4;
        this.brick2 = brick2;
        this.brick1 = brick1;
    }

    public int getBrick4() {
        return brick4;
    }

    public void setBrick4(int brick4) {
        this.brick4 = brick4;
    }

    public int getBrick2() {
        return brick2;
    }

    public void setBrick2(int brick2) {
        this.brick2 = brick2;
    }

    public int getBrick1() {
        return brick1;
    }

    public void setBrick1(int brick1) {
        this.brick1 = brick1;
    }

    @Override
    public String toString() {
        return "brick af 4x2: " + brick4 + "\n brick af 2x2: " + brick2 + "\n brick af 1x2: " + brick1 ;
    }
    
 
   
}
