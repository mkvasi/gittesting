<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>

<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
        <link rel="stylesheet" href="css.css">
    </head>
     <body background="lego.jpg">
        
        
            

        <div class="topnav">
            <a class="active" href="customerpage.jsp">Create order</a>
            <a href="showInvoices.jsp">Invoices</a>
        </div> 

        <div id="content">
            
            
            <div id="createorder">
    
        <%User user = (User) request.getSession().getAttribute("user");%>
        <h1>Hello <%=user.getEmail()%> </h1>


        <form class="form-horizontal" name="createOrder" action="FrontController" method="POST">
               <input type="hidden" name="command" value="createOrder">
          

                <!-- Form Name -->
                <br>
                <h3>Create order</h3>

                <!-- Lenght input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">Length</label>  
                    <div class="col-md-4">
                        <input id="textinput" name="length" type="number" placeholder="0" class="form-control input-md" >
                    </div>
                </div>

                <!-- Width input-->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">Width</label>  
                    <div class="col-md-4">
                        <input id="textinput" name="width" type="number" placeholder="0" class="form-control input-md">
                    </div>
                </div>

                <!-- Height input -->
                <div class="form-group">
                    <label class="col-md-4 control-label" for="textinput">Layers</label>  
                    <div class="col-md-4">
                        <input id="textinput" name="layers" type="number" placeholder="0" class="form-control input-md"> 
                         <br><br><br><br><br>
                         <input class="btn btn-default" type="submit" value="Create Order" >
                    </div>
                </div>
                
                <br>
        </form>
        <form class="form-horizontal" name="showInvoices" action="FrontController" method="POST">
            <input type="hidden" name="command" value="showInvoices">
            <input class="btn btn-default" type="submit" value="Show your invoices" >
        </form>
         <% String error = (String) request.getAttribute( "error");
           if ( error != null) { 
               out.println("<H2>Error!!</h2>");
               out.println(error);
           }
        %>
        </div>
        </div>
    </body>
</html>



