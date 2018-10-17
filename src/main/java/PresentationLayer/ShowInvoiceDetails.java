
package PresentationLayer;

import FunctionLayer.LegoHouse;
import FunctionLayer.LegoHouseException;
import FunctionLayer.LegoHouseLayer;
import FunctionLayer.LogicFacade;
import FunctionLayer.Order;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowInvoiceDetails extends Command {

    public ShowInvoiceDetails() {
    }

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {
          HttpSession session = request.getSession();
          List<Order> orders = (List<Order>) session.getAttribute("orders"); 
          //List<LegoHouse> houses = (List<LegoHouse>)session.getAttribute("houses");
          session.getAttribute("user");
          Order order = LogicFacade.getOrderForInvoice(Integer.parseInt(request.getParameter("invoiceId")), orders);
          
          LegoHouse house =  LogicFacade.getHouse(order.getLength(), order.getWidth(), order.getLayers());
          
          LegoHouseLayer layer = LogicFacade.getLayers(house); 
          
          int bricks = LogicFacade.getAllBricksForLegoHouse(layer, order); 
          
          
          session.setAttribute("orders", orders);
          //session.setAttribute("houses", houses);
          session.setAttribute("house", house);
          session.setAttribute("layer", layer);
          session.setAttribute("bricks", bricks);
          
          session.setAttribute("order", order);
          
          
          
          
          
          return "showInvoiceDetails";
    }
    
}
