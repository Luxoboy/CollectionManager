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
    private ArrayList<String> origin_country, authors, genres;
    private Date first_air_date, last_air_date;
    private String backdrop_filename, homepage, original_language, overview,
            status;
    private double vote_average;
    private boolean in_production;
    private int number_of_seasons, number_of_episodes;

    static private final DateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");

    private TVShow()
    {
        super(-1);
    }

    public String getBackdrop_filename()
    {
        return backdrop_filename;
    }

    /**
     * Parses a JSON object and popualates object.
     *
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
        } catch (JSONException ex)
        {
            return false;
        }
        try
        {
            original_name = obj.getString("original_name");
            if (!obj.isNull("backdrop_path"))
            {
                backdrop_filename = obj.getString("backdrop_path").substring(1);
            } else
            {
                backdrop_filename = "";
            }

        } catch (JSONException ex)
        {
            ex.printStackTrace();
            System.out.println("Error while parsing TV Show JSON DATA:\n" + obj.toString(1));
            return false;
        }
        try
        {
            origin_country = new ArrayList<>();
            JSONArray countries = obj.getJSONArray("origin_country");
            for (int i = 0; i < countries.length(); i++)
            {
                origin_country.add(countries.getString(i));
            }
        } catch (JSONException ex)
        {
            origin_country = null;
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
     * Parses JSON to extract details and fully populates object.
     *
     * @param obj
     * @return
     */
    @Override
    protected void parseJSONDetails(JSONObject obj)
    {
        JSONArray array = null;
        try
        {
            authors = new ArrayList<>();
            array = obj.getJSONArray("created_by");
            for (int i = 0; i < array.length(); i++)
            {
                authors.add(array.getJSONObject(i).getString("name"));
            }
            array = null;
        } catch (JSONException ex)
        {
            System.out.println("Error parsing authors in show " + name);
            if (array != null)
            {
                System.out.println(array.toString(1));
            }
            authors = null;
        }
        try
        {
            genres = new ArrayList<>();
            array = obj.getJSONArray("genres");
            for (int i = 0; i < array.length(); i++)
            {
                genres.add(array.getJSONObject(i).getString("name"));
            }
            array = null;
        }
        catch(JSONException ex)
        {
            System.out.println("Error parsing genres in show " + name);
            if (array != null)
            {
                System.out.println(array.toString(1));
            }
            genres = null;
        }
        try
        {
            homepage = obj.getString("homepage");
        }
        catch(JSONException ex )
        {
            System.out.println("Error parsing homepage of show "+name);
            homepage = null;
        }
        try
        {
            in_production = obj.getBoolean("in_production");
        }
        catch(JSONException ex)
        {
            System.out.println("Error parsing in_production of show "+name);
            in_production = false;
        }
        try
        {
            String last_air_date_str = obj.getString("last_air_date");
            last_air_date = date_format.parse(last_air_date_str);
        }
        catch(JSONException | ParseException ex)
        {
            System.out.println("Error parsing last_air_date of show "+name);
            last_air_date = new Date(0);
        }
        try
        {
            number_of_episodes = obj.getInt("number_of_episodes");
        }
        catch(JSONException ex)
        {
            System.out.println("Error parsing number_of_episodes of show "+name);
            number_of_episodes = -1;
        }
        try
        {
            number_of_seasons = obj.getInt("number_of_seasons");
        }
        catch(JSONException ex)
        {
            System.out.println("Error parsing number_of_seasons of show "+name);
            number_of_seasons = -1;
        }
        try
        {
            original_language = obj.getString("original_language");
        }
        catch(JSONException ex)
        {
            System.out.println("Error parsing original language of show "+name);
            original_language = null;
        }
        try
        {
            overview = obj.getString("overview");
        }
        catch(JSONException ex)
        {
            System.out.println("Error parsing overview of show "+name);
            overview = null;
        }
        try
        {
            status = obj.getString("status");
        }
        catch(JSONException ex)
        {
            System.out.println("Error parsing status of show "+name);
            status = null;
        }
        isPopulated = true;
    }

    /**
     * Creates new TV Show from JSON.
     *
     * @param obj The JSON object to extract data from.
     * @return null if the TV Show could not be loaded.
     */
    public static TVShow loadFromJson(JSONObject obj)
    {
        TVShow tvs = new TVShow();
        if (tvs.parseJSON(obj))
        {
            return tvs;
        }
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
