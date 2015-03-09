/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luxoboy.collectionmanager.api;

import static com.luxoboy.collectionmanager.api.ApiRequest.MAX_FETCHED_PAGES;
import com.luxoboy.collectionmanager.api.model.Movie;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author orann
 */
public class SearchMovie extends ApiRequest implements MovieRequest 
{
    /**
     * Creates a SearchTV with a given pattern.
     * @param pattern The pattern to look for in the database.
     */
    public SearchMovie(String pattern)
    {
        super("search/movie");
        addParameter("query", pattern);
    }
    
    @Override
    public ArrayList<Movie> proceed()
    {
        try
        {
            JSONObject res = fetch();
            int total_pages = res.getInt("total_pages"),
                    fetched_pages = 0;
            ArrayList<Movie> movie = new ArrayList<>();
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
                    Movie m = Movie.loadFromJson(res_shows.getJSONObject(i));
                    if(m != null)
                        movie.add(m);
                }
                fetched_pages++;
            }
            return movie;
            
        } catch (Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
}
