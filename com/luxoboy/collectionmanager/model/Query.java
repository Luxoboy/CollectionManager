/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luxoboy.collectionmanager.model;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author orann
 */
public class Query{
    
    static public boolean addUser(String name, String surname) throws Exception {
        try {
            int insert = DB.executeUpdate("insert into User (`Name`, `Surname`) VALUES ('" + name + "', '" + surname + "')");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean addDetailsCollection(int userID, int rate) throws Exception{
        try {
            int insert = DB.executeUpdate("insert into DetailsCollection (`UserId`, `Rate`) VALUES ('" + userID + "', '" + rate + "')");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
