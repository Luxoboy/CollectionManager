/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luxoboy.collectionmanager.api.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Anthony Correia
 */
public class TVShow extends ModelBase
{
    
    static public final String BASE_TV_SHOW_PATH = "tvs/";
    
    private String original_name, name;
    private ArrayList<String> origin_country;
    private Date first_air_date;
    private String backdrop_filename;
    private double vote_average;

    static private final DateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");

    public TVShow(int id)
    {
        super(id);
    }

    public TVShow(int id, String original_name, String name, JSONArray original_country,
            String first_air_date, double vote_average, String backdrop_filename)
    {
        super(id);
        this.original_name = original_name;
        this.name = name;
        this.backdrop_filename = backdrop_filename;
        this.origin_country = new ArrayList<>(original_country.length());
        this.vote_average = vote_average;
        for (int i = 0; i < original_country.length(); i++)
        {
            this.origin_country.add(original_country.getString(i));
        }
        try
        {
            this.first_air_date = date_format.parse(first_air_date);
        } catch (ParseException ex)
        {
            ex.printStackTrace();
            System.out.println("Error while parsing first air date: " + first_air_date);
            this.first_air_date = new Date(0);
        }
    }

    public String getBackdrop_filename()
    {
        return backdrop_filename;
    }

    public static TVShow parseJSON(JSONObject obj)
    {
        String original_name,
                first_air_date,
                name,
                backdrop_filename;
        double vote_average;
        TVShow tvs;
        int id;
        try
        {
            id = obj.getInt("id");
            original_name = obj.getString("original_name");
            name = obj.getString("name");
            backdrop_filename = obj.getString("backdrop_path").substring(1);

        } catch (JSONException ex)
        {
            ex.printStackTrace();
            System.out.println("Error while parsing TV Show JSON DATA:\n" + obj.toString(1));
            return null;
        }
        try
        {
            first_air_date = obj.getString("first_air_date");
        } catch (JSONException ex)
        {
            first_air_date = "1971-01-01";
        }
        try
        {
            vote_average = obj.getDouble("vote_average");
        }
        catch(JSONException ex)
        {
            vote_average = -1;
        }
        tvs = new TVShow(id, original_name, name,
                obj.getJSONArray("origin_country"), first_air_date, vote_average,
                backdrop_filename);
        return tvs;
    }
    
    public double getVote_average()
    {
        return vote_average;
    }
    
    public String getOriginal_name()
    {
        return original_name;
    }

    public String getName()
    {
        return name;
    }

    public ArrayList<String> getOrigin_country()
    {
        return origin_country;
    }

    public Date getFirst_air_date()
    {
        return first_air_date;
    }

    @Override
    protected String buildDataFilePath()
    {
        return getDataBasePath()+BASE_TV_SHOW_PATH+Integer.toString(id);
    }

}
