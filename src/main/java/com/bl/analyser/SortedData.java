package com.bl.analyser;

import com.bl.model.CSVCricketerDAO;

import java.util.Comparator;

public class SortedData {
    protected Comparator sortedColumnWiseData(String columnName)
    {
        Comparator<CSVCricketerDAO> dataComparator = null;
        switch(columnName) {
            case "Avg":
                dataComparator = Comparator.comparing(cricketerCSV -> cricketerCSV.avg);
                break;
            case "StrikeRate":
                dataComparator = Comparator.comparing(cricketerCSV -> cricketerCSV.strikeRate);
                break;
            case "Boundries":
                dataComparator = Comparator.comparing(cricketerCSV -> cricketerCSV.boundries);
                break;
            case "player":
                dataComparator = Comparator.comparing(cricketerCSV -> cricketerCSV.player);
                break;
        }
        return dataComparator;
    }
}