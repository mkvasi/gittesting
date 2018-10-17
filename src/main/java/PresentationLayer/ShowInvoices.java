
package PresentationLayer;

import FunctionLayer.LegoHouse;
import FunctionLayer.LegoHouseException;
import FunctionLayer.LogicFacade;
import FunctionLayer.Order;
import FunctionLayer.User;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ShowInvoices extends Command {

    public ShowInvoices() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
     User user = (User) request.getSession().getAttribute("user");
     Order order = (Order)request.getSession().getAttribute("order");
     
     
        List<Order> orders = new ArrayList<>();
      
        try {
                    if(user.getRole().equals("customer")){
            orders = LogicFacade.getUserOrder(user);
                
            }else if(user.getRole().equals("employee")){
            orders = LogicFacade.getAllOrders();
            }
        } catch (LegoHouseException ex) {
            Logger.getLogger(ShowInvoices.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getSession().setAttribute("orders", orders);
        return "showInvoices";
      
    }

          
          
     
    }
    

