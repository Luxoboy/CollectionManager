/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luxoboy.collectionmanager.api.images;

import com.luxoboy.collectionmanager.api.ApiRequest;
import com.luxoboy.collectionmanager.api.images.ImageSizes.SizeList;
import com.luxoboy.collectionmanager.api.model.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.imageio.ImageIO;

/**
 * This class is used to access from tmdb's API.
 * @author Anthony Correia
 */
public class Images
{

    static public Image
            downloadImage(ImageTypes type, SizeList size, String file, boolean saveToDisk)
    {
        String path = ApiRequest.BASE_IMG_URL + size +"/"+ file;
        System.out.println(path);
        BufferedImage img;
        try
        {
            URL url = new URL(path);
            if (!saveToDisk)
            {
                img = ImageIO.read(url);
                return new Image(type, size, file, img);
            } else
            {
                URLConnection con = url.openConnection();
                InputStream in = con.getInputStream();
                int read;
                byte buffer[] = new byte[1024];
                File f = new File(Image.buildPath(size, file));
                f.getParentFile().mkdirs();
                FileOutputStream out = new FileOutputStream(f);
                while ((read = in.read(buffer)) > 0)
                {
                    out.write(buffer, 0, read);
                }
                out.flush();
                out.close();
            }
        } catch (IOException ex)
        {
            ex.printStackTrace();
            System.out.println("Error while downloading image from path: " + path);
            return null;
        }
        return new Image(type, size, file);
    }
}
