/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luxoboy.collectionmanager.view;

import com.luxoboy.collectionmanager.api.images.ImageSizes.SizeList;
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
public class TVShowDetails extends DetailsBase {
    
    private MainFrame parent;
    private TVShow current_tv_show;
    private final DefaultListModel<Season> seasonsModel;

    /**
     * Creates new form Details
     */
    public TVShowDetails(MainFrame parent) {
        seasonsModel = new DefaultListModel<>();
        this.parent = parent;       
        initComponents();
        backButton.setDetailbase(this);
        backButton.setMainFrame(parent);
    }
    
    @Override
    public void updateInformations(ModelBase obj){
        if(!(obj instanceof TVShow))
            return;
        TVShow tv = (TVShow)obj;
        tv.load();
        current_tv_show = tv;
        
        this.name.setText(tv.getName());
        this.descriptionText.setText(tv.getOverview());
        this.numberOfSeasonValue.setText(Integer.toString(tv.getNumber_of_seasons()));
        this.numberOfEpisodesValue.setText(Integer.toString(tv.getNumber_of_episodes()));
        this.vote_averageValue.setText(Double.toString(tv.getVote_average()));
        
        String authors ="";
        for(String author : tv.getAuthors())
            authors+=author+",";
        if(!authors.isEmpty())
            authors = authors.substring(0, authors.length()-1);
        this.authors.setText(authors);
        
        String genres ="";
        for(String genre : tv.getGenres())
            genres+=genre+",";
        if(genres.length() > 0)
            genres = genres.substring(0, genres.length()-1);
        this.genresValue.setText(genres);
        
        this.statusValue.setText(tv.getStatus());
        
        if(tv.getHomepage() != null)
            goToHomepage.setEnabled(true);
        else
            goToHomepage.setEnabled(false);
        
        this.yearValue.setText(Integer.toString(ModelBase.getYear(tv.getFirst_air_date())));
        
        picturePanel.removeAll();
        picturePanel.add(new JLabel("Loading..."));
        Image backdrop = tv.getMain_backdrop(SizeList.w300);
        picturePanel.removeAll();
        picturePanel.add(new JLabel(new ImageIcon(backdrop.getImg())));
        seasonsModel.clear();
        for(Season s : tv.getSeasons())
            seasonsModel.addElement(s);
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
        authors = new javax.swing.JLabel();
        genresValue = new javax.swing.JLabel();
        statusValue = new javax.swing.JLabel();
        vote_averageValue = new javax.swing.JLabel();
        goToHomepage = new javax.swing.JButton();
        numberOfEpisodesValue = new javax.swing.JLabel();
        rateBar = new com.luxoboy.collectionmanager.view.RateBar();
        descriptionPanel = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        descriptionScrollPane = new javax.swing.JScrollPane();
        descriptionText = new javax.swing.JTextArea();
        seasonScollPane = new javax.swing.JScrollPane();
        seasonList = new javax.swing.JList();
        picturePanel = new javax.swing.JPanel();
        backButton = new com.luxoboy.collectionmanager.view.BackButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Details"));
        setLayout(new java.awt.GridBagLayout());

        informationPanel.setLayout(new java.awt.GridBagLayout());

        infoPanel.setLayout(new java.awt.GridBagLayout());

        name.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        name.setText("Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        infoPanel.add(name, gridBagConstraints);

        numberOfSeason.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        numberOfSeason.setText("Number of seasons");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        infoPanel.add(numberOfSeason, gridBagConstraints);

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

        createdBy.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        createdBy.setText("Created by");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        infoPanel.add(createdBy, gridBagConstraints);

        authors.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        authors.setText("Vince Gilligan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        infoPanel.add(authors, gridBagConstraints);

        genres.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        genres.setText("Genres");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        infoPanel.add(genres, gridBagConstraints);

        genresValue.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        genresValue.setText("Drama");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        infoPanel.add(genresValue, gridBagConstraints);

        status.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        status.setText("Status");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        infoPanel.add(status, gridBagConstraints);

        statusValue.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        statusValue.setText("Ended");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        infoPanel.add(statusValue, gridBagConstraints);

        vote_average.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        vote_average.setText("Vote average");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        infoPanel.add(vote_average, gridBagConstraints);

        vote_averageValue.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        vote_averageValue.setText("9.1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        infoPanel.add(vote_averageValue, gridBagConstraints);

        goToHomepage.setText("Go to homepage");
        goToHomepage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToHomepageActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        infoPanel.add(goToHomepage, gridBagConstraints);

        numberOfEpisodes.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        numberOfEpisodes.setText("Number of episodes");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        infoPanel.add(numberOfEpisodes, gridBagConstraints);

        numberOfEpisodesValue.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        numberOfEpisodesValue.setText("98");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        infoPanel.add(numberOfEpisodesValue, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        infoPanel.add(rateBar, gridBagConstraints);

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
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        descriptionPanel.add(descriptionScrollPane, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        infoPanel.add(descriptionPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        informationPanel.add(infoPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(25, 25, 25, 25);
        add(informationPanel, gridBagConstraints);

        seasonScollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        seasonList.setModel(seasonsModel);
        seasonList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        seasonList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                seasonListMouseClicked(evt);
            }
        });
        seasonScollPane.setViewportView(seasonList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 0);
        add(seasonScollPane, gridBagConstraints);

        picturePanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(picturePanel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        add(backButton, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addButtonActionPerformed

    private void goToHomepageActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_goToHomepageActionPerformed
    {//GEN-HEADEREND:event_goToHomepageActionPerformed
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
            try {
                desktop.browse(new URL(current_tv_show.getHomepage()).toURI());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_goToHomepageActionPerformed

    private void seasonListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seasonListMouseClicked
        if(evt.getClickCount() == 2 && !evt.isConsumed()){
            Season season = seasonsModel.get(seasonList.getSelectedIndex());
            parent.goToDetails(season);
            evt.consume();
        }
    }//GEN-LAST:event_seasonListMouseClicked
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel authors;
    private com.luxoboy.collectionmanager.view.BackButton backButton;
    private static final javax.swing.JLabel createdBy = new javax.swing.JLabel();
    private static final javax.swing.JLabel description = new javax.swing.JLabel();
    private javax.swing.JPanel descriptionPanel;
    private javax.swing.JScrollPane descriptionScrollPane;
    private javax.swing.JTextArea descriptionText;
    private static final javax.swing.JLabel genres = new javax.swing.JLabel();
    private javax.swing.JLabel genresValue;
    private javax.swing.JButton goToHomepage;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JPanel informationPanel;
    private javax.swing.JLabel name;
    private static final javax.swing.JLabel numberOfEpisodes = new javax.swing.JLabel();
    private javax.swing.JLabel numberOfEpisodesValue;
    private static final javax.swing.JLabel numberOfSeason = new javax.swing.JLabel();
    private javax.swing.JLabel numberOfSeasonValue;
    private javax.swing.JPanel picturePanel;
    private com.luxoboy.collectionmanager.view.RateBar rateBar;
    private javax.swing.JList seasonList;
    private javax.swing.JScrollPane seasonScollPane;
    private static final javax.swing.JLabel status = new javax.swing.JLabel();
    private javax.swing.JLabel statusValue;
    private static final javax.swing.JLabel vote_average = new javax.swing.JLabel();
    private javax.swing.JLabel vote_averageValue;
    private javax.swing.JLabel yearValue;
    // End of variables declaration//GEN-END:variables
}
