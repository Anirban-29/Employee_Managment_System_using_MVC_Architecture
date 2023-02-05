
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.exavalu.services.EmployeeService"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="user" value = "${Loggedin}"></c:set>
<c:if test="${user == null}">
    <c:redirect url="login.jsp"></c:redirect>
</c:if>
<!doctype html>
<html lang="en">

    <title>Employee Management</title>
    <link rel="canonical" href="https://getbootstrap.com/docs/5.3/examples/product/">

    <!-- Favicons -->
    <link rel="apple-touch-icon" href="/docs/5.3/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
    <link rel="icon" href="/docs/5.3/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
    <link rel="icon" href="/docs/5.3/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
    <link rel="manifest" href="/docs/5.3/assets/img/favicons/manifest.json">
    <link rel="mask-icon" href="/docs/5.3/assets/img/favicons/safari-pinned-tab.svg" color="#712cf9">
    <link rel="icon" href="/docs/5.3/assets/img/favicons/favicon.ico">
    <meta name="theme-color" content="#712cf9">
    <!-- Custom styles for this template -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/menu_css.css" rel="stylesheet">
    <link href="css/product.css" rel="stylesheet">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.2.0/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.1/css/dataTables.bootstrap5.min.css"/>
    <style>
        #example_wrapper{
            width: 75%;
            display: block;
            margin: auto;
        }
    </style>



    <body>

        <jsp:include page="menu.jsp"></jsp:include>


        <c:set var="msg" value="${Success}"></c:set>
        <c:if test="${msg != null}" >
            <div class="alert alert-success " role="alert">

                <c:out value="${msg}"></c:out>
                </div>

            
        </c:if>       
        <h2> Employee List:</h2>


        <table id="example" class="table table-striped border">
            <thead>
                <tr class="backgroud_color">
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
                        Edit
                    </th>
                    <th>
                        Delete
                    </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${EmpList}" var="emp">
                    <tr>
                        <td>
                            <input hidden="" name="employeeId" class="form-control" id="floatingInput" value="${emp.getEmployeeId()}">

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
                            <a href='Edit?employeeId=<c:out value="${emp.getEmployeeId()}"> </c:out>'>Edit</a>
                            </td>
                            <td>
                                <a href='Delete?employeeId=<c:out value="${emp.getEmployeeId()}"> </c:out>'>Delete</a>
                            </td>
                        </tr>

                </c:forEach>
              </tbody>
        </table>


        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.13.1/js/dataTables.bootstrap5.min.js"></script>
        <script>
            $(document).ready(function () {
                $('#example').DataTable();
            });
        </script>
        <!--<script src="/docs/5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>-->
    </body>
</html>