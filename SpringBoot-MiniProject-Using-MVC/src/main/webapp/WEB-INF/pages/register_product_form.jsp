<%@page isELIgnored="false" %>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h1 style="text-align: center;color: red;">Product Registration Form</h1>			

<frm:form action="register" method="post" modelAttribute="prodVO">


<table align="center" bgcolor="yellow">


    <tr>
        <td>ProductName:</td>
        <td>  <frm:input path="pname"/>  </td>
    </tr>

    <tr>
        <td>ProductPrice:</td>
        <td>  <frm:input path="pprice"/>   </td>
    </tr>
    
    <tr>
		    <td>ProductCountry:</td>
		    <td>	<frm:input path="pcountry" readonly="true"/> </td>
    </tr>
    
    
    <tr>
        <td><input type="submit" value="RegisterProduct"></td>
        <td><input type="reset" value="Cancel"></td>
    </tr>
 </table>



</frm:form>


<c:if test="${not empty resultMsg}">

<div style="text-align: center;color: green;">
    ${resultMsg} 
 </div>

</c:if> 

<div style="width:25%;margin:auto;text-align:center">
 
 <a href="./">Return Home</a>
 
 </div>

























