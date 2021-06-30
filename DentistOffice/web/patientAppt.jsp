<%----------------------------------------------------------------------------
    Mitchell Thomason
    Java 3
    Final Project
----------------------------------------------------------------------------%>

<%@page import="Business.Appointment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient Appointment</title>
    </head>
    <body>
        <form action="http://localhost:8080/DentistOffice/EditAppointment" method="post">
            <table>
                Please input all information to check for availability.
                <%
                    if (session.getAttribute("appointment").equals(true)) {   
                        Appointment a1 = (Appointment)session.getAttribute("a1");
                %>
                <tr>
                    <td>Appointment Date/Time: </td>
                    <td><input type="text" name="dateTimeTb" value="<%=a1.getApptDateTime()%>"></td>
                </tr>
                <tr>
                    <td>Dentist ID: </td>
                    <td><input type="text" name="dentIDTb" value="<%=a1.getDentId()%>"></td>
                </tr>
                <tr>
                    <td>Procedure Code: </td>
                    <td><input type="text" name="procCodeTb" value="<%=a1.getProcCode()%>"></td>
                </tr>
                <%
                    }
                    else {
                %>
                <tr>
                    <td>Appointment Date/Time: </td>
                    <td><input type="text" name="dateTimeTb"></td>
                </tr>
                <tr>
                    <td>Dentist ID: </td>
                    <td><input type="text" name="dentIDTb"></td>
                </tr>
                <tr>
                    <td>Procedure Code: </td>
                    <td><input type="text" name="procCodeTb"></td>
                </tr>
                <%
                    }
                %>
                <tr>
                    
                    <td><input type="reset" value="Reset"></td>
                    <td><input type="submit" value="Submit"></td>
                </tr>
            </table>
        </form>
        <form action="http://localhost:8080/DentistOffice/patientHome.jsp" method="post">
            <input type="submit" value="Back">
        </form>
    </body>
</html>
