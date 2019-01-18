<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<h1 style="color:red;text-align:center">Student Registation Page</h1>

<script language="JavaScript" src="validation.js">
   
</script>

<form:form  method="POST" commandName="stCmd" onsubmit="return validate(this)" >
    <%-- <p style='color:red'><form:errors path="*"/> </p> --%>
   Student name :: <form:input path="sname"/> <form:errors  path="sname" /><span id="sname.err"></span> <br>
   Student Address :: <form:input path="sadd"/> <form:errors path="sadd"/><span id="sadd.err"></span><br>
   Student Course :: <form:input path="course"/> <form:errors path="course"/><span id="course.err"></span> <br>
   Studen age :: <form:input path="age"/><form:errors path="age"/> <br> 
   <form:hidden path="vflag"  /> <br>
   <input type="submit"  value="register">
</form:form>

<style type="text/css">
 span{color:red;font-size:10px}

</style>