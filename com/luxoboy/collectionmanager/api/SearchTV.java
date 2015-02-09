/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luxoboy.collectionmanager.api;

import com.luxoboy.collectionmanager.api.model.TVShow;
import java.io.Writer;
import java.util.ArrayList;
import org.json.JSONObject;
import org.json.JSONWriter;

/**
 *
 * @author Anthony Correia
 */
public class SearchTV extends ApiRequest implements TVRequest
{
    public SearchTV(String pattern)
    {
        super("search/tv");
        addParameter("query", pattern);
    }
    
    @Override
    public ArrayList<TVShow> proceed()
    {
        try
        {
            JSONObject res = fetch();
            System.out.println(res.toString(1));
        } catch (Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
        return null;
    }
    
}
