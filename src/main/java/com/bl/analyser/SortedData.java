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
            case "StrikeRateWith6sAnd4s":
                dataComparator = Comparator.comparing(cricketerCSV -> cricketerCSV.boundries);
                dataComparator = dataComparator.thenComparing(cricketerCSV -> cricketerCSV.strikeRate);
                break;
            case "AverageWithStrikeRate":
                dataComparator = Comparator.comparing(cricketerCSV -> cricketerCSV.avg);
                dataComparator = dataComparator.thenComparing(cricketerCSV -> cricketerCSV.strikeRate);
                break;
            case "MaximumRunsWithAverage":
                dataComparator = Comparator.comparing(cricketerCSV -> cricketerCSV.runs);
                dataComparator = dataComparator.thenComparing(cricketerCSV -> cricketerCSV.avg);
                break;
            case "BallingAvg":
                dataComparator = Comparator.comparing(cricketerCSV -> cricketerCSV.ballAvg);
                break;
            case "StrikingRateOfBowler":
                dataComparator = Comparator.comparing(cricketerCSV -> cricketerCSV.strikeRate);
                break;
            case "EconomyRate":
                dataComparator = Comparator.comparing(cricketerCSV -> cricketerCSV.eCon);
                break;
            case "StrikingRateWith5wAnd4w":
                dataComparator = Comparator.comparing(csvCricketerDAO -> csvCricketerDAO.fiveWicket * 4 + csvCricketerDAO.fourWicket * 5);
                dataComparator = dataComparator.thenComparing(cricketerCSV -> cricketerCSV.strikeRate);
                break;
            case "BowlingAvgWithStrikeRate":
                dataComparator = Comparator.comparing(cricketerCSV -> cricketerCSV.ballAvg);
                dataComparator = dataComparator.thenComparing(csvCricketerDAO -> csvCricketerDAO.strikeRate);
                break;
            case "WicketsWithBowlingAverage":
                dataComparator = Comparator.comparing(cricketerCSV -> cricketerCSV.wickets);
                dataComparator = dataComparator.thenComparing(csvCricketerDAO -> csvCricketerDAO.ballAvg);
                break;
            case "BattingBallingAvg":
                dataComparator = Comparator.comparing(cricketerCSV -> cricketerCSV.avg);
                dataComparator = dataComparator.thenComparing(csvCricketerDAO -> csvCricketerDAO.ballAvg);
                break;
            case "AllRounders":
                dataComparator = Comparator.comparing(cricketerCSV -> { if (cricketerCSV.wickets > 7 && cricketerCSV.runs > 150)
                    return cricketerCSV.runs + cricketerCSV.wickets * 20;
                    return 0;
                });
                break;
            case "player":
                dataComparator = Comparator.comparing(cricketerCSV -> cricketerCSV.player);
                break;
        }
        return dataComparator;
    }
}