package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Side;

/**
 * The purpose of LogicFacade is to...
 *
 * @author kasper
 */
public class LogicFacade {

    public static User login(String email, String password) throws LegoHouseException {
        return UserMapper.login(email, password);
    }

    public static User createUser(String email, String password) throws LegoHouseException {
        User user = new User(email, password, "customer");
        UserMapper.createUser(user);
        return user;
    }

    public static Order createOrder(int length, int width, int layers, User user) throws LegoHouseException {
        Order order = new Order(length, width, layers);
        OrderMapper.createOrder(order, user);
        return order;
    }

    public static LegoHouse getHouse(int length, int width, int layers) {

        Calculator calc = new Calculator();
        LegoHouse house = calc.makeHouse(length, width, layers);
        return house;

    }

    public static Order getOrderForInvoice(int orderId, List<Order> orders) {

        for (Order order : orders) {
            if (order.getId() == orderId) {
                return order;
            }
        }
        return null;

    }
    
    public static int getAllBricksForLegoHouse(LegoHouseLayer layer, Order order){
       int east = layer.getSideEast().getBrick1() + layer.getSideEast().getBrick2() +  layer.getSideEast().getBrick4();
       int west = layer.getSideWest().getBrick1() + layer.getSideWest().getBrick2() +  layer.getSideWest().getBrick4();
       int south = layer.getSideSouth().getBrick1() + layer.getSideSouth().getBrick2() +  layer.getSideSouth().getBrick4();
       int north = layer.getSideNorth().getBrick1() + layer.getSideNorth().getBrick2() +  layer.getSideNorth().getBrick4();
      
       int allBricks = (east + west + north + south)*(order.getLayers()); 
        return allBricks;
       
    }
    

    public static List<Order> getUserOrder(User user) throws LegoHouseException {
        List<Order> orders;

        orders = OrderMapper.getUserOrders(user);
        return orders;
    }

    public static LegoHouseLayer getLayers(LegoHouse house) {
        LegoHouseSide sideEast = null;
        LegoHouseSide sideNorth = null;
        LegoHouseSide sideWest = null;
        LegoHouseSide sideSouth = null;

        for (LegoHouseLayer layer : house.getHouse()) {
            sideEast = layer.getSideEast();
            sideNorth = layer.getSideNorth();
            sideWest = layer.getSideWest();
            sideSouth = layer.getSideSouth();
        }
        LegoHouseLayer layers = new LegoHouseLayer(sideWest, sideEast, sideNorth, sideSouth);

        return layers;
    }
    
    public static List<Order> getAllOrders() throws LegoHouseException{
        List<Order> orders;
        orders = OrderMapper.getAllInvoiceId();
        return orders;
    }

}
