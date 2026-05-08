<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@page isELIgnored="false" %>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align: center; color: red;">5xxError.jsp</h1>

<h3 style="text-align: center;color: red;">ServerError(Generated Manually Through @ResponseStatus)</h3>

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