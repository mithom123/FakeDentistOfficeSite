<%----------------------------------------------------------------------------
    Mitchell Thomason
    Java 3
    Final Project
----------------------------------------------------------------------------%>

<%@page import="Business.Dentist"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dentist Info</title>
    </head>
    <%
        Dentist d1 = (Dentist)session.getAttribute("d1");
    %>
    <body>
        <h1>Information for dentist <%=d1.getId()%></h1>
        <form action="http://localhost:8080/DentistOffice/info" method="post">
            <table>
                <tr>
                    <td>Password: </td>
                    <td><input type="password" name="pswdTb" value="<%=d1.getPasswd()%>"</td>
                </tr>
                <tr>
                    <td>First Name: </td>
                    <td><input type="text" name="fNameTb" value="<%=d1.getFirstName()%>"></td>
                </tr>
                <tr>
                    <td>Last Name: </td>
                    <td><input type="text" name="lNameTb" value="<%=d1.getLastName()%>"></td>
                </tr>
                <tr>
                    <td>EMail: </td>
                    <td><input type="text" name="emailTb" value="<%=d1.getEmail()%>"></td>
                </tr>
                <tr>
                    <td>Office: </td>
                    <td><input type="text" name="officeTb" value="<%=d1.getOffice()%>"></td>
                </tr>
                <tr>
                    <form action="http://localhost:8080/DentistOffice/dentistHome" method="post">
                        <td><input type="submit" value="Back"></td>
                    </form>
                    <td><input type="reset" value="Reset"></td>
                    <td><input type="submit" value="Submit"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
