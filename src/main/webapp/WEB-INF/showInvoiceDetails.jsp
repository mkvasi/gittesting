
<%@page import="FunctionLayer.LegoHouseLayer"%>
<%@page import="FunctionLayer.LegoHouse"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="FunctionLayer.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List,java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css.css">
    </head>
    <body background="lego.jpg">




        <div class="topnav">

        </div> 

        <div id="content">

            <h1 align="center">Invoice</h1>
            <br>

            <%User user = (User) request.getSession().getAttribute("user");%>
            <%Order order = (Order) request.getSession().getAttribute("order");%>
            <%LegoHouse house = (LegoHouse) request.getSession().getAttribute("house");%>
            <%LegoHouseLayer layer = (LegoHouseLayer) request.getSession().getAttribute("layer");%>
            <%List legohouse = (List) request.getSession().getAttribute("houses");%>
            <%int allBricks = (int) request.getSession().getAttribute("bricks");%>

            <div id="upper">
                <table border="1" style="text-align: center" >
                    <tr>

                        <th><p>Type of Brick for each layer </th>
                        <th><p>House Side East:</th>
                        <th><p>House Side West:</th>
                        <th><p>House Side South:</th>
                        <th><p>House side North: </th>

                    <tr>
                        <th><p>4x2</th>
                        <td><p><%out.print(layer.getSideEast().getBrick4()); %></td>
                        <td><p><%out.print(layer.getSideWest().getBrick4()); %></td>
                        <td><p><%out.print(layer.getSideSouth().getBrick4()); %></td>
                        <td><p><%out.print(layer.getSideNorth().getBrick4());%></td>
                    </tr>
                    <tr>
                        <th><p>2x2</th>
                        <td><p><%out.print(layer.getSideEast().getBrick2()); %></td>
                        <td><p><%out.print(layer.getSideWest().getBrick2()); %></td>
                        <td><p><%out.print(layer.getSideSouth().getBrick2()); %></td>
                        <td><p><%out.print(layer.getSideNorth().getBrick2());%></td>
                    </tr>
                    <tr>
                        <th><p>1x2</th>
                        <td><p><%out.print(layer.getSideEast().getBrick1()); %></td>
                        <td><p><%out.print(layer.getSideWest().getBrick1()); %></td>
                        <td><p><%out.print(layer.getSideSouth().getBrick1()); %></td>
                        <td><p><%out.print(layer.getSideNorth().getBrick1());%></td>
                    </tr>

                </table>
            </div>
            <br>
            <div id="downer">
                <table border="1" style="text-align: center" >


                    <tr>
                        <th><p>Order id</th>
                        <td><p><%out.print(order.getId()); %></td>

                    </tr>
                    <tr>
                        <th><p>Length</th>
                        <td><p><%out.print(order.getLength()); %></td>

                    </tr>
                    <tr>
                        <th><p>Width</th>
                        <td><p><%out.print(order.getWidth()); %></td>

                    </tr>
                    <tr>
                        <th><p>Height</th>
                        <td><p><%out.print(order.getLayers()); %></td>

                    </tr>


                </table>
            </div>
            <br>
            <tr>


                <th><h3 align="center">Bricks total for making the house: <%out.print(allBricks);%></th>

            </tr>

            <form class="form-horizontal" name="showInvoices" action="FrontController" method="POST">
                <input type="hidden" name="command" value="showInvoices">
                <input class="btn btn-default" type="submit" value="Go back to invoices" >
            </form>

        </div>
    </body>

</html>


