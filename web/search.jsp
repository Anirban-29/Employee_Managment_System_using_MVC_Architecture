<%-- 
    Document   : search
    Created on : Jan 24, 2023, 1:13:08 PM
    Author     : anich
--%>

<%@page import="com.exavalu.services.RoleService"%>
<%@page import="com.exavalu.services.DepartmentService"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="user" value = "${Loggedin}"></c:set>

<c:if test="${user == null}">
    <c:redirect url="login.jsp"></c:redirect>
</c:if>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Hugo 0.108.0">
        <title>Employee Management Data Update</title>
        <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/sign-in/">

        <!-- Favicons -->
        <link rel="apple-touch-icon" href="/docs/5.3/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
        <link rel="icon" href="/docs/5.3/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
        <link rel="icon" href="/docs/5.3/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
        <link rel="manifest" href="/docs/5.3/assets/img/favicons/manifest.json">
        <link rel="mask-icon" href="/docs/5.3/assets/img/favicons/safari-pinned-tab.svg" color="#712cf9">
        <link rel="icon" href="/docs/5.3/assets/img/favicons/favicon.ico">
        <meta name="theme-color" content="#712cf9">


        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/menu_css.css" rel="stylesheet">
        <link href="css/product.css" rel="stylesheet">
        <!--        <link href="css/sign-in.css" rel="stylesheet">-->
        <link rel="stylesheet" href="css/search_css.css">



    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
            <h1>Search Employee</h1>
            <form action="Search" method="post" class="form_style">
                <div class="filed_style">
                    <label for="floatingInput">First Name</label>
                    <input type="text" class="" id="floatingInput" placeholder="Search FirstName wise" name="firstName">

                </div>
                <div class="filed_style">
                    <label for="floatingInput">Last Name</label>
                    <input type="text" class="" id="floatingInput" placeholder="Search LastName wise" name="lastName" value="">
                </div>
                <div class="filed_style">
                    <label for="gender">Gender</label>

                    <select name="gender"  id="gender" >
                        <option value="">Select Gender</option>
                        <option value="Male">Male</option>  
                        <option value="Female">Female</option> 
                        <option value="Other">Other</option> 
                    </select>
                </div>

                <div class="filed_style">
                <label for="departmentId">Department</label>
                <select name="depId" class="form-select" id="departmentId">
                    <option value="">Select Department </option>
                    <c:forEach var="dept" items="${DeptList}">
                        <option value=${dept.getDepartmentId()} >${dept.getDepartmentName()}  </option>
                    </c:forEach>

                </select>
            </div>

            <div class="filed_style">
                <label for="floatingInput">Role</label>
                <select name="roleId" class="form-select" id="roleId">
                    <option value="">Select Role </option>
                   <c:forEach var="rol" items="${RoleList}">
                    <option value=${rol.getRoleId()} >${rol.getRoleName()}  </option>
                    </c:forEach>
                </select>
            </div>
            <button class="filed_style" type="submit">Search</button>
        </form>

        <c:if test="${empList != null}" >
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
            <tbody>
                <c:forEach items="${empList}" var="emp">
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
                            <a href=EditEmployee?employeeId=${emp.getEmployeeId()}>
                                Edit</a>                     
                        </td>
                    </tr>

                </c:forEach>

            </tbody>
        </table>
        </c:if>


    </body>
</html>
