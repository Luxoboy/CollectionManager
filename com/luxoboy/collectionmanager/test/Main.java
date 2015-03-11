/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luxoboy.collectionmanager.test;

import com.luxoboy.collectionmanager.api.Configuration;
import com.luxoboy.collectionmanager.api.MovieDetails;
import com.luxoboy.collectionmanager.api.SearchMovie;
import com.luxoboy.collectionmanager.api.SearchTV;
import com.luxoboy.collectionmanager.api.TVDetails;
import com.luxoboy.collectionmanager.api.images.Images;
import com.luxoboy.collectionmanager.api.images.ImageSizes;
import com.luxoboy.collectionmanager.api.images.ImageSizes.SizeList;
import com.luxoboy.collectionmanager.api.images.ImageTypes;
import com.luxoboy.collectionmanager.api.model.Movie;
import com.luxoboy.collectionmanager.api.model.TVShow;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author Anthony Correia
 */
public class Main
{
    public static void main(String args[])
    {        
        try
        {
            Configuration.proceed();
            SearchMovie s = new SearchMovie("Fight Club");
            MovieDetails details = new MovieDetails();
            for(Movie tvs : s.proceed())
            {
                tvs.load();
                System.out.println(tvs.getTitle());
            }
        } catch (Exception ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        //Image.downloadImage(ImageTypes.Backdrop, ImageSizes.Original, "4mW6xxN8pHtfECWGNHQQmoP34J.jpg", true);
    }
}
