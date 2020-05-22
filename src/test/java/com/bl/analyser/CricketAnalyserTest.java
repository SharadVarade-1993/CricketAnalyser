package com.bl.analyser;

import com.bl.model.BatsmanCSVDAO;
import org.junit.Assert;
import org.junit.Test;
import com.bl.model.BowlerCSVDAO;

import java.util.List;

public class CricketAnalyserTest {

    private static final String IPL_MOST_RUN_CSV_FILE_PATH = "src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static final String IPL_MOST_WICKETS_CSV_FILE_PATH = "src/test/resources/IPL2019FactsheetMostWkts.csv";

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
    @Test
    public void givenIPLCricketerLeagueData_WhenSortedOnStrikeRateWith6sAnd4s_ShouldReturnBestStrikingRateWith6sAnd4s() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser(CricketAnalyser.Role.BATTING);
        cricketAnalyser.loadIPLCricketerData(IPL_MOST_RUN_CSV_FILE_PATH);
        List<BatsmanCSVDAO> bestStrikerateAnd6sAnd4s = cricketAnalyser.getTopStatus("StrikeRateWith6sAnd4s");
        Assert.assertEquals("Andre Russell",bestStrikerateAnd6sAnd4s.get(0).player);
    }

    @Test
    public void givenIPLCricketerLeagueData_WhenSortedOnAverageWithStrikeRate_ShouldReturnGreatAverageWithBestStrikingRate() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser(CricketAnalyser.Role.BATTING);
        cricketAnalyser.loadIPLCricketerData(IPL_MOST_RUN_CSV_FILE_PATH);
        List<BatsmanCSVDAO> greatAvgWithBestStrikeRate = cricketAnalyser.getTopStatus("AverageWithStrikeRate");
        Assert.assertEquals("MS Dhoni",greatAvgWithBestStrikeRate.get(0).player);
    }

    @Test
    public void givenIPLCricketerLeagueData_WhenSortedOnRunWithAverage_ShouldReturnMaximumRunWithBestAverage() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser(CricketAnalyser.Role.BATTING);
        cricketAnalyser.loadIPLCricketerData(IPL_MOST_RUN_CSV_FILE_PATH);
        List<BatsmanCSVDAO> greatAvgWithBestStrikeRate = cricketAnalyser.getTopStatus("MaximumRunsWithAverage");
        Assert.assertEquals("David Warner",greatAvgWithBestStrikeRate.get(0).player);
    }

    @Test
    public void givenIPLCricketerLeagueData_WhenSortedOnAverage_ShouldReturnTopBowlingAverage() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser(CricketAnalyser.Role.BOWLING);
        cricketAnalyser.loadIPLCricketerData(IPL_MOST_WICKETS_CSV_FILE_PATH);
        List<BowlerCSVDAO> greatAvgWithBestStrikeRate = cricketAnalyser.getTopStatus("BallingAvg");
        Assert.assertEquals("Krishnappa Gowtham",greatAvgWithBestStrikeRate.get(0).player);
    }

    @Test
    public void givenIPLCricketerLeagueData_WhenSortedOnStrikingRate_ShouldReturnTopStrikingRateOfBowler() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser(CricketAnalyser.Role.BOWLING);
        cricketAnalyser.loadIPLCricketerData(IPL_MOST_WICKETS_CSV_FILE_PATH);
        List<BowlerCSVDAO> greatAvgWithBestStrikeRate = cricketAnalyser.getTopStatus("StrikingRateOfBowler");
        Assert.assertEquals("Krishnappa Gowtham",greatAvgWithBestStrikeRate.get(0).player);
    }

    @Test
    public void givenIPLCricketerLeagueData_WhenSortedOnEconomyRate_ShouldReturnBestEconomyRateOfBowler() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser(CricketAnalyser.Role.BOWLING);
        cricketAnalyser.loadIPLCricketerData(IPL_MOST_WICKETS_CSV_FILE_PATH);
        List<BowlerCSVDAO> greatAvgWithBestStrikeRate = cricketAnalyser.getTopStatus("EconomyRate");
        Assert.assertEquals("Ben Cutting",greatAvgWithBestStrikeRate.get(0).player);
    }

    @Test
    public void givenIPLCricketerLeagueData_WhenSortedOnStrikingRateWith5wAnd4w_ShouldReturnBestStrikingRateWith5wAnd4wOfBowler() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser(CricketAnalyser.Role.BOWLING);
        cricketAnalyser.loadIPLCricketerData(IPL_MOST_WICKETS_CSV_FILE_PATH);
        List<BowlerCSVDAO> greatAvgWithBestStrikeRate = cricketAnalyser.getTopStatus("StrikingRateWith5wAnd4w");
        Assert.assertEquals("Krishnappa Gowtham",greatAvgWithBestStrikeRate.get(0).player);
    }

    @Test
    public void givenIPLCricketerLeagueData_WhenSortedOnBowlingAverageWithStrikingRate_ShouldReturnGreatBowlingAverageWithBestStrikingRateOfBowler() {
        CricketAnalyser cricketAnalyser = new CricketAnalyser(CricketAnalyser.Role.BOWLING);
        cricketAnalyser.loadIPLCricketerData(IPL_MOST_WICKETS_CSV_FILE_PATH);
        List<BowlerCSVDAO> greatAvgWithBestStrikeRate = cricketAnalyser.getTopStatus("BowlingAvgWithStrikeRate");
        Assert.assertEquals("Krishnappa Gowtham",greatAvgWithBestStrikeRate.get(0).player);
    }
}