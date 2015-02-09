/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.luxoboy.collectionmanager.model;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thiba_000
 */
public class SearchTableModel extends DefaultTableModel{
    private class Line {
        
        String name, year;
        int seasonNumber;

        public Line(String name, String year, int seasonNumber) {
            this.name = name;
            this.year = year;
            this.seasonNumber = seasonNumber;
        }

    }
    private String[] header = {"Name","Year", "Season Number"};
    private ArrayList<Line> list = new ArrayList();

    public SearchTableModel() {
        super();
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return list.get(row).name;
            case 1:
                return list.get(row).year;
            case 2:
                return list.get(row).seasonNumber;
            default:
                return null;
        }
    }

    @Override
    public int getRowCount() {
        try{
            return list.size();
        }catch(Exception e){
            return 0;
        }
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }
    
    public String getRowNomInfo(int row){
        return list.get(row).name;
    }

    public void addLigne(String name, String date, int seasonNumber) {
        addLine(new Line(name, date, seasonNumber));
    }

    private void addLine(Line l) {
        list.add(l);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
    }

    public void removeLine(int index) {
        list.remove(index);
        fireTableRowsDeleted(index, index);
    }
    
    @Override
    public boolean isCellEditable(int i, int i1) {
        return false;
    }
}
