/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luxoboy.collectionmanager.api.model;

/**
 *
 * @author Anthony Correia
 */
public class ModelBase
{
    static public final String BASE_CACHE_PATH = "cache/";
    static public final String BASE_IMG_PATH = "img/";
    static public final String BASE_DATA_PATH = "data/";
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
    
    protected int getId()
    {
        return id;
    }
    
}
