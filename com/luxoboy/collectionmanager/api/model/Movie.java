/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luxoboy.collectionmanager.api.model;

import com.luxoboy.collectionmanager.api.TVDetails;
import com.luxoboy.collectionmanager.api.images.ImageSizes;
import com.luxoboy.collectionmanager.api.images.ImageTypes;
import static com.luxoboy.collectionmanager.api.model.ModelBase.date_format;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author orann
 */
public class Movie extends ModelBase{
    
    static public final String BASE_TV_SHOW_PATH = "movie/";

    private String original_name, name;
    private ArrayList<String> origin_country, authors, genres;
    private Date first_air_date, last_air_date;
    private String backdrop_filename, homepage, original_language, overview,
            status;
    private double vote_average;
    private boolean in_production;
    private Image main_backdrop;
    
    /**
     * Basic informations extracted from search request.
     */
    private JSONObject json_base;
    /**
     * Detailed informations extracted from TVDetails.
     */
    private JSONObject json_details;
    
    public Movie(int id) {
        super(id);
        main_backdrop = null;
    }

    public String getBackdrop_filename()
    {
        return backdrop_filename;
    }

    /**
     * Parses a JSON object and popualates object with base informations.
     *
     * @param obj The JSON object to parse.
     * @return False if the object could not be populated.
     */
    @Override
    protected boolean parseJSON(JSONObject obj)
    {
        System.out.println("Parsing base informations...");
        try
        {
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
            System.out.println("Error while parsing Movie JSON DATA:\n" + obj.toString(1));
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
        json_base = obj;
        return true;
    }

    /**
     * Parses JSON to extract details and fully populates object.
     *
     * @param obj
     * @return
     */
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
            System.out.println("Error parsing authors in movie " + name);
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
            System.out.println("Error parsing genres in movie " + name);
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
            System.out.println("Error parsing homepage of movie "+name);
            homepage = null;
        }
        try
        {
            in_production = obj.getBoolean("in_production");
        }
        catch(JSONException ex)
        {
            System.out.println("Error parsing in_production of movie "+name);
            in_production = false;
        }
        try
        {
            String last_air_date_str = obj.getString("last_air_date");
            last_air_date = date_format.parse(last_air_date_str);
        }
        catch(JSONException | ParseException ex)
        {
            System.out.println("Error parsing last_air_date of movie "+name);
            last_air_date = new Date(0);
        }

        try
        {
            original_language = obj.getString("original_language");
        }
        catch(JSONException ex)
        {
            System.out.println("Error parsing original language of movie "+name);
            original_language = null;
        }
        try
        {
            overview = obj.getString("overview");
        }
        catch(JSONException ex)
        {
            System.out.println("Error parsing overview of movie "+name);
            overview = null;
        }
        try
        {
            status = obj.getString("status");
        }
        catch(JSONException ex)
        {
            System.out.println("Error parsing status of movie "+name);
            status = null;
        }

        isPopulated = true;
        json_details = obj;
        save();
    }
    
    /**
     * Populates object wether from disk or from API.
     */
    @Override
    public void load()
    {
        JSONObject obj = readFromDisk();
        if(obj == null)
        {
            System.out.println(name+": loading from API...");
            TVDetails tvd = new TVDetails();
            obj = tvd.proceed(id);
        }
        this.parseJSONDetails(obj);
    }

    /**
     * Creates new TV Show from JSON.
     *
     * @param obj The JSON object to extract data from.
     * @return null if the TV Show could not be loaded.
     */
    public static Movie loadFromJson(JSONObject obj)
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
        Movie movie = new Movie(id);
        if (movie.parseJSON(obj))
        {
            return movie;
        }
        movie = null;
        return null;
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

    public ArrayList<String> getAuthors()
    {
        return authors;
    }

    public ArrayList<String> getGenres()
    {
        return genres;
    }

    public Date getLast_air_date()
    {
        return last_air_date;
    }

    public String getHomepage()
    {
        return homepage;
    }

    public String getOriginal_language()
    {
        return original_language;
    }

    public String getOverview()
    {
        return overview;
    }

    public String getStatus()
    {
        return status;
    }

    public boolean isIn_production()
    {
        return in_production;
    }
    
    public Image getMain_backdrop(ImageSizes.SizeList size)
    {
        if(main_backdrop != null)
        {
            if(!main_backdrop.getSize().equals(size))
                main_backdrop = null;
        }
        if(main_backdrop == null)
        {
            main_backdrop = Image.get(ImageTypes.backdrop, size, backdrop_filename);
        }
        return main_backdrop;
    }
    

    @Override
    protected String buildDataFilePath()
    {
        return getDataBasePath() + BASE_TV_SHOW_PATH + Integer.toString(id)+DATA_FILE_EXTENSION;
    }

    /**
     * Exports all data to a JSON object.
     *
     * @return The created JSON object.
     */
    @Override
    protected JSONObject toJSON()
    {
        JSONObject ret = new JSONObject(json_base, JSONObject.getNames(json_base));
        for(String key : JSONObject.getNames(json_details))
            ret.put(key, json_details.get(key));
        return ret;
    }
    
}
