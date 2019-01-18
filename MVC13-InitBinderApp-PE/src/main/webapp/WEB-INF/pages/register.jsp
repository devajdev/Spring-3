<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<h1 style="color:red;text-align:center">Date Editors </h1>

<form:form commandName="regCmd" method="POST">
   <form:errors path="*"/>
   name ::  <form:input path="name"/> <br>
   DOB ::<form:input path="dob"/> (dd-MM-yyyy)<br>
   DOJ :: <form:input path="doj"/>(dd-MM-yyyy) <br>
   DOM :: <form:input path="dom"/>(dd-MM-yyyy) <br>
   <input type="submit"  value="register">
</form:form>




