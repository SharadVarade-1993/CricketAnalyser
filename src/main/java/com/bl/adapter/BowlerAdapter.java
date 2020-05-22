package com.bl.adapter;



import com.bl.model.BowlerCSVDAO;
import com.bl.model.CSVCricketerDAO;

import java.util.Map;

public class BowlerAdapter extends CricketerAdapter{

    public Map<String, CSVCricketerDAO> loadIPLCricketerData(String... csvFilePath) {
        Map<String, CSVCricketerDAO> bowlermap = super.loadIPLCricketerData(BowlerCSVDAO.class, csvFilePath[0]);
        return bowlermap;
    }
}