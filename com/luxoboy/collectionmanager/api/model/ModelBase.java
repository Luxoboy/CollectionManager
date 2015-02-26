/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luxoboy.collectionmanager.api.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.json.JSONObject;

/**
 *
 * @author Anthony Correia
 */
public abstract class ModelBase
{

    static public final String BASE_CACHE_PATH = "cache/";
    static public final String BASE_IMG_PATH = "img/";
    static public final String BASE_DATA_PATH = "data/";
    static public final String BASE_MOVIE_PATH = "movies/";
    static public final String DATA_FILE_EXTENSION = ".json";
    protected int id;
    
    static protected final DateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Indicates whether the object has all data loaded. If not, a fetch action
     * can be triggered.
     */
    protected boolean isPopulated = false;

    protected ModelBase(int id)
    {
        this.id = id;
    }

    abstract protected JSONObject toJSON();

    abstract protected boolean parseJSON(JSONObject obj);
    
    abstract protected void parseJSONDetails(JSONObject obj);

    abstract protected String buildDataFilePath();

    public int getId()
    {
        return id;
    }

    static protected String getImgBasePath()
    {
        return BASE_CACHE_PATH + BASE_IMG_PATH;
    }

    static protected String getDataBasePath()
    {
        return BASE_CACHE_PATH + BASE_DATA_PATH;
    }

    public boolean isIsPopulated()
    {
        return isPopulated;
    }

    public static int getYear(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        cal = null;
        return year;
    }
    
    /**
     * Saves data to disk in a JSON file.
     */
    protected void save()
    {
        String path = buildDataFilePath();
        Writer writer = null;
        try
        {
            File f = getDataFile();
            if (!f.exists())
            {
                f.getParentFile().mkdirs();
            }
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(f)));
            writer.write(toJSON().toString());
        } catch (IOException ex)
        {
            System.out.println("Error occured when writing data file item "
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
    
    /**
     * Reads a JSON object stored on disk.
     * @return The read object, null if file doesn't exist.
     */
    protected JSONObject readFromDisk()
    {
        File f = new File(buildDataFilePath());
        JSONObject obj = null;
        if(f.exists())
        {
            String json = new String();
            try
            {
                BufferedReader reader = new BufferedReader(new FileReader(f));
                while(reader.ready())
                    json+=reader.readLine();
                obj = new JSONObject(json);
                System.out.println(id+": loading from local file...");
            }
            catch(IOException ex)
            {
                ex.printStackTrace();
                obj = null;
            }
        }
        return obj;
    }
    
    /**
     * Abstract method which should implement data loading form disk if present,
     * or from API otherwise.
     */
    abstract public void load();
    
    protected File getDataFile()
    {
        return new File(buildDataFilePath());
    }
}
