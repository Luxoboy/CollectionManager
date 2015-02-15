/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luxoboy.collectionmanager.api;

import com.luxoboy.collectionmanager.api.images.ImageSizes;
import com.luxoboy.collectionmanager.api.images.ImageTypes;
import org.json.JSONArray;
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
    
    /**
     * Fetched configuration data from API and set variables accordingly.
     * @throws Exception 
     */
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
            System.out.println("Beginning configuration...");
            JSONObject images = res.getJSONObject("images");
            BASE_IMG_URL = images.getString("base_url");
            System.out.println("Set BASE_IMG_URL to "+BASE_IMG_URL);
            
            for(ImageTypes type : ImageTypes.values())
            {
                String array_name = type.name()+"_sizes";
                JSONArray array = images.getJSONArray(array_name);
                for(int i=0; i < array.length(); i++)
                {
                    ImageSizes.addAssociation(type, array.getString(i));
                }
            }
            System.out.println("Configuration done.");
        }
        catch(JSONException ex)
        {
            throw new Exception("Error while parsing configuration data.");
        }
    }
    
}
