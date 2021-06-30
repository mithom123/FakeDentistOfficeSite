<%----------------------------------------------------------------------------
    Mitchell Thomason
    Java 3
    Final Project
----------------------------------------------------------------------------%>

<%@page import="Business.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient Info</title>
    </head>
    <%
        Patient p1 = (Patient)session.getAttribute("p1");
    %>
    <body>
        <form action="http://localhost:8080/DentistOffice/info" method="post">
            <table>
                <tr>
                    <td>Password: </td>
                    <td><input type="Password" name="pswdTb" value="<%=p1.getPasswd()%>"></td>
                </tr>
                <tr>
                    <td>First Name: </td>
                    <td><input type="text" name="fNameTb" value="<%=p1.getFirstName()%>"></td>
                </tr>
                <tr>
                    <td>Last Name: </td>
                    <td><input type="text" name="lNameTb" value="<%=p1.getLastName()%>"></td>
                </tr>
                <tr>
                    <td>Address: </td>
                    <td><input type="text" name="addrTb" value="<%=p1.getAddr()%>"></td>
                </tr>
                <tr>
                    <td>EMail: </td>
                    <td><input type="text" name="emailTb" value="<%=p1.getEmail()%>"></td>
                </tr>
                <tr>
                    <td>Insurance Company: </td>
                    <td><input type="text" name="insCoTb" value="<%=p1.getInsCo()%>"></td>
                </tr>
                <tr>
                    <form action="http://localhost:8080/DentistOffice/patientHome" method="post">
                        <td><input type="Submit" value="Cancel" name="cancelBtn"></td>
                    </form>
                    <td><input type="reset" value="Reset" name="resetBtn"></td>
                    <td><input type="submit" value="Submit" name="submitBtn"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
