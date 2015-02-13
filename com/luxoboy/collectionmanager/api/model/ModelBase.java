/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luxoboy.collectionmanager.api.model;

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
    protected int id;
    
    /**
     * Indicates whether the object has all data loaded.
     * If not, a fetch action can be triggered.
     */
    protected boolean isPopulated = false;
    
    protected ModelBase(int id)
    {
        this.id = id;
    }
    
    protected JSONObject toJSON_base()
    {
        JSONObject ret = new JSONObject();
        ret.put("id", id);
        return ret;
    }
    
    abstract JSONObject toJSON();
    
    protected int getId()
    {
        return id;
    }
    
    static protected String getImgBasePath()
    {
        return BASE_CACHE_PATH+BASE_IMG_PATH;
    }
    
    static protected String getDataBasePath()
    {
        return BASE_CACHE_PATH+BASE_DATA_PATH;
    }
    
    abstract protected String buildDataFilePath();
    
}
