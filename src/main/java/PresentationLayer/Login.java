package PresentationLayer;

import FunctionLayer.LegoHouse;
import FunctionLayer.LogicFacade;
import FunctionLayer.LegoHouseException;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 The purpose of Login is to...

 @author kasper
 */
public class Login extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) {
        String email = request.getParameter( "email" );
        String password = request.getParameter( "password" );
        
        List<Order> orders = null; 
        User user = null; 
        try {
            user = LogicFacade.login( email, password );
            
            if(user.getRole().equals("customer")){
            orders = LogicFacade.getUserOrder(user);
                
            }else if(user.getRole().equals("employee")){
            orders = LogicFacade.getAllOrders();
            }
            
            
        } catch (LegoHouseException ex) {
           ex.getMessage();
        }
        //List<LegoHouse> houses = new ArrayList();
        
        HttpSession session = request.getSession();
        
        session.setAttribute( "user", user );
        session.setAttribute( "role", user.getRole() );
        session.setAttribute( "user_id", user.getId() );
        session.setAttribute("orders", orders);
        //session.setAttribute("houses", houses);
        
        return user.getRole() + "page";
    }

}
