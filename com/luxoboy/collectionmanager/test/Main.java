/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luxoboy.collectionmanager.test;

import com.luxoboy.collectionmanager.api.Configuration;
import com.luxoboy.collectionmanager.api.SearchTV;
import com.luxoboy.collectionmanager.api.TVDetails;
import com.luxoboy.collectionmanager.api.images.Images;
import com.luxoboy.collectionmanager.api.images.ImageSizes;
import com.luxoboy.collectionmanager.api.images.ImageSizes.SizeList;
import com.luxoboy.collectionmanager.api.images.ImageTypes;
import com.luxoboy.collectionmanager.api.model.TVShow;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            SearchTV s = new SearchTV("breaking bad");
            TVDetails details = new TVDetails();
            for(TVShow tvs : s.proceed())
            {
                details.proceed(tvs.getId());
            }
        } catch (Exception ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Image.downloadImage(ImageTypes.Backdrop, ImageSizes.Original, "4mW6xxN8pHtfECWGNHQQmoP34J.jpg", true);
    }
}
