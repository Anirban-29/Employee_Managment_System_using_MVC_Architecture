/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.Role;
import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



/**
 *
 * @author anich
 */
public class RoleService  {
    public static RoleService roleService = null;
    
    public static RoleService getInstance()
    {
        if(roleService==null)
        {
            return new RoleService();
        }
        else
        {
            return roleService;
        }
    }

    public ArrayList getAllRole() {
        ArrayList rolList = new ArrayList<>();
        try{
        Connection con = JDBCConnectionManager.getConnection();
        
        String sql="select * from roles";
        PreparedStatement preparedStatement=con.prepareStatement(sql);
        
        ResultSet rs=preparedStatement.executeQuery();
        
        while(rs.next())
        {
            Role r=new Role();
            r.setRoleId(rs.getInt("roleId"));
            r.setRoleName(rs.getString("roleName"));
            
            rolList.add(r);
        }
        }
        catch(SQLException ex)
        {
            
        }
            
        return rolList;
    }

   
  }