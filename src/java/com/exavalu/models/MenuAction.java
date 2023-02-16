/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.exavalu.models;

/**
 *
 * @author anich
 */
public class MenuAction {

    private String work;

   
    public String getAllEmployee() throws Exception {
        String result = "FALIURE";
        System.out.print(this.work);
        if(this.work.equals("show"))
        {
            result="SHOW";
        }
        else if (this.work.equals("search"))
        {
            result="SEARCH";
        }
        else if (this.work.equals("add"))
        {
            result="ADD";
        }
        
        
        return result;

    }

    /**
     * @return the work
     */
    public String getWork() {
        return work;
    }

    /**
     * @param work the work to set
     */
    public void setWork(String work) {
        this.work = work;
    }

}
