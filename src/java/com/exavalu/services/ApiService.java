/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.User;
import com.exavalu.utils.JDBCUtility;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author anich
 */
public class ApiService {

    public static ApiService apiService = null;

    public static ApiService getInstance() {
        if (apiService == null) {
            return new ApiService();
        } else {
            return apiService;
        }
    }

    public ArrayList getAllData() throws Exception {
        JDBCUtility jdbcUtility = JDBCUtility.getInstanceOfJDBCUtility();
        String apiUrl = jdbcUtility.getPropertyValue("apiUrl");

        URL obj = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");
        //add request header
        con.setRequestProperty("Accept", "application/json");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + apiUrl);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        int c = 0;
        ArrayList userList = new ArrayList<>();
        JSONParser parse = new JSONParser();
        while ((inputLine = in.readLine()) != null) {

            response.append(inputLine);
        }
        JSONArray jsonArray = (JSONArray) parse.parse(response.toString());
        for(int i=0;i<jsonArray.size();i++)
        {
            JSONObject myResponse=(JSONObject) jsonArray.get(i);
            User user = new User();
            user.setEmailAddess(myResponse.get("email").toString());
            user.setFirstName(myResponse.get("firstName").toString());
            user.setLastName(myResponse.get("lastName").toString());
            user.setPassword(myResponse.get("password").toString());
            user.setCountryCode(Long.toString((Long) myResponse.get("countryId")));
            user.setStateCode(Long.toString((Long) myResponse.get("stateId")));
            user.setDistCode(Long.toString((Long) myResponse.get("distId")));
            userList.add(user);
        }

        in.close();

        //print in String
        System.out.println(c);
        System.out.println(userList.size());

        System.out.println(response.toString().substring(1));
        return userList;
    }
}

        //Read JSON response and print
//        JSONObject myResponse = new JSONObject(response.toString());
//        System.out.println("result after Reading JSON Response");
//        System.out.println("origin- " + myResponse.getString("firstName"));
//        User user = new User();
//        user.setEmailAddess(myResponse.getString("email"));
//        user.setFirstName(myResponse.getString("firstName"));
//        user.setLastName(myResponse.getString("lastName"));
//        user.setPassword(myResponse.getString("password"));
//        user.setCountryCode(Integer.toString(myResponse.getInt("countryId")));
//        user.setStateCode(Integer.toString(myResponse.getInt("distId")));
//        user.setDistCode(Integer.toString(myResponse.getInt("stateId")));
//        return user;
 
//        try {
//            URL url = new URL(apiUrl);
//
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//
//            conn.setRequestMethod("GET");
//
//            conn.setRequestProperty("Accept", "application/json");
//
//            BufferedReader br = new BufferedReader(
//                    new InputStreamReader(conn.getInputStream()));
//
//            String inputLine;
//            StringBuffer resp = new StringBuffer();
//            while ((inputLine = br.readLine()) != null) {
//                resp.append(inputLine);
//            }
//            br.close();
//            System.out.println(resp);
//            //print in String
//            System.out.println(resp.toString());
//            //Read JSON response and print
//            JSONObject myResponse = new JSONObject(resp.toString());
//
//        } catch (MalformedURLException ex) {
//            Logger.getLogger(ApiService.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(ApiService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

