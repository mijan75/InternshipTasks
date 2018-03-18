/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clientapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mijanur
 */
public class Main {
    FeesCollection feesCollection;
    public Main() {
        readOneFeesCollection("2");
        
    }
    
    public void readOneFeesCollection(String id){
        try {
            URL url = new URL("http://localhost:8080/students/"+id);
            ObjectMapper objectMapper = new ObjectMapper();
            feesCollection = objectMapper.readValue(url, FeesCollection.class);
            System.out.println(feesCollection);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            URL url = new URL("http://localhost:8080/students/student");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            
            Map<String, String> parameterMap = new HashMap<>();
            String fid = feesCollection.getId();
            String feesAmount = "0";
            String fees_status = feesCollection.getFeesStatus();
            String paidAmount = feesCollection.getPaidAmount()+"";
            String dueAmount = feesCollection.getDueAmount()+"";
            parameterMap.put("id", fid);
            parameterMap.put("feesAmount", feesAmount);
            parameterMap.put("feeStatus", fees_status);
            parameterMap.put("paidAmount", paidAmount);
            parameterMap.put("dueAmount", dueAmount);
            
            StringBuilder builder = new StringBuilder();
            parameterMap.forEach((key, value) ->{
                if(builder.length() > 0)
                    builder.append('&');
                builder.append(key);
                builder.append('=');
                builder.append(value);
            });
            String parameters = builder.toString();
            System.out.println(parameters);
            connection.getOutputStream().write(parameters.getBytes());
                        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;

            while ((line = reader.readLine()) != null)
                System.out.println(line);
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("I ok");
    }
    
    
    public static void main(String arg[]){
        new Main();
    }
}
