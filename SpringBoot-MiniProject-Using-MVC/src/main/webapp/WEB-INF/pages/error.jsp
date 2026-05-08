<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1 style="text-align: center; color: red;">Error.jps(Global Error page)</h1>

<h1 style="text-align: center;color: red;">Internal Problem has Occured</h1>

<table border="1" bgcolor="yellow" align="center">

        <tr>
            <td>Status:</td>
            <td>${status}</td>
        </tr>

        <tr>
            <td>Message</td>
            <td>${message}</td>
        </tr>

        <tr>
            <td>Path</td>
            <td>${path}</td>
        </tr>

        <tr>
            <td>TimeStamp</td>
            <td>${timestamp}</td>
        </tr>

    </table>



</body>
</html>