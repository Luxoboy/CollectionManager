/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luxoboy.collectionmanager.api.model;

import com.luxoboy.collectionmanager.api.images.ImageSizes;
import com.sun.javafx.iio.ImageStorage.ImageType;
import java.awt.image.BufferedImage;

/**
 *
 * @author Anthony Correia
 */
public class Image
{
    private ImageType type;
    private ImageSizes size;
    private String filename;
    private BufferedImage img;

    public Image(ImageType type, ImageSizes size, BufferedImage img, String filename)
    {
        this.type = type;
        this.size = size;
        this.img = img;
        this.filename = filename;
        if(filename.startsWith("/"))
            this.filename.substring(1);
    }
    
    public String getPath()
    {
        return ModelBase.BASE_CACHE_PATH+ModelBase.BASE_IMG_PATH+size+"/"+filename;
    }

    public String getFilename()
    {
        return filename;
    }
    
    public ImageType getType()
    {
        return type;
    }

    public ImageSizes getSize()
    {
        return size;
    }

    public BufferedImage getImg()
    {
        return img;
    }
    
    
}
