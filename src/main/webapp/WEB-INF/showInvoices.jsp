

<%@page import="FunctionLayer.LegoHouse"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="java.util.List"%>
<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Invoices</title>
         <link rel="stylesheet" href="css.css">
    </head>
        <body background="lego.jpg">
        
        
            

        <div class="topnav">
            <a href="customerpage.jsp">Create order</a>
            <a class="active" href="showInvoices.jsp">Invoices</a>
        </div> 

        <div id="content">
            
            <div id="createorder">
   
        <h1 class="col-sm-4" style="text-align: center">Invoices</h1>
            <!--USER INFO-->
            <br>
            <div class="text-muted col-sm-4" padding="4px">
                <%User user = (User) request.getSession().getAttribute("user");%>
                <%List<Order> orders = (List) request.getSession().getAttribute("orders");%>
                <%List<LegoHouse> houses = (List) request.getSession().getAttribute("houses");%>
                  <ul class="list-group pre-scrollable">

                
            
                      <%
            for (Order order : orders) {
                out.println("<li><a href=\"FrontController?command=showInvoiceDetails&invoiceId=" + order.getId() + "\">InvoiceID: " + order.getId() + "</li><br>");
            }
        %>    
                </ul>
            </div>
        </div>
        </div>
    </body>
</html>

                