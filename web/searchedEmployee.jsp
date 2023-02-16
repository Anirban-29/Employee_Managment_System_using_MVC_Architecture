<%-- 
    Document   : searchedEmployee
    Created on : Feb 14, 2023, 11:44:31 PM
    Author     : anich
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table id="example" class="table table-striped border">
    <thead>
        <tr class="backgroud_colorha">
            <th>
                Employee Id
            </th>
            <th>
                First Name
            </th>
            <th>
                Last Name
            </th>
            <th>
                Phone Number
            </th>
            <th>
                Gender
            </th>
            <th>
                Age
            </th>
            <th>
                Department Name
            </th>
            <th>
                Role Name
            </th>
            <th>
                Basic Salary
            </th>
            <th>
                Allowance
            </th>
            <th>
                Action
            </th>
        </tr>
    </thead>
    <c:forEach items="${empList}" var="emp">
        <tbody>

            <tr>
                <td>
                    ${emp.getEmployeeId()}
                </td>
                <th scope="row">
                    ${emp.getFirstName()}                    </th>
                <th scope="row">
                    ${emp.getLastName()}                    </th>
                <td>
                    ${emp.getPhone()}                    </td>
                <td>
                    ${emp.getGender()}                    </td>
                <td>
                    ${emp.getAge()}                    </td>
                <td>
                    ${emp.getDepNamw()}                    </td>
                <td>
                    ${emp.getRoleNamw()}                    </td>
                <td>
                    ${emp.getSalary()}                    </td>
                <td>
                    ${emp.getAllowance()}                    </td>
                <td> 
                    <a href=Edit?employeeId=${emp.getEmployeeId()}>
                        Edit</a>                     
                </td>
            </tr>
        </tbody>

    </c:forEach>

</table>


