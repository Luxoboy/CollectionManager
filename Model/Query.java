/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author orann
 */
public class Query{
    
    private DB database = null;
    
    public Query() {
        
        if (database == null) {
            try {
                database = new DB("boxa.noip.me", "3306", "collectionmanager", "collecmanager", "wastoc");
                System.out.println("Connection to DB etablished.");
            } catch (Exception e) {
                System.out.println("Connection impossible");
            }
        }
    }
    
    public boolean addUser(String name, String surname) {
        try {
            int insert = database.executeUpdate("insert into User (`Name`, `Surname`) VALUES ('" + name + "', '" + surname + "')");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean addDetailsCollection(int userID, int rate){
        try {
            int insert = database.executeUpdate("insert into DetailsCollection (`UserId`, `Rate`) VALUES ('" + userID + "', '" + rate + "')");
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
