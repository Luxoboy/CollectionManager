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
    
    static public boolean modifyName(int userID, String name) throws Exception{
        try {
            int update = DB.executeUpdate("update User set Name='" + name + "' where ID='"+ userID + "'");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }        
    }
    
    static public boolean modifySurname(int userID, String surname) throws Exception{
        try {
            int update = DB.executeUpdate("update User set Surname='" + surname + "' where ID='"+ userID + "'");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }        
    }
    
    static public boolean addDetailsCollection(int userID, int rate) throws Exception{
        try {
            int insert = DB.executeUpdate("insert into DetailsCollection (`UserID`, `Rate`) values ('" + userID + "', '" + rate + "')");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    static public boolean modifyRate(int userID, int rate) throws Exception{
        try {
            int update = DB.executeUpdate("update DetailsCollection set Rate='" + rate + "' where UserID='"+ userID + "'");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }        
    }
}
