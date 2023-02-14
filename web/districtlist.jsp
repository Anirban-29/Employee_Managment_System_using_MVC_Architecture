<%-- 
    Document   : districtlist
    Created on : Feb 13, 2023, 1:29:06 PM
    Author     : anich
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<option value="">Select District</option>
<c:forEach items="${DistrictList}" var="district" >
    <option value=${district.getId()}<c:if test="${district.getId().equalsIgnoreCase(emp.getDistCode())}" > selected </c:if>> ${district.getName()} </option>
</c:forEach>
