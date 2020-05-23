package com.bl.adapter;

import com.bl.exception.CricketAnalserException;
import com.bl.model.BatsmanCSVDAO;
import com.bl.model.BowlerCSVDAO;
import com.bl.model.CSVCricketerDAO;
import com.bl.opencsv.CSVBuilderFactory;
import com.bl.opencsv.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;

public  class CricketerAdapter {

    public<E> Map<String, CSVCricketerDAO> loadIPLCricketerData(Class<E> csvCricketerClass, String csvFilePath) {
        Map<String,CSVCricketerDAO> csvMap = new HashMap<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))){
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            List<E> CSVList = csvBuilder.getListCsvFile(reader, csvCricketerClass);
            if (csvCricketerClass.getName().equals("com.bl.model.BatsmanCSVDAO")) {
                StreamSupport.stream(CSVList.spliterator(), false)
                        .map(BatsmanCSVDAO.class::cast)
                        .forEach(cricketerCSV -> csvMap.put(cricketerCSV.player, new CSVCricketerDAO(cricketerCSV)));
            }else if (csvCricketerClass.getName().equals("com.bl.model.BowlerCSVDAO")){
                StreamSupport.stream(CSVList.spliterator(), false)
                        .map(BowlerCSVDAO.class::cast)
                        .forEach(cricketerCSV -> csvMap.put(cricketerCSV.player, new CSVCricketerDAO(cricketerCSV)));
            }
            return csvMap;
        }catch (IOException e) {
            throw new CricketAnalserException(e.getMessage(),CricketAnalserException.ExceptionType.CRICKETER_FILE_PROBLEM);
        }catch(RuntimeException e) {
            throw new CricketAnalserException(e.getMessage(), CricketAnalserException.ExceptionType.FILE_WRONG_HEADER);
        }
    }
}
