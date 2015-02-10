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
public class TVShow extends ModelBase
{
    private String original_name, name;
    public TVShow(int id)
    {
        super(id);
    }
    
    public TVShow(int id, String original_name, String name)
    {
        super(id);
        this.original_name = original_name;
        this.name = name;
    }
}
