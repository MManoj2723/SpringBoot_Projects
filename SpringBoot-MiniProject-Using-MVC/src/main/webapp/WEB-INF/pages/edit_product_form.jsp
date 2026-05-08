<%@page isELIgnored="false" %>

<%@taglib uri="http://www.springframework.org/tags/form"  prefix="frm"%>

<frm:form action="edit" method="post" modelAttribute="pvo">

<table align="center" bgcolor="yellow" >

<tr> 
	 <td>ProductId:</td> 
	 <td> <frm:input path="pid" />   </td> 
</tr>

<tr>
		<td>ProductName:</td>
		<td> <frm:input path="pname"/>   </td>
</tr>


<tr>
		<td>ProductPrice:</td>
		<td> <frm:input path="pprice"/> </td>

</tr>


<tr>
		<td>ProductCountry</td>
		<td> <frm:input path="pcountry"/> </td>
</tr>

<tr>
		<td> <input type="submit"  value="ConfirmTheEdits">  </td>
		
		<td> <input type="reset"  value="RestTheEdits">  </td>
</tr>

</table>

</frm:form>