<%----------------------------------------------------------------------------
    Mitchell Thomason
    Java 3
    Final Project
----------------------------------------------------------------------------%>

<%@page import="Business.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient Home</title>
    </head>
    <%
        Patient p1 = (Patient)session.getAttribute("p1");
    %>
    <body>
        <h1>Welcome <%=p1.getFirstName()%> <%=p1.getLastName()%></h1>
        <a href="patientInfo.jsp">View Patient Information</a>
        <a href="http://localhost:8080/DentistOffice/AppointmentLookup">View/Change/Schedule Appointment</a>
    </body>
</html>
