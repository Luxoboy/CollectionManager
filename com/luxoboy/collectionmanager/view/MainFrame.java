/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luxoboy.collectionmanager.view;

import com.luxoboy.collectionmanager.api.model.TVShow;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 *
 * @author thiba_000
 */
public class MainFrame extends javax.swing.JFrame
{

    private final Search searchView;
    private final Details detailsView;
    private final UserCollection userCollectionView;

    /**
     * Creates new form MainFrame
     */
    public MainFrame()
    {
        initComponents();
        this.searchView = new Search(this);
        this.detailsView = new Details(this);
        this.userCollectionView = new UserCollection(this);
    }
    
    public void goToDetails(TVShow tvs)
    {
        this.setContentPane(detailsView);
        detailsView.updateInformations(tvs);
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

        menuBar = new javax.swing.JMenuBar();
        moviesMenu = new javax.swing.JMenu();
        tvShowsMenu = new javax.swing.JMenu();
        searchMenu = new javax.swing.JMenu();
        searchMenuItem = new javax.swing.JMenuItem();
        aboutMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        moviesMenu.setText("Movies");
        moviesMenu.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                moviesMenuMouseClicked(evt);
            }
        });
        menuBar.add(moviesMenu);

        tvShowsMenu.setText("TV Shows");
        tvShowsMenu.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                tvShowsMenuMouseClicked(evt);
            }
        });
        menuBar.add(tvShowsMenu);

        searchMenu.setText("Search");

        searchMenuItem.setText("Search");
        searchMenuItem.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                searchMenuItemActionPerformed(evt);
            }
        });
        searchMenu.add(searchMenuItem);

        menuBar.add(searchMenu);

        aboutMenu.setText("?");
        menuBar.add(aboutMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void moviesMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moviesMenuMouseClicked
        // TODO add your handling code here:
        this.setContentPane(detailsView);
        this.pack();
    }//GEN-LAST:event_moviesMenuMouseClicked

    private void tvShowsMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tvShowsMenuMouseClicked
        // TODO add your handling code here:
        this.setContentPane(userCollectionView);
        this.pack();
    }//GEN-LAST:event_tvShowsMenuMouseClicked

    private void searchMenuItemActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_searchMenuItemActionPerformed
    {//GEN-HEADEREND:event_searchMenuItemActionPerformed
        this.setContentPane(searchView);
        this.pack();
    }//GEN-LAST:event_searchMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        try
        {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new MainFrame().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu aboutMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu moviesMenu;
    private javax.swing.JMenu searchMenu;
    private javax.swing.JMenuItem searchMenuItem;
    private javax.swing.JMenu tvShowsMenu;
    // End of variables declaration//GEN-END:variables
}
