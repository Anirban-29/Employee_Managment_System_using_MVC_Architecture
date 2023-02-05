<%-- 
    Document   : addEmployee
    Created on : Feb 2, 2023, 7:59:20 PM
    Author     : anich
--%>

<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="user" value = "${Loggedin}"></c:set>

<c:if test="${user == null}">
    <c:redirect url="login.jsp"></c:redirect>
</c:if>
<!DOCTYPE html>
<html lang="en">
    <head>,
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Add Employee</title>
        <link rel="stylesheet" href="css/addEmployee.css">
        <!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-Fo3rlrZj/k7ujTnHg4CGR2D7kSs0v4LLanw2qksYuRlEzO+tcaEPQogQ0KaoGN26/zrn20ImR1DfuLWnOo7aBA==" crossorigin="anonymous" referrerpolicy="no-referrer" /> -->

        <script src="https://kit.fontawesome.com/2bbac3a66c.js" crossorigin="anonymous" ></script>
    </head>
    <body>
        <form  id="create-account-form" action="Add" method="POST">

            <div class="title">
                <h2>Add Employee</h2>
            </div>
            <!-- USERNAME -->
            <div class="input-group">
                <label for="username">Name</label>
                <input type="text" id="firstname" placeholder="firstname" name="firstName">
                <i class="fas fa-check-circle"></i>
                <i class="fas fa-exclamation-circle"></i>
                <p>Error Message</p>
            </div>
            <div class="input-group">
                <label for="username">Last Name</label>
                <input type="text" id="lastname" placeholder="lastname" name="lastName">
                <i class="fas fa-check-circle"></i>
                <i class="fas fa-exclamation-circle"></i>
                <p>Error Message</p>
            </div>

            <div class="input-group">
                <label for="username">Phone</label>
                <input type="text" id="phone" placeholder="phone" name="phone">
                <i class="fas fa-check-circle"></i>
                <i class="fas fa-exclamation-circle"></i>
                <p>Error Message</p>
            </div>
            <div class="input-group">
                <label for="username">Gender</label>

                <select name="gender"  id="gender" required>
                    <option value="">Select Gender</option>
                    <option value="Male">Male</option>  
                    <option value="Female">Female</option> 
                    <option value="Other">Other</option> 
                </select>
            </div>
            <div class="input-group">
                <label for="username">Age</label>
                <input type="text" id="age" placeholder="age" name="age">
                <i class="fas fa-check-circle"></i>
                <i class="fas fa-exclamation-circle"></i>
                <p>Error Message</p>
            </div>
            <div class="form-floating">
                <select name="depId" class="form-select" id="departmentId" required>
                    <option value="">Select Department</option>
                    <c:forEach var="dept" items="${DeptList}">
                    <option value=${dept.getDepartmentId()} >${dept.getDepartmentName()}  </option>
                    </c:forEach>
                </select>
                <label for="floatingInput">Department</label>
            </div>
        </div>
        <div class="form-floating">
            <select name="roleId" class="form-select" id="roleId" required>
                <option value="">Select Role</option>
                 <c:forEach var="rol" items="${RoleList}">
                    <option value=${rol.getRoleId()} >${rol.getRoleName()}  </option>
                    </c:forEach>
            </select>
            <label for="floatingInput">Role</label>
        </div>
        <div class="input-group">
            <label for="username">Salary</label>
            <input type="text" id="salary" placeholder="salary" name="salary">
            <i class="fas fa-check-circle"></i>
            <i class="fas fa-exclamation-circle"></i>
            <p>Error Message</p>
        </div>
        <div class="input-group">
            <label for="username">Allowance</label>
            <input type="text" id="allowance" placeholder="allowance" name="allowance">
            <i class="fas fa-check-circle"></i>
            <i class="fas fa-exclamation-circle"></i>
            <p>Error Message</p>
        </div>

        <button type="submit" class="btn">Submit</button>
    </form>


    <!-- JAVASCRIPT -->
    <script src="js/app.js"></script>
</body>
</html>

