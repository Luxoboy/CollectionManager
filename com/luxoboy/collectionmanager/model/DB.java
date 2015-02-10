/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luxoboy.collectionmanager.model;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author orann
 */
public class DB {

    /**
     * Attributes
     */
    static private final String hostname = "boxa.noip.me";
    static private final String port = "3306";
    static private final String DataBaseName = "collectionmanager";
    static private final String login = "collecmanager";
    static private final String password = "wastoc";
    private static Connection connection = null;

    /**
     * Return connection to data base
     * @return connection to DB
     */
    static private void createConnection() throws Exception {
        if(connection != null)
            return;
        if(!etablishConnection())
        {
            throw new Exception("Could not connect to database.");
        }
    }
    /**
     * build url before connecting to DB
     * @return the url
     */
    static private String buildUrlJdbc() {
        String urlJdbc;
        urlJdbc = "jdbc:mysql://" + hostname + ":" + port + "/" + DataBaseName;
        urlJdbc = urlJdbc + "?user=" + login + "&password=" + password;
        return urlJdbc;
    }
    /**
     * Private method that can etablished a connection to a DB MySQL
     * @return true if the conneciton is etablished, false otherwise
     */
    static private boolean etablishConnection() {
        boolean statusConnection = false;
        String urlJdbc;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            urlJdbc = buildUrlJdbc();
            connection = DriverManager.getConnection(urlJdbc);
            statusConnection = true;
        } catch (Exception e) {
            statusConnection = false;
            System.out.println("Problem in DBConnection, connection not etablished : " + e);
        }
        return statusConnection;
    }
    
    /**
     * Permit to execute a SELECT query
     * @param sql query to execute
     * @return result of the query (ResultSet)
     * @throws SQLException 
     */
    static public ResultSet executeQuery(String sql) throws SQLException, Exception{
        createConnection();
        return connection.createStatement().executeQuery(sql);
    }
    
    /**
     * Permit to execute other query
     * @param sql query to execute
     * @return result of the query (int)
     * @throws SQLException 
     */
    static public int executeUpdate(String sql) throws SQLException, Exception{
        createConnection();
        return connection.createStatement().executeUpdate(sql);
    }
    
    /**
     * close the connection to the DB
     */
    static public void close(){
        try {
            connection.close();
            connection = null;
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        connection=null;
    }
}
