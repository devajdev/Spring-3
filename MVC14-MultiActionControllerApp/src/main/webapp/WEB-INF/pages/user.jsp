<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<h1 style="color:red;text-align:center">MultiActionControler App</h1>

<form action="curd.htm"  method="POST">
   userId ::<input type="text" name="userId"><br>
   userName ::<input type="text" name="uname"><br>
   Address ::<input type="text" name="addrs"><br>
   Email Id ::<input type="text" name="mail"><br> <br>
   <input type="submit" name="p1" value="insert"> 
   <input type="submit" name="p1" value="update"> 
   <input type="submit" name="p1" value="delete"> 
   <input type="submit" name="p2" value="view"> 
</form>

<br><br>
   ${operation } is performed.

