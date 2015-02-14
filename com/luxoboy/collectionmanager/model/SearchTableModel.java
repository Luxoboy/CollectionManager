/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luxoboy.collectionmanager.model;

import com.luxoboy.collectionmanager.api.model.ModelBase;
import com.luxoboy.collectionmanager.api.model.TVShow;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thiba_000
 */
public class SearchTableModel extends DefaultTableModel
{

    private class Line
    {

        String name;
        int year;
        String vote_average;
        TVShow tvs;

        public Line(TVShow show)
        {
            this.tvs = show;
            this.name = show.getName();
            this.year = ModelBase.getYear(show.getFirst_air_date());
            Double vote_average_raw = show.getVote_average();
            if(vote_average_raw <= 0.0)
            {
                this.vote_average = "Unknown";
            }
            else
            {
                this.vote_average = Double.toString(vote_average_raw);
            }
        }

    }
    private String[] header =
    {
        "Name", "Year", "Vote average"
    };
    private ArrayList<Line> list = new ArrayList();

    public SearchTableModel()
    {
        super();
    }
    
    public TVShow getTVShow(int row)
    {
        return list.get(row).tvs;
    }

    @Override
    public Object getValueAt(int row, int column)
    {
        switch (column)
        {
            case 0:
                return list.get(row).name;
            case 1:
                return list.get(row).year;
            case 2:
                return list.get(row).vote_average;
            default:
                return null;
        }
    }

    @Override
    public int getRowCount()
    {
        try
        {
            return list.size();
        } catch (Exception e)
        {
            return 0;
        }
    }

    @Override
    public int getColumnCount()
    {
        return header.length;
    }

    @Override
    public String getColumnName(int column)
    {
        return header[column];
    }

    public String getRowNomInfo(int row)
    {
        return list.get(row).name;
    }

    public void addLigne(TVShow show)
    {
        addLine(new Line(show));
    }

    private void addLine(Line l)
    {
        list.add(l);
        fireTableRowsInserted(list.size() - 1, list.size() - 1);
    }

    public void removeLine(int index)
    {
        list.remove(index);
        fireTableRowsDeleted(index, index);
    }

    public void removeLine(Line line)
    {
        int index = list.indexOf(line);
        list.remove(line);
        fireTableRowsDeleted(index, index);
    }

    public void clear()
    {
        int size = list.size();
        list.clear();
        fireTableRowsDeleted(0, size);
    }

    @Override
    public boolean isCellEditable(int i, int i1)
    {
        return false;
    }
}
