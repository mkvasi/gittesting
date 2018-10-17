/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author leage
 */
public class Calculator {
    
    
    
    public LegoHouse makeHouse(int length, int width, int layers) {
        List<LegoHouseLayer> houseDone = new ArrayList();
        
        for (int i = 0; i < layers; i++) {
            houseDone.add(makeLayer(length, width));
        }
 
        
        
        LegoHouse house = new LegoHouse(houseDone);
        return house;
        
    }
    
    public LegoHouseLayer makeLayer(int length, int width){
        
        LegoHouseSide sideWest = calculateSideLength(length); 
        LegoHouseSide sideEast = calculateSideLength(length); 
        LegoHouseSide sideNorth = calculateSideWitdth(width);
        LegoHouseSide sideSouth = calculateSideWitdth(width);
        
        
        LegoHouseLayer legoHouseLayer = new LegoHouseLayer(sideWest, sideEast, sideNorth, sideSouth); 
        return legoHouseLayer;
        
    }
        

    public LegoHouseSide calculateSideLength(int length) {
        int numberOfBricks1; 
       
        if(length%2 > 0){
            numberOfBricks1 = 1; 
        }else{
            numberOfBricks1 = 0; 
        }

        int numberOfBricks4 = length / 4;

        int numberOfdotsLeft = length % 4;

        int numberOfBricks2 = numberOfdotsLeft / 2;

        // int numberOfdotsLeft2 = numberOfBricks2 % 2;

       // int numberOfBricks1 = numberOfdotsLeft2 /1;
        
        
        

        LegoHouseSide side = new LegoHouseSide(numberOfBricks4, numberOfBricks2, numberOfBricks1);


        return side;
    }

    public LegoHouseSide calculateSideWitdth(int width) {
        int numberOfBricks1;  
        if(width%2 > 0){
            numberOfBricks1 = 1; 
        }else{
            numberOfBricks1 = 0; 
        }
        
        width = width - 4;  
        
        int numberOfBricks4 = width / 4;

        int numberOfdotsLeft = width % 4;

        int numberOfBricks2 = numberOfdotsLeft / 2;

      //  int numberOfdotsLeft2 = numberOfBricks2 % 2;

       // int numberOfBricks1 = numberOfdotsLeft2 / 1;

        LegoHouseSide side = new LegoHouseSide(numberOfBricks4, numberOfBricks2, numberOfBricks1);


        return side;
    }
}
    
    
    


