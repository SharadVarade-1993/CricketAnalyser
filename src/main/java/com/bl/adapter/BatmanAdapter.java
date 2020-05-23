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
import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;

public class BatmanAdapter extends CricketerAdapter{


    public <E> Map<String, CSVCricketerDAO> loadIPLCricketerData(String... csvFilePath) {
        Map<String, CSVCricketerDAO> batmanMap = super.loadIPLCricketerData(BatsmanCSVDAO.class, csvFilePath[0]);
        if (csvFilePath.length == 2) {
            this.loadBowlerCSVData(batmanMap, csvFilePath[1]);
        }
        return batmanMap;
    }

    public <E> int loadBowlerCSVData(Map<String, CSVCricketerDAO> batmanMap, String csvFilePath) {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))){
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            List<BowlerCSVDAO> csvList = csvBuilder.getListCsvFile(reader, BowlerCSVDAO.class);
            StreamSupport.stream(csvList.spliterator(), false)
                    .filter(cricketCSV -> batmanMap.get(cricketCSV.player) != null)
                    .forEach(cricketCSV -> { batmanMap.get(cricketCSV.player).ballAvg = cricketCSV.ballAvg;
                        batmanMap.get(cricketCSV.player).wickets = cricketCSV.wickets; });
            return batmanMap.size();
        } catch (IOException e) {
            throw new CricketAnalserException(e.getMessage(),CricketAnalserException.ExceptionType.CRICKETER_FILE_PROBLEM);
        }catch(RuntimeException e) {
            throw new CricketAnalserException(e.getMessage(), CricketAnalserException.ExceptionType.FILE_WRONG_HEADER);
        }
    }
}
