package com.bl.adapter;

import com.bl.analyser.CricketAnalyser;
import com.bl.model.BatsmanCSVDAO;
import com.bl.model.CSVCricketerDAO;
import java.util.Map;

public class BatmanAdapter extends CricketerAdapter{


    public Map<String, CSVCricketerDAO> loadIPLCricketerData(CricketAnalyser.Role role, String csvFilePath) {
        Map<String, CSVCricketerDAO> batmanMap = super.loadIPLCricketerData(BatsmanCSVDAO.class, role, csvFilePath);
        return batmanMap;
    }
}