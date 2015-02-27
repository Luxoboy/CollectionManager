/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luxoboy.collectionmanager.view;

import com.luxoboy.collectionmanager.api.images.ImageSizes;
import com.luxoboy.collectionmanager.api.model.Episode;
import com.luxoboy.collectionmanager.api.model.Image;
import com.luxoboy.collectionmanager.api.model.ModelBase;
import com.luxoboy.collectionmanager.api.model.Season;
import com.luxoboy.collectionmanager.api.model.TVShow;
import java.awt.Desktop;
import java.net.URL;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author orann
 */
public class EpisodeDetails extends DetailsBase {

    private JFrame parent;
    private Episode current_episode;
    /**
     * Creates new form EpisodeDetails
     */
    public EpisodeDetails(JFrame parent) {
        this.parent = parent;
        initComponents();
    }
    
    @Override
    void updateInformations(ModelBase obj)
    {
        if(!(obj instanceof Episode))
        {
            return;
        }
        Episode episode = (Episode)obj;
        episode.load();
        current_episode = episode;
        
        this.name.setText(episode.getName());
        this.yearValue.setText(Integer.toString(ModelBase.getYear(episode.getAir_date())));
        this.episodeNumber.setText(Integer.toString(episode.getEpisode_number()));
        this.descriptionText.setText(episode.getOverview());            
        
        
        picturePanel.removeAll();
        picturePanel.add(new JLabel("Loading..."));
        Image backdrop = episode.getStill(ImageSizes.SizeList.w342);
        picturePanel.removeAll();
        picturePanel.add(new JLabel(new ImageIcon(backdrop.getImg())));
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

        informationPanel = new javax.swing.JPanel();
        infoPanel = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        numberOfSeasonValue = new javax.swing.JLabel();
        yearValue = new javax.swing.JLabel();
        vote_averageValue = new javax.swing.JLabel();
        rateBar1 = new com.luxoboy.collectionmanager.view.RateBar();
        descriptionPanel = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        descriptionScrollPane = new javax.swing.JScrollPane();
        descriptionText = new javax.swing.JTextArea();
        picturePanel = new javax.swing.JPanel();

        setLayout(new java.awt.GridBagLayout());

        informationPanel.setLayout(new java.awt.GridBagLayout());

        infoPanel.setLayout(new java.awt.GridBagLayout());

        name.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        name.setText("Episode name ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        infoPanel.add(name, gridBagConstraints);

        episodeNumber.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        episodeNumber.setText("Episode number ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        infoPanel.add(episodeNumber, gridBagConstraints);

        numberOfSeasonValue.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        numberOfSeasonValue.setText("0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        infoPanel.add(numberOfSeasonValue, gridBagConstraints);

        yearValue.setFont(new java.awt.Font("Calibri", 2, 18)); // NOI18N
        yearValue.setText("00/00/00");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        infoPanel.add(yearValue, gridBagConstraints);

        vote_average.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        vote_average.setText("Vote average");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        infoPanel.add(vote_average, gridBagConstraints);

        vote_averageValue.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        vote_averageValue.setText("9.1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        infoPanel.add(vote_averageValue, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        infoPanel.add(rateBar1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 0);
        informationPanel.add(infoPanel, gridBagConstraints);

        descriptionPanel.setLayout(new java.awt.GridBagLayout());

        description.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        description.setText("Overview");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 0);
        descriptionPanel.add(description, gridBagConstraints);

        addButton.setText("Add to my Collection");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        descriptionPanel.add(addButton, gridBagConstraints);

        descriptionScrollPane.setBorder(null);
        descriptionScrollPane.setViewportBorder(null);

        descriptionText.setEditable(false);
        descriptionText.setColumns(20);
        descriptionText.setLineWrap(true);
        descriptionText.setRows(5);
        descriptionText.setWrapStyleWord(true);
        descriptionText.setBorder(null);
        descriptionText.setDisabledTextColor(javax.swing.UIManager.getDefaults().getColor("textText"));
        descriptionScrollPane.setViewportView(descriptionText);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        descriptionPanel.add(descriptionScrollPane, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        informationPanel.add(descriptionPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 30, 0);
        add(informationPanel, gridBagConstraints);

        picturePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        add(picturePanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private static final javax.swing.JLabel description = new javax.swing.JLabel();
    private javax.swing.JPanel descriptionPanel;
    private javax.swing.JScrollPane descriptionScrollPane;
    private javax.swing.JTextArea descriptionText;
    private static final javax.swing.JLabel episodeNumber = new javax.swing.JLabel();
    private javax.swing.JPanel infoPanel;
    private javax.swing.JPanel informationPanel;
    private javax.swing.JLabel name;
    private javax.swing.JLabel numberOfSeasonValue;
    private javax.swing.JPanel picturePanel;
    private com.luxoboy.collectionmanager.view.RateBar rateBar1;
    private static final javax.swing.JLabel vote_average = new javax.swing.JLabel();
    private javax.swing.JLabel vote_averageValue;
    private javax.swing.JLabel yearValue;
    // End of variables declaration//GEN-END:variables
}
