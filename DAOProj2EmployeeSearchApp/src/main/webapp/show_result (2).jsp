<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
  <c:when test="${!empty listEmps}">
    <table border="1" style="color:red">
      <tr> <th>EmpNo</th><th>EmpName</th><th>EmpDesg</th><th>EmpSalary</th></tr>
      <c:forEach var="map" items="${listEmps}">
        <tr>
          <td>${map.EMPNO}</td>
          <td>${map.ENAME}</td>
          <td>${map.JOB}</td>
          <td>${map.SAL}</td>
        </tr>
      </c:forEach>
    </table>
  </c:when>
  <c:otherwise>
     <h1 style="color:red;text-align:center">Records not found </h1>
  </c:otherwise>
</c:choose>
 