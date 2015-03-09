/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luxoboy.collectionmanager.api;

import org.json.JSONObject;

/**
 *
 * @author orann
 */
public class MovieDetails extends ApiRequest implements ByIDRequest 
{
    
    public MovieDetails()
    {
        super(null);
    }

    @Override
    public JSONObject proceed(int id)
    {
        this.setRESSOURCE_URL("movie/"+Integer.toString(id));
        try
        {
            JSONObject ret = null;
            ret = fetch();
            return ret;
        }
        catch(Exception ex)
        {
            System.out.println("Problem occured while fetching details for"
                    + " Movie with id "+id+".");
            return null;
        }
    }
}
