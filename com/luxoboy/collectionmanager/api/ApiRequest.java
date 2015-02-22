/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luxoboy.collectionmanager.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author Anthony Correia
 */
public abstract class ApiRequest
{
    /**
     * Base URL of the API.
     */
    protected static final String BASE_URL = "http://api.themoviedb.org/3/";
    
    private String RESSOURCE_URL;
    
    public static final int MAX_FETCHED_PAGES = 5;
    
    protected HashMap<String, String> parameters;
    
    public static String BASE_IMG_URL = null;
    
    protected URL URL;
    
    protected HttpURLConnection connection;
    
    protected int requestCounter = 0; //The number of requests in the last 10 sec
    
    protected long requestInstant; //The last time the 10 seconds counter was restarted.
    
    protected ApiRequest(String RESSOURCE_URL)
    {
        this.RESSOURCE_URL = RESSOURCE_URL;
        this.parameters = new HashMap<>();
    }
    
    protected String buildURL()
    {
        String final_url = BASE_URL+RESSOURCE_URL+"?";
        for(String key : parameters.keySet())
        {
            try
            {
                final_url+=key+"="+URLEncoder.encode(parameters.get(key), "UTF-8")+"&";
            } catch (UnsupportedEncodingException ex)
            {
                final_url+=key+"="+parameters.get(key)+"&";
            }
        }
        final_url+="api_key="+ApiKey.get();
        return final_url;
    }
    
    /**
     * Adds a paramater to URL.
     * @param name
     * @param value 
     */
    protected void addParameter(String name, String value)
    {
        parameters.put(name, value);
    }
    
    /**
     * Checks that the program is not execting too many requests.
     * This method puts the thread to sleep if to avoid a rate violation.
     */
    protected void checkRequestRate()
    {
        if(requestCounter < 10)
            return;
        long elapsedTime = System.currentTimeMillis() - requestInstant;
        if(elapsedTime > 10500)
        {
            try
            {
                Thread.sleep(15000 - elapsedTime);
            } catch (InterruptedException ex)
            {
                Logger.getLogger(ApiRequest.class.getName()).log(Level.SEVERE, null, ex);
            }
            requestCounter = 0;
        }
    }
    
    /**
     * Updates the request counter and instant after a request is sent.
     */
    protected void updateRequestCounter()
    {
        requestCounter++;
        if(requestCounter == 1)
            requestInstant = System.currentTimeMillis();
    }
    
    /**
     * Sends the request to the server and returns the received JSON data.
     * Before sending request, this method appends API Key to URL.
     * @return  The result of the request.
     * @throws Exception In the event of an error, an exception is thrown.
     * 
     */
    protected JSONObject fetch() throws Exception
    {
        if(RESSOURCE_URL == null)
            throw new Exception("RESSOURCE URL was not specied");
        final String FINAL_URL = buildURL();
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
            throw new Exception("Incorrect answer from server.");
        }
        
        System.out.println("Sending request: "+buildURL());
        String response = "";
        BufferedReader in = new BufferedReader(
		        new InputStreamReader(connection.getInputStream()));
        while(in.ready())
        {
            response+=in.readLine();
        }
        
        return new JSONObject(response);
    }

    protected void setRESSOURCE_URL(String RESSOURCE_URL)
    {
        this.RESSOURCE_URL = RESSOURCE_URL;
    }
}
