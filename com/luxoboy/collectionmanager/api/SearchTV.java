/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luxoboy.collectionmanager.api;

import com.luxoboy.collectionmanager.api.model.TVShow;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Anthony Correia
 */
public class SearchTV extends ApiRequest implements TVRequest
{
    /**
     * Creates a SearchTV with a given pattern.
     * @param pattern The pattern to look for in the database.
     */
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
            int total_pages = res.getInt("total_pages"),
                    fetched_pages = 0;
            ArrayList<TVShow> shows = new ArrayList<>();
            JSONArray res_shows; 
            while(fetched_pages < total_pages && fetched_pages < MAX_FETCHED_PAGES)
            {
                if(fetched_pages != 0)
                {
                    addParameter("page", Integer.toString(fetched_pages+1));
                    res = fetch();
                }
                res_shows = res.getJSONArray("results");
                for(int i=0; i < res_shows.length(); i++)
                {
                    TVShow tvs = TVShow.loadFromJson(res_shows.getJSONObject(i));
                    if(tvs != null)
                        shows.add(tvs);
                }
                fetched_pages++;
            }
            return shows;
            
        } catch (Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
    
}
