package com.bl.adapter;


import com.bl.analyser.CricketAnalyser;
import com.bl.model.BowlerCSVDAO;
import com.bl.model.CSVCricketerDAO;

import java.util.Map;

public class BowlerAdapter extends CricketerAdapter{

    public Map<String, CSVCricketerDAO> loadIPLCricketerData(CricketAnalyser.Role role, String csvFilePath) {
        Map<String, CSVCricketerDAO> bowlermap = super.loadIPLCricketerData(BowlerCSVDAO.class, role, csvFilePath);
        return bowlermap;
    }
}