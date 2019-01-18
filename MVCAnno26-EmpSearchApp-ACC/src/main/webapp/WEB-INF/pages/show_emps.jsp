<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<c:choose>
  <c:when test="${!empty listRDTO}">
    <table border="1" bgcolor="cyan">
      <tr><th>empno</th><th>empname</th><th>empDesg</th><th>empSalary</th><th>empManager</th><th>deptNo</th> </tr>
      <c:forEach var="dto" items="${listRDTO}">
         <tr>
           <td>${dto.eid}</td>
           <td>${dto.ename}</td>
           <td>${dto.desg}</td>
           <td>${dto.salary}</td>
           <td>${dto.mgrNo}</td>
           <td>${dto.deptNo}</td>
         </tr>
      </c:forEach>
    </table>
  </c:when>
  <c:otherwise>
    <b><i>No Records found</i></b>
  </c:otherwise>
</c:choose>
<br><br>
 <a href="home.htm">home</a>

