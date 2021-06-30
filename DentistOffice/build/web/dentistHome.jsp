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
        <title>Dentist Home</title>
    </head>
    <%
        Dentist d1 = (Dentist)session.getAttribute("d1");
    %>
    <body>
        <h1>Welcome <%=d1.getFirstName()%> <%=d1.getLastName()%></h1>
        <a href="dentistInfo.jsp">View Dentist Information</a>
        <a href="http://localhost:8080/DentistOffice/AppointmentLookup">View Appointments</a>
    </body>
</html>
