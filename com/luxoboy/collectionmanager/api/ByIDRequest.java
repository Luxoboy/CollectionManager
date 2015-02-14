/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luxoboy.collectionmanager.api;

import org.json.JSONObject;

/**
 * Interface used for requests which don't create objects, but only fetch data about
 * a particular item.
 * @author Anthony Correia <anthony.correia71@gmail.com>
 */
public interface ByIDRequest
{
    public JSONObject proceed(int id);
}
