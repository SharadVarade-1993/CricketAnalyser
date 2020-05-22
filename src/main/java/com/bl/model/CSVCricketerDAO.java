package com.bl.model;

import com.bl.analyser.CricketAnalyser;

public class CSVCricketerDAO {
    public int pos;
    public String player;
    public int mat;
    public int inns;
    public int notOut;
    public int runs;
    public String highScore;
    public double avg;
    public int ballsFaced;
    public double strikeRate;
    public int century;
    public int halfCentury;
    public int four;
    public int six;

    public double over;
    public double ballAvg;
    public int wickets;
    public int bbi;
    public double eCon;
    public int fourWicket;
    public int fiveWicket;
    public int boundries;

    public CSVCricketerDAO(BatsmanCSVDAO batsmanCSVDAO) {

        pos = batsmanCSVDAO.pos;
        player = batsmanCSVDAO.player;
        mat = batsmanCSVDAO.mat;
        inns = batsmanCSVDAO.inns;
        notOut = batsmanCSVDAO.notOut;
        runs = batsmanCSVDAO.runs;
        highScore = batsmanCSVDAO.highScore;
        avg = batsmanCSVDAO.avg;
        ballsFaced = batsmanCSVDAO.ballsFaced;
        strikeRate = batsmanCSVDAO.strikeRate;
        century = batsmanCSVDAO.century;
        halfCentury = batsmanCSVDAO.halfCentury;
        four = batsmanCSVDAO.four;
        six = batsmanCSVDAO.six;
        boundries=four+six;
    }

    public CSVCricketerDAO(BowlerCSVDAO bowlerCSVDAO) {
        pos = bowlerCSVDAO.pos;
        player = bowlerCSVDAO.player;
        ballAvg = bowlerCSVDAO.ballAvg;
        mat = bowlerCSVDAO.mat;
        inns = bowlerCSVDAO.inns;
        over = bowlerCSVDAO.over;
        runs = bowlerCSVDAO.runs;
        wickets = bowlerCSVDAO.wickets;
        bbi = bowlerCSVDAO.bbi;
        eCon = bowlerCSVDAO.eCon;
        strikeRate = bowlerCSVDAO.strikeRate;
        fourWicket = bowlerCSVDAO.fourWicket;
        fiveWicket = bowlerCSVDAO.fiveWicket;
    }

    public CSVCricketerDAO() {

    }

    @Override
    public String toString() {
        return "CSVCricketerDAO{" +
                "pos=" + pos +
                ", player='" + player + '\'' +
                ", mat=" + mat +
                ", inns=" + inns +
                ", notOut=" + notOut +
                ", runs=" + runs +
                ", highScore='" + highScore + '\'' +
                ", ballAvg=" + avg +
                ", ballsFaced=" + ballsFaced +
                ", strikeRate=" + strikeRate +
                ", century=" + century +
                ", halfCentury=" + halfCentury +
                ", four=" + four +
                ", six=" + six +
                ", over=" + over +
                ", ballAvg=" + ballAvg +
                ", wickets=" + wickets +
                ", bbi=" + bbi +
                ", eCon=" + eCon +
                ", fourWicket=" + fourWicket +
                ", fiveWicket=" + fiveWicket +
                '}';
    }

    public Object getCricketDTO(CricketAnalyser.Role role) {
        if (role.equals(CricketAnalyser.Role.BATTING))
            return new BatsmanCSVDAO(pos, player, mat, inns, notOut, runs, highScore, avg, ballsFaced, strikeRate, century, halfCentury, four, six);
        return new BowlerCSVDAO(pos, player, mat, inns, over, runs, wickets, bbi, ballAvg, eCon, strikeRate, fourWicket, fiveWicket);
    }
}