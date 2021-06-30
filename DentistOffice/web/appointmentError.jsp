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
        <title>Appointment Error</title>
    </head>
    <%
        Appointment a1 = (Appointment)session.getAttribute("a1");
    %>
    <body>
        <h1>No appointments available at <%= a1.getApptDateTime() %> with dentist <%= a1.getDentId() %>.</h1>
        <form action="http://localhost:8080/DentistOffice/AppointmentLookup" method="post">
            <input type="submit" value="Back">
        </form>
    </body>
</html>
