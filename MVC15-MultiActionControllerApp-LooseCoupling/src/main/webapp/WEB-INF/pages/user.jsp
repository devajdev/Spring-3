<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<h1 style="color:red;text-align:center">MultiActionControler App</h1>

<form name="frm"  method="POST">
   userId ::<input type="text" name="userId"><br>
   userName ::<input type="text" name="uname"><br>
   Address ::<input type="text" name="addrs"><br>
   Email Id ::<input type="text" name="mail"><br> <br>
   <button value="add" onclick="sendRequest(this.value)">add</button>  
   <button value="modify" onclick="sendRequest(this.value)">modify</button>
   <button value="remove" onclick="sendRequest(this.value)">remove</button>
   <button value="show" onclick="sendRequest(this.value)">show</button>
</form>

<br><br>
  <c:if test="${!empty operation }">
   ${operation } is performed.
   </c:if>
 <br><br> 
 <c:if test="${!empty cmdData }">
   ${cmdData } 
   </c:if>  

<script language="JavaScript">
   function sendRequest(cap){
     if(cap=="add")
       frm.action="add.htm";
     else if(cap=="modify")
       frm.action="modify.htm";
     else if(cap=="remove")
       frm.action="remove.htm";
     else if(cap=="show")
       frm.action="show.htm";
     else
       frm.action="/invalid.htm"
     //submit the request
      frm.submit();
   }
</script>
