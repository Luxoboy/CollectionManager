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
public class SeasonDetails extends ApiRequest implements ByIDRequest
{
    private final int tvShowId;
    
    public SeasonDetails(int tvShowId)
    {
        super(null);
        this.tvShowId = tvShowId;
    }

    @Override
    public JSONObject proceed(int seasonId)
    {
        this.setRESSOURCE_URL("/tv/"+tvShowId+"/season/"+seasonId);
        try
        {
            JSONObject ret = null;
            ret = fetch();
            return ret;
        }
        catch(Exception ex)
        {
            System.out.println("Problem occured while fetching details for"
                    + " season number "+seasonId+" of show with id "+tvShowId);
            return null;
        }
    }
    
}
