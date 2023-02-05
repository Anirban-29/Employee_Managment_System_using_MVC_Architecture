<%-- 
    Document   : editemployee
    Created on : Jan 23, 2023, 12:20:01 PM
    Author     : anich
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <link href="css/sign-in.css" rel="stylesheet">

    </head>
    <body class="text-center">
        <jsp:include page="menu.jsp"></jsp:include>
            <main class="form-signin w-100 m-auto">

                <form action="Update" method="post">
                    <h1 class="h3 mb-3 fw-normal">Please Update Details</h1>
                    <div class="form-floating">
                        <input type="text" class="form-control" id="floatingInput" placeholder="employeeId" name="employeeId" value=${Emp.employeeId} readonly>
                    <label for="floatingInput">Employee Id</label>
                </div>

                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="firstName" name="firstName" value=${Emp.getFirstName()} >
                    <label for="floatingInput">First Name</label>
                </div>

                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="lastName" name="lastName" value=${Emp.getLastName()}>
                    <label for="floatingInput">Last Name</label>
                </div>

                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="phone" name="phone" value=${Emp.getPhone()}>
                    <label for="floatingInput">Phone</label>
                </div>

                <div class="form-floating">

                    <select name="gender"  class="form-select" id="gender" required>

                        <option value="Male">Male</option>  
                        <option value="Female">Female</option> 
                        <option value="Other">Other</option> 
                    </select>
                    <label for="floatingInput">Gender</label>

                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="floatingInput" placeholder="age" name="age" value=${Emp.getAge()}>
                    <label for="floatingInput">age</label>
                </div>

                <div class="form-floating">

                    <div class="form-floating">
                        <select name="depId" class="form-select" id="departmentId" required>
                            <c:forEach items="${DeptList}" var="dept" >
                                <option value=${dept.getDepartmentId()}<c:if test="${dept.getDepartmentName().equalsIgnoreCase(Emp.getDepNamw())}" > selected </c:if>> ${dept.getDepartmentName()} </option>
                            </c:forEach>
                        </select>
                        <label for="floatingInput">Department</label>
                    </div>
                </div>

                <div class="form-floating">                  

                        <select name="roleId" class="form-select" id="roleId">
                            <c:forEach items="${RoleList}" var="rol" >
                                <option value=${rol.getRoleId()}<c:if test="${rol.getRoleName().equalsIgnoreCase(Emp.getRoleNamw())}" > selected </c:if> > ${rol.getRoleName()}</option>
                            </c:forEach>
                            </select>
                            <label for="floatingInput">Role Name</label>
                        </div>
                        <div class="form-floating">
                            <input type="text" class="form-control" id="floatingInput" placeholder="salary" name="salary" value=${Emp.getSalary()}>
                        <label for="floatingInput">Salary</label>
                    </div>

                    <div class="form-floating">
                        <input type="text" class="form-control" id="floatingInput" placeholder="allowance" name="allowance" value=${Emp.getAllowance()}>
                        <label for="floatingInput"> Allowance</label>
                    </div>



                    <button class="w-100 btn btn-lg btn-primary" type="submit">Save</button>

                    <p class="mt-5 mb-3 text-muted">&copy; 2023-2024 </p>
                </form>
            </main>

        </body>
    </html>