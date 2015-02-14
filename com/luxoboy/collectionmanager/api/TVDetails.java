/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luxoboy.collectionmanager.api;

import org.json.JSONObject;

/**
 *
 * @author Anthony Correia <anthony.correia71@gmail.com>
 */
public class TVDetails extends ApiRequest implements ByIDRequest
{

    public TVDetails()
    {
        super(null);
    }

    @Override
    public JSONObject proceed(int id)
    {
        this.setRESSOURCE_URL("tv/"+Integer.toString(id));
        try
        {
            JSONObject ret = null;
            ret = fetch();
            return ret;
        }
        catch(Exception ex)
        {
            System.out.println("Problem occured while fetching details for"
                    + " TV Show with id "+id+".");
            return null;
        }
    }
    
}
