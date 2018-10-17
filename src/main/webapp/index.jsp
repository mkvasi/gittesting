<%-- 
    Document   : index
    Created on : Aug 22, 2017, 2:01:06 PM
    Author     : kasper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome page</title>
        <link rel="stylesheet" href="css.css">
    </head>
    
    <body background="lego.jpg">
        
        
            

        <div class="topnav">

        </div> 

        <div id="content">
            
            <h1 align="center" id="overskrift">Welcome to LegoBuilder</h1>
            
            
            
            <div id="login">
            <h3>Login</h3>
                
            <table>
                <td>
                    <form name="login" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="login">
                        Email:<br>
                        <input type="text" name="email" value="bla@bla.com">
                        <br>
                        Password:<br>
                        <input type="password" name="password" value="customer">
                        <br>
                        <input type="submit" value="Submit">
                    </form>
                </td>
            </table>
                
            </div>
            
            <div id="register">
                <h3>Create login</h3>
                <table>
                <td>
                    <form name="register" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="register">
                        Email:<br>
                        <input type="text" name="email" value="bla@bla.com">
                        <br>
                        Password:<br>
                        <input type="password" name="password1" value="sesam">
                        <br>
                        Retype Password:<br>
                        <input type="password" name="password2" value="sesam">
                        <br>
                        <input type="submit" value="Submit">
                    </form>
                </td>
                </table>
                
        <% String error = (String) request.getAttribute( "error");
           if ( error != null) { 
               out.println("<H2>Error!!</h2>");
               out.println(error);
           }
        %>


        </div>
        
    </body>
</html>
