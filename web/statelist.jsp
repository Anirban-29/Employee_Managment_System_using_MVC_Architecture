<%-- 
    Document   : statelist
    Created on : Feb 13, 2023, 11:53:01 AM
    Author     : anich
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<option value="">Select State</option>
<c:forEach items="${ProvinceList}" var="country" >
    <option value=${country.getStateid()}<c:if test="${country.getStateid().equalsIgnoreCase(emp.getStateCode())}" > selected </c:if>> ${country.getName()} </option>
</c:forEach>
