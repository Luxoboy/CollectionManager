/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luxoboy.collectionmanager.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONObject;

/**
 *
 * @author Anthony Correia
 */
public abstract class ApiRequest
{
    protected static String BASE_URL = "http://api.themoviedb.org/3/";
    
    protected static String FINAL_URL;
    
    protected URL URL;
    
    protected HttpURLConnection connection;
    
    protected ApiRequest(String RESSOURCE_URL)
    {
        FINAL_URL = BASE_URL+RESSOURCE_URL+"?";
    }
    
    protected void appendApiKey()
    {
        FINAL_URL+="api_key="+ApiKey.get();
    }
    
    protected void addParameter(String name, String value)
    {
        FINAL_URL+=name+"="+value+"&";
    }
    
    protected JSONObject fetch() throws Exception
    {
        appendApiKey();
        try
        {
            URL = new URL(FINAL_URL);
        }
        catch(MalformedURLException ex)
        {
            throw new Exception("Error creating URL object");
        }
        connection = (HttpURLConnection) URL.openConnection();
        
        if(connection.getResponseCode() != 200)
        {
            throw new Exception("Incorred answer from server.");
        }
        
        String response = "";
        BufferedReader in = new BufferedReader(
		        new InputStreamReader(connection.getInputStream()));
        while(in.ready())
        {
            response+=in.readLine();
        }
        
        return new JSONObject(response);
    }
}
