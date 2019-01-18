<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<h1 style="color:red;text-align:center">Naukri.com Registration Page No::2</h1>
<p style="text-align:center">
<form:form method="POST"  commandName="regCmd">
   Domain  :: <form:input path="domain"/><br>
   Curent Salary  ::<form:input path="currentSalary"/><br>
   experience  ::<form:input path="experience"/><br>
    <input type="submit" name="_target0" value="previous">
   <input type="submit" name="_target2" value="next">
   <input type="submit" name="_cancel" value="cancel">
</form:form>
</p>

