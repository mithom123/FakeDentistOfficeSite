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
        <title>Success</title>
    </head>
    <body>
        <h1>Appointment created successfully</h1>
        <form action="http://localhost:8080/DentistOffice/PatientHome" method="post">
            <input type="submit" value="Home">
        </form>
    </body>
</html>
