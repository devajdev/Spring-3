<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

 <form:form modelAttribute="userCmd" method="POST">
   <p style="color:red">
     <form:errors path="*"/>
   </p> <br>
   username :: <form:input path="username"/> <br>
   password :: <form:input path="password"/> <br>
   age :: <form:input path="age"/> <br>
   Domain :: <form:select path="domain">
               <form:options items="${dynaDomains}"/>
             </form:select> <br>
   lanagues ::<form:checkboxes items="${dynaLanguages}" path="languages"/>
   <br>
    DOB  :: <form:input path="dob"/> (dd-MM-yyyy)                
   <br>          
   <input type="submit"  value="Login"/>
 </form:form>

<c:if test="${!empty result }"> 
  <h1 style='color:red;text-align:center'>Result is :: ${result} </h1>
</c:if>
<br>
<br>
<c:if test="${!empty cmdData }"> 
  form data::: ${cmdData} </h1>
</c:if>




 

