/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luxoboy.collectionmanager.api;

import com.luxoboy.collectionmanager.api.model.TVShow;
import java.util.ArrayList;

/**
 *
 * @author Anthony Correia
 */
public interface TVRequest
{
    public ArrayList<TVShow> proceed();
}
