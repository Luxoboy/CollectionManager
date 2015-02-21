/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luxoboy.collectionmanager.api.model;

import static com.luxoboy.collectionmanager.api.model.TVShow.BASE_TV_SHOW_PATH;
import org.json.JSONObject;

/**
 *
 * @author Anthony Correia <anthony.correia71@gmail.com>
 */
public class Season extends ModelBase
{
    public static final String BASE_SEASON_DATA_PATH = "season/";
    private Season(int id)
    {
        super(id);
    }

    @Override
    protected JSONObject toJSON()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected boolean parseJSON(JSONObject obj)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void parseJSONDetails(JSONObject obj)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String buildDataFilePath()
    {
        return BASE_DATA_PATH+BASE_TV_SHOW_PATH+BASE_SEASON_DATA_PATH+id+DATA_FILE_EXTENSION;
    }
}
