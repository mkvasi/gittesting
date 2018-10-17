package PresentationLayer;

import FunctionLayer.LegoHouse;
import FunctionLayer.LegoHouseException;
import FunctionLayer.LogicFacade;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class CreateOrder extends Command {



    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LegoHouseException  {
        String lengthString = request.getParameter("length");
        String widthString = request.getParameter("width");
        String layersString = request.getParameter("layers");
        
            
            if (lengthString.equals("") || widthString.equals("") || layersString.equals("")) {
                throw new NumberFormatException("Type in some numbers please");                
            }
            
       
        int length   = Integer.parseInt(lengthString);
        int width   = Integer.parseInt(widthString);
        int layers   = Integer.parseInt(layersString);
       
        
        User user = (User) request.getSession().getAttribute("user");
        
        List orders = LogicFacade.getUserOrder(user); 
        
 
        
        
            Order order = null; 
      
            order = LogicFacade.createOrder(length, width, layers, user);
            orders.add(order);

             
      

        
        //LegoHouse house =  LogicFacade.getHouse(length, width, layers);
        
        //houses.add(house); 
        
       HttpSession session = request.getSession();
       session.setAttribute("order", order);
       session.setAttribute("orders", orders);
       //session.setAttribute("houses", houses);
       //session.setAttribute("house", house);
        return user.getRole() + "page";
    
    }
    
}