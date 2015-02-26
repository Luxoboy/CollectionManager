/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luxoboy.collectionmanager.view;

import com.luxoboy.collectionmanager.api.model.ModelBase;
import javax.swing.JPanel;

/**
 *
 * @author Anthony Correia <anthony.correia71@gmail.com>
 */
public abstract class DetailsBase extends JPanel
{
    abstract void updateInformations(ModelBase obj);
}
