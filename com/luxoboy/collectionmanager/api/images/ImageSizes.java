/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luxoboy.collectionmanager.api.images;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Anthony Correia
 */
public class ImageSizes
{
    static public String W300 = "w300",
            W780 = "w780",
            W1280 = "w1280",
            Original = "original",
            W45 = "w45",
            W92 = "w92",
            W185 = "w185",
            W500 = "w500",
            W154 = "w154",
            W342 = "w342",
            H632 = "h632";
    
    public static enum SizeList{
        w300,
        w780,
        w1280,
        original,
        w45,
        w92 ,
        w185,
        w500,
        w154,
        w342,
        h632;
    }
    
    /**
     * HashMap storing associations between image types and associated sizes.
     */
    private static final HashMap<ImageTypes, Set<SizeList>> 
            associations = new HashMap<>(ImageTypes.values().length);
    
    public static void addAssociation(ImageTypes type, String size) throws Exception
    {
        Set<SizeList> set = associations.get(type);
        if(set == null)
        {
            set = new HashSet<>(1);
            associations.put(type, set);
        }
        for(SizeList size_e : SizeList.values())
        {
            if(size.equals(size_e.name()))
            {
                set.add(size_e);
                System.out.println("Added "+size+" to "+type.name()+"'s available sizes.");
                return;
            }
        }
        throw new Exception("Size "+size+" does not exist in ListSize enum.");
    }
    
    public static boolean isValid(ImageTypes type, SizeList size) throws Exception
    {
        Set<SizeList> set = associations.get(type);
        if(set == null)
        {
            throw new Exception("Configuration was not done for this type");
        }
        for(SizeList val : set)
            if(val == size)
                return true;
        
        return false;
    }
}
