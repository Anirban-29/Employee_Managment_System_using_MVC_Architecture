/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;

import com.exavalu.services.EmployeeService;
import com.exavalu.services.LoginService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Avijit Chattopadhyay
 */
public class Employee extends ActionSupport implements ApplicationAware, SessionAware, Serializable {

    private String employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private String phone;
    private String gender;
    private String age;
    private String depId;
    private String roleId;
    private String salary;
    private String allowance;
    private String empcount;
    private String depNamw;
    private String roleNamw;
    private int status;

    private SessionMap<String, Object> sessionMap = (SessionMap) ActionContext.getContext().getSession();

    private ApplicationMap map = (ApplicationMap) ActionContext.getContext().getApplication();

    @Override
    public void setApplication(Map<String, Object> application) {
        setMap((ApplicationMap) application);
    }

    @Override
    public void setSession(Map<String, Object> session) {
        setSessionMap((SessionMap<String, Object>) (SessionMap) session);
    }

    /**
     * @return the employeeId
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId the employeeId to set
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the age
     */
    public String getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * @return the depId
     */
    public String getDepId() {
        return depId;
    }

    /**
     * @param depId the depId to set
     */
    public void setDepId(String depId) {
        this.depId = depId;
    }

    /**
     * @return the roleId
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * @param roleId the roleId to set
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * @return the salary
     */
    public String getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(String salary) {
        this.salary = salary;
    }

    /**
     * @return the allowance
     */
    public String getAllowance() {
        return allowance;
    }

    /**
     * @param allowance the allowance to set
     */
    public void setAllowance(String allowance) {
        this.allowance = allowance;
    }

    /**
     * @return the empcount
     */
    public String getEmpcount() {
        return empcount;
    }

    /**
     * @param empcount the empcount to set
     */
    public void setEmpcount(String empcount) {
        this.empcount = empcount;
    }

    /**
     * @return the depNamw
     */
    public String getDepNamw() {
        return depNamw;
    }

    /**
     * @param depNamw the depNamw to set
     */
    public void setDepNamw(String depNamw) {
        this.depNamw = depNamw;
    }

    /**
     * @return the roleNamw
     */
    public String getRoleNamw() {
        return roleNamw;
    }

    /**
     * @param roleNamw the roleNamw to set
     */
    public void setRoleNamw(String roleNamw) {
        this.roleNamw = roleNamw;
    }

    /**
     * @return the sessionMap
     */
    public SessionMap<String, Object> getSessionMap() {
        return sessionMap;
    }

    /**
     * @param sessionMap the sessionMap to set
     */
    public void setSessionMap(SessionMap<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }

    /**
     * @return the map
     */
    public ApplicationMap getMap() {
        return map;
    }

    /**
     * @param map the map to set
     */
    public void setMap(ApplicationMap map) {
        this.map = map;
    }

    public String doEdit() throws Exception {
        String result = "FAILURE";
        System.out.println(this.getEmployeeId());
        Employee emp = EmployeeService.getInstance().getEmployee(this.getEmployeeId());

        if (this != null) {
            sessionMap.put("Emp", emp);
            System.out.println("returning Employee");
            System.out.println(sessionMap);
            System.out.println(emp.getFirstName());

            result = "SUCCESS";
        } else {
            System.out.println("returning Failure from doLogin method");
        }

        return result;
    }

    public String delete() throws Exception {
        String result = "FAILURE";
        System.out.println(this.getEmployeeId());
        boolean success = EmployeeService.getInstance().deleteEmployee(this.getEmployeeId());
        if (success) {
            ArrayList empList = EmployeeService.getInstance().getAllEmployees();
            sessionMap.put("EmpList", empList);
            result = "SUCCESS";
        }
        return result;
    }

    public String saveEmployee() throws Exception {
        String result = "FAILURE";
        boolean success = EmployeeService.getInstance().editEmployee(this);

        if (success) {
            System.out.println("returning success from editemployee method");
            ArrayList empList = EmployeeService.getInstance().getAllEmployees();
            sessionMap.put("EmpList", empList);
            result = "SUCCESS";
        } else {
            System.out.println("returning Failure from editemployee method");
        }

        return result;
    }

    public String findEmployee() throws Exception {
        String result = "FAILURE";
        ArrayList empList = EmployeeService.getInstance().searchEmployee(this);
                    System.out.println(empList.size());


        if (!empList.isEmpty()) {
            System.out.println("returning success from findemployee method");
            sessionMap.put("empList", empList);

            result = "SUCCESS";
        } else {
            System.out.println("returning Failure from findemployee method");
        }

        return result;
    }

    public String addEmployee() throws Exception {
        String result = "FAILURE";
       
        boolean success = EmployeeService.getInstance().addnewEmployee(this);

        if (success) {
            System.out.println("returning success from addemployee method");
            String msg = "Data Added to the table";
            ArrayList empList = EmployeeService.getInstance().getAllEmployees();
            sessionMap.put("EmpList", empList);
            sessionMap.put("Success", msg);
            System.out.println(sessionMap);
            result = "SUCCESS";
        } else {
            System.out.println("returning Failure from addemployee method");
            String errormsg = "Data not Added to the table";
            sessionMap.put("Failur", errormsg);

        }

        return result;
    }
    public String newADD() throws Exception {
        String result = "FAILURE";
        boolean success=true;
        if (success) {
            
            if(sessionMap.containsKey("empList"))
            {
                sessionMap.remove("empList");
            }
            System.out.println(sessionMap);
            result = "SUCCESS";
        } else {
            System.out.println("returning Failure from addemployee method");
            String errormsg = "Data not Added to the table";
            sessionMap.put("Failur", errormsg);

        }

        return result;
    }

}
