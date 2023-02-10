/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.exavalu.models;

import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.util.Map;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author anich
 */
public class Province extends ActionSupport implements ApplicationAware, SessionAware, Serializable {

    /**
     * @param args the command line arguments
     */
    private String stateid;
    private String name;
    private String distId;
    private String coutryid;

  

    @Override
    public void setApplication(Map<String, Object> map) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setSession(Map<String, Object> map) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * @return the stateid
     */
    public String getStateid() {
        return stateid;
    }

    /**
     * @param stateid the stateid to set
     */
    public void setStateid(String stateid) {
        this.stateid = stateid;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the distId
     */
    public String getDistId() {
        return distId;
    }

    /**
     * @param distId the distId to set
     */
    public void setDistId(String distId) {
        this.distId = distId;
    }

    /**
     * @return the coutryid
     */
    public String getCoutryid() {
        return coutryid;
    }

    /**
     * @param coutryid the coutryid to set
     */
    public void setCoutryid(String coutryid) {
        this.coutryid = coutryid;
    }
    

}
