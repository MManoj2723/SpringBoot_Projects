<%@page isELIgnored="false" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<h1 style="text-align: center;color: brown;">Product Details</h1>

<c:choose>

<c:when test="${not empty products}">

<table bgcolor="cyan" border="1" align="center">

<tr>
<th>PID</th><th>PNAME</th><th>PPRICE</th><th>PCOUNTRY</th><th>EDIT</th><th>DELETE</th>
</tr>

<c:forEach var="p" items="${products }">

	<tr>
	<td>${p.pid}</td>
	<td>${p.pname }</td>
	<td>${p.pprice }</td>
	<td>${p.pcountry}</td>
	
	<td> <a href="edit?pno=${p.pid}" style="text-algin:center"> <img src="images/edit.png" width="30px" height="30px">  </a>   </td>
	
	<td> 
	
	<div style="width: 35px;overflow: hidden;border-radius: 10%;text-align: center;margin:auto;">
        <a href="delete?pno=${p.pid}" onclick="return confirm('Are You sure want to delete the record')"><img src="images/delete.png" width="100%" style="border-radius:10% ;" ></a>
    </div>
    
	 </td>
	
	</tr>
	
</c:forEach>

 </table>


</c:when>


<c:otherwise>
 
 <h1 style="color: red; text-align: center;">No ProductssAre Found</h1>
 
 </c:otherwise>
 
 </c:choose>
 
 <c:if test="${not empty resultMsg}">
 
 
 <div style="width: 25%;color: red;text-align: center;margin: auto;">
		${resultMsg}
    </div>
 
 </c:if>
 
 <div style="width:25%;margin:auto;text-align:center">
 
 <a href="./">Return Home</a>
 
 </div>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 