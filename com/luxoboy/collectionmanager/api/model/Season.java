/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luxoboy.collectionmanager.api.model;

import com.luxoboy.collectionmanager.api.SeasonDetails;
import static com.luxoboy.collectionmanager.api.model.TVShow.BASE_TV_SHOW_PATH;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Anthony Correia <anthony.correia71@gmail.com>
 */
public class Season extends ModelBase
{
    public static final String BASE_SEASON_DATA_PATH = "season/";
    
    private int season_number, episode_count;
    private String poster_filename, name, overview;
    private ArrayList<Episode> episodes;
    private Date air_date;
    private int tvShowId;
    
    private JSONObject json;
    
    private Season(int id, int tvShowId)
    {
        super(id);
        this.tvShowId = tvShowId;
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
            air_date = date_format.parse(obj.getString("air_date"));
            poster_filename = obj.getString("poster_path");
            if(poster_filename.startsWith("/"))
                poster_filename = poster_filename.substring(1);
            season_number = obj.getInt("season_number");
            episode_count = obj.getInt("episode_count");
        }
        catch(JSONException | ParseException ex)
        {
            ex.printStackTrace();
            return false;
        }
        json = obj;
        isPopulated = true;
        return true;
    }
    
    /**
     * Creates a new Season from the given JSON object.
     * @param obj The JSON object containing data to build new season.
     * @return null if season could not be created from JSON.
     */
    public static Season loadFromJson(JSONObject obj, int tvShowId)
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
        Season sea = new Season(id, tvShowId);
        if (sea.parseJSON(obj))
        {
            return sea;
        }
        sea = null;
        return null;
    }

    @Override
    protected String buildDataFilePath()
    {
        return BASE_DATA_PATH+BASE_TV_SHOW_PATH+BASE_SEASON_DATA_PATH+id+DATA_FILE_EXTENSION;
    }

    public int getSeason_number()
    {
        return season_number;
    }

    public Date getAir_date()
    {
        return air_date;
    }

    @Override
    protected void load()
    {
        JSONObject obj = readFromDisk();
        if(obj == null)
        {
            System.out.println(name+": loading from API...");
            SeasonDetails request = new SeasonDetails(tvShowId);
            obj = request.proceed(id);
        }
        this.parseJSONDetails(obj);
    }

    @Override
    protected void parseJSONDetails(JSONObject obj)
    {
        try
        {
            name = obj.getString("name");
            overview = obj.getString("overview");
        }
        catch(JSONException ex)
        {
            System.out.println("Error while parsing details of season id "+id);
            name = null;
            overview = null;
        }
        try
        {
            JSONArray episodesJson = obj.getJSONArray("episodes");
            episodes = new ArrayList<>(episodesJson.length());
            for(int i=0; i < episodesJson.length(); i++)
            {
                JSONObject epJson = episodesJson.getJSONObject(i);
                Episode ep = Episode.loadFromJson(obj);
                if(ep != null)
                    episodes.add(ep);
            }
        }
        catch(JSONException ex)
        {
            System.out.println("Error parsing episodes of season id "+id);
            episodes = null;
        }
        save();
    }

    public String getPoster_filename()
    {
        return poster_filename;
    }

    public String getName()
    {
        return name;
    }

    public String getOverview()
    {
        return overview;
    }

    public ArrayList<Episode> getEpisodes()
    {
        return episodes;
    }

    public int getEpisode_count()
    {
        return episode_count;
    }
    
    @Override
    public String toString()
    {
        if(name != null)
            return name;
        else
            return "Season "+season_number;
    }
}
