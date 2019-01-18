<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<h1 style="color:red;text-align:center">Naukri.com Registration Page No::1</h1>
<p style="text-align:center">
<form:form method="POST"  commandName="regCmd">
   name  :: <form:input path="name"/><br>
   address ::<form:input path="addrs"/><br>
   age  ::<form:input path="age"/><br>
   <input type="submit" name="_target1" value="next">
   <input type="submit" name="_cancel" value="cancel">
</form:form>
</p>

