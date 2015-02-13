/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luxoboy.collectionmanager.api.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    private TVShow()
    {
        super(-1);
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
        save();
    }

    public String getBackdrop_filename()
    {
        return backdrop_filename;
    }
    
    /**
     * Parses a JSON object and popualates object.
     * @param obj The JSON object to parse.
     * @return False if the object could not be populated.
     */
    @Override
     protected boolean parseJSON(JSONObject obj)
    {
        try
        {
            id = obj.getInt("id");
            name = obj.getString("name");
        }
        catch(JSONException ex)
        {
            return false;
        }
        try
        {
            original_name = obj.getString("original_name");
            if (!obj.isNull("backdrop_path"))
            {
                backdrop_filename = obj.getString("backdrop_path").substring(1);
            }
            else
                backdrop_filename = "";

        } catch (JSONException ex)
        {
            ex.printStackTrace();
            System.out.println("Error while parsing TV Show JSON DATA:\n" + obj.toString(1));
            return false;
        }
        try
        {
            first_air_date = date_format.parse(obj.getString("first_air_date"));
        } catch (JSONException | ParseException ex)
        {
            first_air_date = new Date(0);
        }
        try
        {
            vote_average = obj.getDouble("vote_average");
        } catch (JSONException ex)
        {
            vote_average = -1;
        }
        return true;
    }
    
    /**
     * Creates new TV Show from JSON.
     * @param obj The JSON object to extract data from.
     * @return null if the TV Show could not be loaded.
     */
    public static TVShow loadFromJson(JSONObject obj)
    {
        TVShow tvs = new TVShow();
        if(tvs.parseJSON(obj))
            return tvs;
        return null;
    }

    /**
     * Saves the data to a file containing data formatted in JSON.
     *
     * @throws Exception
     */
    private void save()
    {
        String path = buildDataFilePath();
        Writer writer = null;
        try
        {
            File f = new File(path);
            if (!f.exists())
            {
                f.getParentFile().mkdirs();
            }
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(f)));
            writer.write(toJSON().toString());
        } catch (IOException ex)
        {
            System.out.println("Error occured when writing data file for TV Show"
                    + "id " + id + ".");
        } finally
        {
            if (writer != null)
            {
                try
                {
                    writer.close();
                } catch (IOException ex)
                {
                    ;
                }
            }
        }
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
        return getDataBasePath() + BASE_TV_SHOW_PATH + Integer.toString(id);
    }

    /**
     * Exports all data to a JSON object.
     *
     * @return The created JSON object.
     */
    @Override
    protected JSONObject toJSON()
    {
        JSONObject ret = toJSON_base();

        ret.put("name", name);
        ret.put("original_name", original_name);
        ret.put("vote_average", vote_average);
        ret.put("first_air_date", date_format.format(first_air_date));

        JSONArray origin_country_array = new JSONArray();
        for (String country : origin_country)
        {
            origin_country_array.put(country);
        }
        ret.put("origin_country", origin_country_array);

        return ret;
    }

}
