/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luxoboy.collectionmanager.api.images;

import com.luxoboy.collectionmanager.api.ApiRequest;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author Anthony Correia
 */
public class Image
{
    static BufferedImage downloadImage(ImagesTypes type, String size, String file)
    {
        String path = ApiRequest.BASE_IMG_URL+size+file;
        BufferedImage img;
        try
        {
            URL url = new URL(path);
            img = ImageIO.read(url);
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
            System.out.println("Error while downloading image from path: "+path);
            return null;
        }
        return img;
    }
}
