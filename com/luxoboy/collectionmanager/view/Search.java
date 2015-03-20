/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.luxoboy.collectionmanager.view;

import com.luxoboy.collectionmanager.api.SearchMovie;
import com.luxoboy.collectionmanager.api.SearchTV;
import com.luxoboy.collectionmanager.api.model.Movie;
import com.luxoboy.collectionmanager.api.model.TVShow;
import com.luxoboy.collectionmanager.model.SearchTableModel;
import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author thiba_000
 */
public class Search extends javax.swing.JPanel {

    private MainFrame parent;
    SearchTableModel tableModel;
    
    static private final String LOADING_TEXT = "Fetching data...",
            NO_RESULTS_TEXT = "No results, please verify request.";
    /**
     * Creates new form Search
     */
    public Search(MainFrame parent) {
        this.parent = parent;
        this.tableModel = new SearchTableModel();
        initComponents();
        moviesRadioButton.setSelected(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup = new javax.swing.ButtonGroup();
        searchPanel = new javax.swing.JPanel();
        searchTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        scrollResultsPanel = new javax.swing.JScrollPane();
        resultsTable = new javax.swing.JTable();
        selectPanel = new javax.swing.JPanel();
        moviesRadioButton = new javax.swing.JRadioButton();
        tvShowsRadioButton = new javax.swing.JRadioButton();
        goToButton = new javax.swing.JButton();
        statusLabel = new javax.swing.JLabel();
        statusLabel.setVisible(false);

        setLayout(new java.awt.GridBagLayout());

        searchPanel.setLayout(new java.awt.GridBagLayout());

        searchTextField.setMinimumSize(new java.awt.Dimension(200, 20));
        searchTextField.setPreferredSize(new java.awt.Dimension(200, 20));
        searchTextField.getDocument().addDocumentListener(new DocumentListener()
            {

                @Override
                public void insertUpdate(DocumentEvent e)
                {
                    searchButton.setEnabled(true);
                }

                @Override
                public void removeUpdate(DocumentEvent e)
                {
                    if(searchTextField.getText().equals(""))
                    searchButton.setEnabled(false);
                }

                @Override
                public void changedUpdate(DocumentEvent e)
                {
                }
            });
            searchTextField.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    searchTextFieldActionPerformed(evt);
                }
            });
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
            searchPanel.add(searchTextField, gridBagConstraints);

            searchButton.setText("Search");
            searchButton.setEnabled(false);
            searchButton.addActionListener(new java.awt.event.ActionListener()
            {
                public void actionPerformed(java.awt.event.ActionEvent evt)
                {
                    searchButtonActionPerformed(evt);
                }
            });
            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 0;
            gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
            searchPanel.add(searchButton, gridBagConstraints);

            gridBagConstraints = new java.awt.GridBagConstraints();
            gridBagConstraints.gridx = 1;
            gridBagConstraints.gridy = 1;
            gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
            gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 0);
            add(searchPanel, gridBagConstraints);

            scrollResultsPanel.setVisible(false);

            resultsTable.setModel(tableModel);
            resultsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            resultsTable.addMouseListener(new java.awt.event.MouseAdapter()
            {
                public void mousePressed(java.awt.event.MouseEvent evt)
                {
                    resultsTableMousePressed(evt);
                }
            });
            resultsTable.getSelectionModel().addListSelectionListener(new ListSelectionListener()
                {

                    @Override
                    public void valueChanged(ListSelectionEvent e)
                    {
                        if(resultsTable.getSelectedRowCount() > 0)
                        goToButton.setEnabled(true);
                        else
                        goToButton.setEnabled(false);
                    }
                });
                scrollResultsPanel.setViewportView(resultsTable);

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 2;
                gridBagConstraints.gridwidth = 2;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.insets = new java.awt.Insets(25, 25, 25, 25);
                add(scrollResultsPanel, gridBagConstraints);

                selectPanel.setLayout(new java.awt.GridBagLayout());

                buttonGroup.add(moviesRadioButton);
                moviesRadioButton.setText("Movies");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
                gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 25);
                selectPanel.add(moviesRadioButton, gridBagConstraints);

                buttonGroup.add(tvShowsRadioButton);
                tvShowsRadioButton.setText("TV Shows");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
                selectPanel.add(tvShowsRadioButton, gridBagConstraints);

                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.gridwidth = 2;
                add(selectPanel, gridBagConstraints);

                goToButton.setText("See details");
                goToButton.setEnabled(false);
                goToButton.setVisible(false);
                goToButton.addActionListener(new java.awt.event.ActionListener()
                {
                    public void actionPerformed(java.awt.event.ActionEvent evt)
                    {
                        goToButtonActionPerformed(evt);
                    }
                });
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 4;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
                add(goToButton, gridBagConstraints);

                statusLabel.setText("Informations");
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 3;
                gridBagConstraints.gridwidth = 2;
                gridBagConstraints.insets = new java.awt.Insets(25, 25, 25, 25);
                add(statusLabel, gridBagConstraints);
            }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_searchButtonActionPerformed
    {//GEN-HEADEREND:event_searchButtonActionPerformed
        if(tvShowsRadioButton.isSelected())
        {
            SearchTV search = new SearchTV(searchTextField.getText());
            SearchTableModel model = (SearchTableModel)resultsTable.getModel();
            model.clear();
            statusLabel.setText(LOADING_TEXT);
            statusLabel.setVisible(true);
            scrollResultsPanel.setVisible(false);
            goToButton.setVisible(false);
            for(TVShow show : search.proceed())
            {
                model.addLigneTVShow(show);
            }
            if(model.getRowCount() > 0)
            {
                statusLabel.setVisible(false);
                scrollResultsPanel.setVisible(true);
                goToButton.setVisible(true);
            }
            else
            {
                statusLabel.setText(NO_RESULTS_TEXT);
            }
                
        }
        
        else if(moviesRadioButton.isSelected())
        {
         SearchMovie search = new SearchMovie(searchTextField.getText());
         SearchTableModel model = (SearchTableModel)resultsTable.getModel();
            model.clear();
            statusLabel.setText(LOADING_TEXT);
            statusLabel.setVisible(true);
            scrollResultsPanel.setVisible(false);
            goToButton.setVisible(false);
            for(Movie movie : search.proceed())
            {
                model.addLigneMovie(movie);
            }
            if(model.getRowCount() > 0)
            {
                statusLabel.setVisible(false);
                scrollResultsPanel.setVisible(true);
                goToButton.setVisible(true);
            }
            else
            {
                statusLabel.setText(NO_RESULTS_TEXT);
            }       
        }
        
        else
        {
            System.err.println("Error in searchButtonActionPerformed");
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_searchTextFieldActionPerformed
    {//GEN-HEADEREND:event_searchTextFieldActionPerformed
        if(searchButton.isEnabled())
            searchButtonActionPerformed(null);
    }//GEN-LAST:event_searchTextFieldActionPerformed

    private void resultsTableMousePressed(java.awt.event.MouseEvent evt)//GEN-FIRST:event_resultsTableMousePressed
    {//GEN-HEADEREND:event_resultsTableMousePressed
        if(evt.getClickCount() == 2 && !evt.isConsumed())
            {
                if(tvShowsRadioButton.isSelected())
                {
                    parent.goToDetails((TVShow)tableModel.getModel(resultsTable.getSelectedRow()));
                    evt.consume();
                }
                else if(moviesRadioButton.isSelected())
                {
                    parent.goToDetails((Movie)tableModel.getModel(resultsTable.getSelectedRow()));
                    evt.consume();
                }
                else
                {
                    System.err.println("Error in resultsTableMousePerformed");
                }
                
            }
    }//GEN-LAST:event_resultsTableMousePressed

    private void goToButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_goToButtonActionPerformed
    {//GEN-HEADEREND:event_goToButtonActionPerformed
        if(tvShowsRadioButton.isSelected())
        {
            parent.goToDetails((TVShow)tableModel.getModel(resultsTable.getSelectedRow()));
        }
        else if (moviesRadioButton.isSelected())
        {
            parent.goToDetails((Movie)tableModel.getModel(resultsTable.getSelectedRow()));
        }
        else
        {
            System.err.println("Error in goToButtonActionPerformed");
        }
        
    }//GEN-LAST:event_goToButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton goToButton;
    private javax.swing.JRadioButton moviesRadioButton;
    private javax.swing.JTable resultsTable;
    private javax.swing.JScrollPane scrollResultsPanel;
    private javax.swing.JButton searchButton;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JPanel selectPanel;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JRadioButton tvShowsRadioButton;
    // End of variables declaration//GEN-END:variables
}
