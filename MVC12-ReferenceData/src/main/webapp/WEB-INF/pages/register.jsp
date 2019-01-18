<%@ page isELIgnored="false" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
 <form:form  method="POST" commandName="regCmd">
   <p style="color:red">
     <form:errors path="*"/>
     </p> <br>
    name :: <form:input path="name"/><br>
    Courses:: <form:select path="courses" multiple="true">
                   <form:options items="${courses}"/>
               </form:select> <br>
    Hobies ::  <form:checkboxes items="${hobies}" path="hobies"/> <br>
    Country ::  <form:select path="country">
                   <form:options items="${countries}"/>
                 </form:select> <br>              
    <input type="submit" value="register"/>
 </form:form>





