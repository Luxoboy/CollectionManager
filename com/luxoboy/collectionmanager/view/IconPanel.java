/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.luxoboy.collectionmanager.view;

import com.luxoboy.collectionmanager.api.images.ImageSizes;
import com.luxoboy.collectionmanager.api.model.Image;
import com.luxoboy.collectionmanager.api.model.ModelBase;
import com.luxoboy.collectionmanager.api.model.TVShow;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author thiba_000
 */
public class IconPanel extends javax.swing.JPanel {
    
    private ModelBase item; 
    /**
     * Creates new form IconPanel
     */
    public IconPanel(ModelBase i) {
        initComponents();
        this.item = i;
        if(item instanceof TVShow)
        {
            TVShow tvItem = (TVShow)item;
            picturePanel.add(new JLabel("Loading..."));
            Thread t;
            t = new Thread(){
                @Override
                public void run(){
                    try
                    {
                        nameLabel.setText(tvItem.getName());
                        yearLabel.setText(Integer.toString(ModelBase.getYear(tvItem.getFirst_air_date())));
                        Image backdrop = tvItem.getMain_backdrop(ImageSizes.SizeList.w154);
                        picturePanel.removeAll();                  
                        if(backdrop == null){
                            picturePanel.add(new JLabel("Image not available"));
                        }else{
                            picturePanel.add(new JLabel(new ImageIcon(backdrop.getImg())));
                        }
                    }
                    catch(Exception ex)
                    {
                        picturePanel.removeAll();
                        picturePanel.add(new JLabel("Image not available"));
                    }
                    picturePanel.revalidate();
                }               
            };
            t.start();
        }else
        {
        
        }
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

        picturePanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        yearLabel = new javax.swing.JLabel();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new java.awt.GridBagLayout());

        picturePanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        picturePanel.setPreferredSize(new java.awt.Dimension(160, 100));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(picturePanel, gridBagConstraints);

        nameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nameLabel.setText("Name");
        nameLabel.setMaximumSize(new java.awt.Dimension(155, 17));
        nameLabel.setPreferredSize(new java.awt.Dimension(155, 17));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(nameLabel, gridBagConstraints);

        yearLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        yearLabel.setText("Year");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(yearLabel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if(item instanceof TVShow)
        {
            MainFrame.mainFrame.goToDetails((TVShow)item);
        }
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPanel picturePanel;
    private javax.swing.JLabel yearLabel;
    // End of variables declaration//GEN-END:variables
}