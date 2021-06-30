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
        <title>Dentist Appointments</title>
    </head>
    <%
        Dentist d1 = (Dentist)session.getAttribute("d1");
        AppointmentList al1 = new AppointmentList();
        al1.findAppointments(d1.getId());
    %>
    <body>
        <h1>Upcoming appointments</h1>
        <table>
            <tr>
                <td>Appointment Date and Time &nbsp; &nbsp;</td>
                <td>Patient ID &nbsp; &nbsp;</td>
                <td>Procedure Code</td>
            </tr>
            <%
                for (int i = 0; al1.aArr.size() > i; i++)
                {
                    Appointment a1 = al1.aArr.get(i);
            %>
            <tr>
                <td><%=a1.getApptDateTime()%></td>
                <td><%=a1.getPatId()%></td>
                <td><%=a1.getProcCode()%></td>
            </tr>
            <%
                }
            %>
            <tr>
            <form action="http://localhost:8080/DentistOffice/dentistHome.jsp" method="post">
                <td><input type="submit" value="Back"></td>
            </form>
            </tr>
        </table>
    </body>
</html>
