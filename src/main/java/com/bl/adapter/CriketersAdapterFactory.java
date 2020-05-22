package com.bl.adapter;

import com.bl.analyser.CricketAnalyser;
import com.bl.exception.CricketAnalserException;
import com.bl.model.CSVCricketerDAO;

import java.util.Map;

public class CriketersAdapterFactory {
    public Map<String, CSVCricketerDAO> getCriketersData(CricketAnalyser.Role role, String... csvFilePath) {
        if (role.equals(CricketAnalyser.Role.BATTING))
            return new BatmanAdapter().loadIPLCricketerData(csvFilePath);
        if (role.equals(CricketAnalyser.Role.BOWLING))
            return new BowlerAdapter().loadIPLCricketerData(csvFilePath);
        throw new CricketAnalserException("UNKNOWN PLAYER ROLE", CricketAnalserException.ExceptionType.PLAYER_ROLE_NOT_FOUND);
    }
}