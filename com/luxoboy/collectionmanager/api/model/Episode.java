/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luxoboy.collectionmanager.api.model;

import static com.luxoboy.collectionmanager.api.model.TVShow.BASE_TV_SHOW_PATH;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Anthony Correia <anthony.correia71@gmail.com>
 */
public class Episode extends ModelBase
{
    public static final String BASE_EPISODE_DATA_PATH = "episode/";
    
    private Date air_date;
    private int episode_number;
    private String name, overview, still_path;
    private double vote_average;
    private JSONObject json;
    
    private Episode(int id)
    {
        super(id);
    }

    @Override
    protected JSONObject toJSON()
    {
        return json;
    }

    @Override
    protected boolean parseJSON(JSONObject obj)
    {
        try
        {
            name = obj.getString("name");
            episode_number = obj.getInt("episode_number");
        }
        catch(JSONException ex)
        {
            ex.printStackTrace();
            return false;
        }
        json = obj;
        try
        {
            overview = obj.getString("overview");
            air_date = date_format.parse(obj.getString("air_date"));
            still_path = obj.getString("still_path");
            if(still_path.startsWith("/"))
            {
                still_path = still_path.substring(1);
            }
            vote_average = obj.getDouble("vote_average");
        }
        catch(JSONException | ParseException ex)
        {
            ex.printStackTrace();
        }
        save();
        isPopulated = true;
        return true;
    }
    
    /**
     * Creates a new Episode from the given JSON object.
     * @param obj The JSON object containing data to build new episode.
     * @return null if episode could not be created from JSON.
     */
    public static Episode loadFromJson(JSONObject obj)
    {
        int id;
        try
        {
            id = obj.getInt("id");
        }
        catch(JSONException ex)
        {
            return null;
        }
        Episode ep = new Episode(id);
        if (ep.parseJSON(obj))
        {
            return ep;
        }
        ep = null;
        return null;
    }

    @Override
    protected String buildDataFilePath()
    {
        return BASE_CACHE_PATH+BASE_DATA_PATH+BASE_TV_SHOW_PATH+BASE_EPISODE_DATA_PATH+id+DATA_FILE_EXTENSION;
    }

    @Override
    public void load()
    {
        throw new UnsupportedOperationException("Episodes do not need to be loaded.");
    }

    @Override
    protected void parseJSONDetails(JSONObject obj)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString()
    {
        return "E"+episode_number+" - "+name;
    }
}
