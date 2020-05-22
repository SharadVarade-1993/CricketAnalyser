package com.bl.analyser;

import com.bl.adapter.CriketersAdapterFactory;
import com.bl.exception.CricketAnalserException;
import com.bl.model.CSVCricketerDAO;

import java.util.*;
import java.util.stream.Collectors;

public class CricketAnalyser {

    public enum Role { BATTING, BOWLING }
    private Role role;
    Map<String, CSVCricketerDAO> csvMap = new HashMap<>();
    SortedData sortedData = new SortedData();

    public CricketAnalyser(Role role) throws CricketAnalserException {
        this.role = role;
    }

    public int loadIPLCricketerData(String csvFilePath) {
        csvMap = new CriketersAdapterFactory().getCriketersData(role, csvFilePath);
        return csvMap.size();
    }

    public List getTopBattingAverage(String columnName){
        if (csvMap == null || csvMap.size() == 0){
            throw new CricketAnalserException("No Cricketer Data", CricketAnalserException.ExceptionType.NO_CRICKETER_DATA);
        }
        Comparator<CSVCricketerDAO> dataComparator = sortedData.sortedColumnWiseData(columnName);
       /* ArrayList cricketerDTOS = csvMap.values().stream().
                                    sorted(dataComparator).
                                    map(csvCricketerDAO -> csvCricketerDAO.getCricketDTO(role)).
                                    collect(Collectors.toCollection(ArrayList::new));
        String sortedStateDataJson = new Gson().toJson(cricketerDTOS);
        return sortedStateDataJson;*/

        List sortedList = csvMap.values().stream()
                .sorted(dataComparator)
                .map(csvCricketerDAO -> csvCricketerDAO.getCricketDTO(role))
                .collect(Collectors.toList());
        Collections.reverse(sortedList);
        return sortedList;
    }

}