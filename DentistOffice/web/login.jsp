<%----------------------------------------------------------------------------
    Mitchell Thomason
    Java 3
    Final Project
----------------------------------------------------------------------------%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="http://localhost:8080/DentistOffice/loginServlet" method="Post">
            <table>
                <tr>
                    <td><label>ID: </label></td>
                    <td><input type="Text" name="idTb" id="a" required></td>
                </tr>
                <tr>
                    <td><label>Password: </label></td>
                    <td><input type="Password" name="pswdTb" required></td>
                </tr>
                <tr>
                    <td><input type="Submit" value="Submit"></td>
                    <td><input type="Reset" value="Clear"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
