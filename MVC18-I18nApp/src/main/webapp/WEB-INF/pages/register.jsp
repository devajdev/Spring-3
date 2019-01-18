<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h1 style="color:red;text-align:center"><spring:message code="form.title" text="I18n App"/></h1>

<form:form method="POST" commandName="regCmd">
  <spring:message code="form.label1"/><form:input path="name"/> <br>
  <spring:message code="form.label2"/><form:input path="addrs"/> <br>
  <spring:message code="form.label3"/><form:input path="age"/> <br>
  <input type="submit" value="<spring:message code="btn.caption"/>"/>
</form:form>
 <br><br>
   <a href="?lang=fr_FR">french</a> &nbsp;&nbsp;&nbsp;
   <a href="?lang=de_DE">German</a> &nbsp;&nbsp;&nbsp;
   <a href="?lang=hi_IN">Hindi</a> &nbsp;&nbsp;&nbsp;
   
