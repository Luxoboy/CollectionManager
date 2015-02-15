/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luxoboy.collectionmanager.api.model;

import com.luxoboy.collectionmanager.api.images.ImageSizes.SizeList;
import com.luxoboy.collectionmanager.api.images.ImageTypes;
import com.luxoboy.collectionmanager.api.images.Images;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Anthony Correia
 */
public class Image
{
    private ImageTypes type;
    private SizeList size;
    private String filename;
    private BufferedImage img;
    
    /**
     * 
     * @param type
     * @param size
     * @param img
     * @param filename 
     */
    public Image(ImageTypes type, SizeList size, String filename, BufferedImage img)
    {
        this.type = type;
        this.size = size;
        this.img = img;
        this.filename = filename;
        if(filename.startsWith("/"))
            this.filename = this.filename.substring(1);
    }
    
    public Image(ImageTypes type, SizeList size, String filename)
    {
        this.type = type;
        this.size = size;
        this.filename = filename;
        if(filename.startsWith("/"))
            this.filename = this.filename.substring(1);
        loadImage();
    }
    
    public static Image get(ImageTypes type, SizeList size, String filename)
    {
        if(isStored(size, filename))
        {
            return new Image(type, size, filename);
        }
        else
        {
            return Images.downloadImage(type, size, filename, true);
        }
    }
    
    private void loadImage()
    {
        try
        {
            this.img = ImageIO.read(new File(getPath()));
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
            System.out.println("Error while loading image: "+getPath());
        }
    }
    
    public String getPath()
    {
        return buildPath(size, filename);
    }
    
    static public String buildPath(SizeList size, String filemane)
    {
        String filename_ = new String(filemane);
        if(filename_.startsWith("/"))
            filename_ = filename_.substring(1);
        return ModelBase.BASE_CACHE_PATH+ModelBase.BASE_IMG_PATH+size.name()+"/"+filename_;
    }
    
    static public boolean isStored(SizeList size, String filename)
    {
        File f = new File(buildPath(size, filename));
        return f.exists();
    }

    public String getFilename()
    {
        return filename;
    }
    
    public ImageTypes getType()
    {
        return type;
    }

    public SizeList getSize()
    {
        return size;
    }

    public BufferedImage getImg()
    {
        return img;
    }
    
    
}
