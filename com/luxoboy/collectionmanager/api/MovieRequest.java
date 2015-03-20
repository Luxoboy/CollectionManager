/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luxoboy.collectionmanager.api;

import com.luxoboy.collectionmanager.api.model.Movie;
import java.util.ArrayList;

/**
 * Interface used for requests which generates new Movie.
 * @author orann
 */
public interface MovieRequest {
     public ArrayList<Movie> proceed();
}
