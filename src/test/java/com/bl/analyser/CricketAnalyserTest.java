package com.bl.analyser;

import com.bl.model.BatsmanCSVDAO;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CricketAnalyserTest {

    private static final String IPL_MOST_RUN_CSV_FILE_PATH = "src/test/resources/IPL2019FactsheetMostRuns.csv";

    @Test
    public void givenIPLCricketLeagueData_WhenSortedOnAvg_ShouldReturnTopBattingAveragePlayer() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser(CricketAnalyser.Role.BATTING);
        cricketAnalyser.loadIPLCricketerData(IPL_MOST_RUN_CSV_FILE_PATH);
        List<BatsmanCSVDAO> topBattingAverage = cricketAnalyser.getTopStatus("Avg");
        Assert.assertEquals("MS Dhoni",topBattingAverage.get(0).player);
    }

    @Test
    public void givenIPLCricketerLeagueData_WhenSortedOnSrikeRate_ShouldReturnTopStrikingRate() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser(CricketAnalyser.Role.BATTING);
        cricketAnalyser.loadIPLCricketerData(IPL_MOST_RUN_CSV_FILE_PATH);
        List<BatsmanCSVDAO> topSrikingRate = cricketAnalyser.getTopStatus("StrikeRate");
        Assert.assertEquals("Ishant Sharma",topSrikingRate.get(0).player);
    }

    @Test
    public void givenIPLCricketerLeagueData_WhenSortedOn6sAnd4s_ShouldReturnMostHitBoundries() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser(CricketAnalyser.Role.BATTING);
        cricketAnalyser.loadIPLCricketerData(IPL_MOST_RUN_CSV_FILE_PATH);
        List<BatsmanCSVDAO> hitBoundries = cricketAnalyser.getTopStatus("Boundries");
        Assert.assertEquals("Andre Russell",hitBoundries.get(0).player);
    }
}