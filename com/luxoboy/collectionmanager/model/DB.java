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
    private String hostname;
    private String port;
    private String DataBaseName;
    private String login;
    private String password;
    private Connection connection;

    /**
     * Constructor
     * @param hostname 
     * @param port 
     * @param DataBaseName
     * @param login 
     * @param password 
     */
    public DB(String hostname, String port, String DataBaseName, String login, String password) {
        this.hostname = hostname;
        this.port = port;
        this.DataBaseName = DataBaseName;
        this.login = login;
        this.password = password;
        connection=getConnection();
    }
    
    /**
     * 
     * @param value new value of the attribute
     */
    public void setLogin(String value) {
        login = value;
    }
    /**
     * 
     * @param value new value of the attribute
     */
    public void setPassword(String value) {
        password = value;
    }
    
    /**
     * 
     * @param value new value of the attribute
     */
    public void setHostname(String value) {
        hostname = value;
    }
    
    /**
     * 
     * @param value new value of the attribute
     */
    public void setPort(String value) {
        port = value;
    }
    /**
     * 
     * @param value new value of the attribute
     */
    public void setDataBaseName(String value) {
        DataBaseName = value;
    }

    /**
     * Return connection to data base
     * @return connection to DB
     */
    private Connection getConnection() {
        if (etablishConnection()) {
            return connection;
        } else {
            
            return null;
        }
    }
    /**
     * build url before connecting to DB
     * @return the url
     */
    private String buildUrlJdbc() {
        String urlJdbc;
        urlJdbc = "jdbc:mysql://" + hostname + ":" + port + "/" + DataBaseName;
        urlJdbc = urlJdbc + "?user=" + login + "&password=" + password;
        return urlJdbc;
    }
    /**
     * Private method that can etablished a connection to a DB MySQL
     * @return true if the conneciton is etablished, false otherwise
     */
    private boolean etablishConnection() {
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
    public ResultSet executeQuery(String sql) throws SQLException{
        return connection.createStatement().executeQuery(sql);
    }
    
    /**
     * Permit to execute other query
     * @param sql query to execute
     * @return result of the query (int)
     * @throws SQLException 
     */
    public int executeUpdate(String sql) throws SQLException{
        return connection.createStatement().executeUpdate(sql);
    }
    
    /**
     * close the connection to the DB
     */
    public void close(){
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
        }
        connection=null;
    }
}
