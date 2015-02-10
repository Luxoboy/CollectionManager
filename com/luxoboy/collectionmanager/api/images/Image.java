/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luxoboy.collectionmanager.api.images;

import com.luxoboy.collectionmanager.api.ApiRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.imageio.ImageIO;

/**
 *
 * @author Anthony Correia
 */
public class Image
{

    static public com.luxoboy.collectionmanager.api.model.Image
            downloadImage(ImageTypes type, String size, String file, boolean saveToDisk)
    {
        String path = ApiRequest.BASE_IMG_URL + size +"/"+ file;
        BufferedImage img;
        try
        {
            URL url = new URL(path);
            if (!saveToDisk)
            {
                img = ImageIO.read(url);
                return new com.luxoboy.collectionmanager.api.model.Image(type, size, file, img);
            } else
            {
                URLConnection con = url.openConnection();
                InputStream in = con.getInputStream();
                int read;
                byte buffer[] = new byte[1024];
                File f = new File(com.luxoboy.collectionmanager.api.model.Image.buildPath(size, file));
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
        return new com.luxoboy.collectionmanager.api.model.Image(type, size, file);
    }
}
