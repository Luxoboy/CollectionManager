/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luxoboy.collectionmanager.view;

import com.luxoboy.collectionmanager.api.SearchTV;
import com.luxoboy.collectionmanager.api.model.TVShow;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 *
 * @author orann
 */
public class UserCollection extends javax.swing.JPanel {

    private MainFrame parent;
    
    /**
     * Creates new form List
     */
    public UserCollection(MainFrame parent) {
        this.parent = parent;
        initComponents();
        //itemPanel.setMaximumSize(parent.getSize());
        itemPanel.setSize(new Dimension(parent.getWidth(), 1));
        itemScrollPane.setPreferredSize(new Dimension(parent.getWidth() - 50, parent.getHeight() - (menuPanel.getHeight() + 100)));
        itemPanel.revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup = new javax.swing.ButtonGroup();
        menuPanel = new javax.swing.JPanel();
        searchButton = new javax.swing.JButton();
        searchTextField = new javax.swing.JTextField();
        movieRadioButton = new javax.swing.JRadioButton();
        tvRadioButton = new javax.swing.JRadioButton();
        itemScrollPane = new javax.swing.JScrollPane();
        itemPanel = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(500, 75));
        setLayout(new java.awt.GridBagLayout());

        menuPanel.setLayout(new java.awt.GridBagLayout());

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        menuPanel.add(searchButton, gridBagConstraints);

        searchTextField.setMinimumSize(new java.awt.Dimension(100, 20));
        searchTextField.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        menuPanel.add(searchTextField, gridBagConstraints);

        buttonGroup.add(movieRadioButton);
        movieRadioButton.setText("Movie");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        menuPanel.add(movieRadioButton, gridBagConstraints);

        buttonGroup.add(tvRadioButton);
        tvRadioButton.setSelected(true);
        tvRadioButton.setText("TV Show");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        menuPanel.add(tvRadioButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(menuPanel, gridBagConstraints);

        itemScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        itemScrollPane.setPreferredSize(new java.awt.Dimension(200, 200));
        itemScrollPane.setViewportView(itemPanel);
        itemPanel.setLayout(new WrapLayout());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(itemScrollPane, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        itemPanel.removeAll();
        SearchTV search = new SearchTV(searchTextField.getText());
        for(TVShow tv : search.proceed()){
            itemPanel.add(new IconPanel(tv));
        }
        if(itemPanel.getComponentCount() == 0){
            itemPanel.add(new JLabel("No result correspond to your search"));
        }
        itemScrollPane.setViewportView(itemPanel);
    }//GEN-LAST:event_searchButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JPanel itemPanel;
    private javax.swing.JScrollPane itemScrollPane;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JRadioButton movieRadioButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JRadioButton tvRadioButton;
    // End of variables declaration//GEN-END:variables
}
