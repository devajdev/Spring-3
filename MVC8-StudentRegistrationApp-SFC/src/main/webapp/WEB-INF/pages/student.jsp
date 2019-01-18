<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<h1 style="color:red;text-align:center">Student Registation Page</h1>

<form:form  method="GET" commandName="stCmd">
   Student name :: <form:input path="sname"/> <br>
   Student Address :: <form:input path="sadd"/> <br>
   Student Course :: <form:input path="course"/> <br>
   <input type="submit"  value="register">
</form:form>