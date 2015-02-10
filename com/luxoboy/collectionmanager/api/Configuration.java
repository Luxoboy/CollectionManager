/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luxoboy.collectionmanager.api;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Anthony Correia
 */
public class Configuration extends ApiRequest
{

    private Configuration(String RESSOURCE_URL)
    {
        super(RESSOURCE_URL);
    }
    
    static public void proceed() throws Exception
    {
        Configuration conf = new Configuration("configuration");
        JSONObject res;
        try{
            res = conf.fetch();
        }
        catch(Exception ex)
        {
            throw new Exception("Error while setting configuration.");
        }
        try
        {
            BASE_IMG_URL = res.getJSONObject("images").getString("base_url");
            System.out.println("Set BASE_IMG_URL to "+BASE_IMG_URL);
        }
        catch(JSONException ex)
        {
            throw new Exception("Error while parsing configuration data.");
        }
    }
    
}
