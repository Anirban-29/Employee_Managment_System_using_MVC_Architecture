/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.Employee;
import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Avijit Chattopadhyay
 */
public class EmployeeService {

    public static EmployeeService employeeService = null;

    public static EmployeeService getInstance() {
        if (employeeService == null) {
            return new EmployeeService();
        } else {
            return employeeService;
        }
    }

    public ArrayList getAllEmployees() {
        ArrayList empList = new ArrayList();
        String sql = "SELECT  employeeId,firstName,lastName,phone,gender,age,departmentName,roleName,salary,allowance,status FROM employee LEFT JOIN roles On employee.roleId= roles.roleId LEFT JOIN departments On employee.depId= departments.departmentId";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println(rs);

            while (rs.next()) {
                Employee emp = new Employee();
                if(rs.getString("status").equals("0"))
                {
                emp.setEmployeeId(rs.getString("employeeId"));
                emp.setFirstName(rs.getString("firstName"));
                emp.setLastName(rs.getString("lastName"));
                emp.setPhone(rs.getString("phone"));
                emp.setGender(rs.getString("gender"));
                emp.setAge(rs.getString("age"));
                emp.setDepNamw(rs.getString("departmentName"));
                emp.setRoleNamw(rs.getString("roleName"));
                emp.setSalary(rs.getString("salary"));
                emp.setAllowance(rs.getString("allowance"));

                empList.add(emp);
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.err.println("Total rows:" + empList.size());
        return empList;
    }

    public boolean editEmployee(Employee emp) {
        boolean result = false;
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "UPDATE employeedb.employee\n"
                    + "SET firstName = ? , lastName = ? , phone = ? ,\n"
                    + "gender = ? , age = ? , salary = ?,allowance = ?,depId=?,roleId=?\n"
                    + "WHERE employeeId = ?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, emp.getFirstName());
            preparedStatement.setString(2, emp.getLastName());
            preparedStatement.setString(3, emp.getPhone());

            preparedStatement.setString(4, emp.getGender());
            preparedStatement.setString(5, emp.getAge());
            preparedStatement.setDouble(6, Double.parseDouble(emp.getSalary()));
            preparedStatement.setDouble(7, Double.parseDouble(emp.getAllowance()));
            preparedStatement.setString(8, emp.getDepId());
            preparedStatement.setString(9, emp.getRoleId());

            preparedStatement.setString(10, emp.getEmployeeId());
            System.out.println(preparedStatement);
            int row = preparedStatement.executeUpdate();

            if (row == 1) {
                result = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public Employee getEmployee(String Id) {
        Employee emp = new Employee();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from employee e, departments d, roles r "
                    + "where e.depId=d.departmentId and e.roleId=r.roleId and e.employeeId =?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, Id);

            ResultSet rs = preparedStatement.executeQuery();
            System.out.print(preparedStatement);
            while (rs.next()) {
                emp.setEmployeeId(rs.getString("employeeId"));
                emp.setFirstName(rs.getString("firstName"));
                emp.setLastName(rs.getString("lastName"));
                emp.setPhone(rs.getString("phone"));
                emp.setGender(rs.getString("gender"));
                emp.setAge(rs.getString("age"));
                emp.setDepNamw(rs.getString("departmentName"));
                emp.setRoleNamw(rs.getString("roleName"));
                emp.setSalary(rs.getString("salary"));
                emp.setAllowance(rs.getString("allowance"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return emp;
    }

    public ArrayList searchEmployee(Employee emp) {
        ArrayList empList = new ArrayList<>();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from employee e, departments d, roles r where e.depId=d.departmentId and e.roleId=r.roleId "
                    + "having firstName like ? and lastName like ? and gender like ? and departmentId like ? and e.roleId like ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            System.out.println(emp.getFirstName());
            preparedStatement.setString(1, emp.getFirstName() + "%");
            preparedStatement.setString(2, emp.getLastName() + "%");
            preparedStatement.setString(3, emp.getGender() + "%");
            preparedStatement.setString(4, emp.getDepId() + "%");
            preparedStatement.setString(5, emp.getRoleId() + "%");
            System.out.println("Prepared statement = " + preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Employee emp1 = new Employee();
                emp1.setEmployeeId(rs.getString("employeeId"));
                emp1.setFirstName(rs.getString("firstName"));
                emp1.setLastName(rs.getString("lastName"));
                emp1.setPhone(rs.getString("phone"));
                emp1.setGender(rs.getString("gender"));
                emp1.setAge(rs.getString("age"));
                emp1.setDepId(rs.getString("departmentId"));
                emp1.setDepNamw(rs.getString("departmentName"));

                emp1.setRoleId(rs.getString("roleId"));
                emp1.setRoleNamw(rs.getString("roleName"));

                emp1.setSalary(rs.getString("salary"));
                emp1.setAllowance(rs.getString("allowance"));

                empList.add(emp1);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return empList;

    }

    public boolean addnewEmployee(Employee emp) {
        boolean result = false;

        try {
            Connection con = JDBCConnectionManager.getConnection();

            String sql = "INSERT INTO employee (firstName,lastName,phone,gender,age,depId,roleId,salary,allowance)"
                    + "VALUES(?,?, ? ,? ,? ,?,? ,? ,? )";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, emp.getFirstName());
            preparedStatement.setString(2, emp.getLastName());
            preparedStatement.setString(3, emp.getPhone());

            preparedStatement.setString(4, emp.getGender());
            preparedStatement.setString(5, emp.getAge());
            preparedStatement.setDouble(8, Double.parseDouble(emp.getSalary()));
            preparedStatement.setDouble(9, Double.parseDouble(emp.getAllowance()));
            preparedStatement.setString(6, emp.getDepId());
            preparedStatement.setString(7, emp.getRoleId());
            System.out.println(preparedStatement);
            int row = preparedStatement.executeUpdate();

            if (row == 1) {
                result = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public boolean deleteEmployee(String id) {
        boolean result = false;
        try {
            Connection con = JDBCConnectionManager.getConnection();

            String sql = "Update employee Set status=1 WHERE employeeId = ?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, id);
            System.out.println(preparedStatement);
            int row = preparedStatement.executeUpdate();
            if (row != 0) {
                result = true;
            }

        } catch (SQLException ex) {

        }
        return result;

    }

}
