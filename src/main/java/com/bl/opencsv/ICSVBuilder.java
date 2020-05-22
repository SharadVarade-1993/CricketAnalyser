package com.bl.opencsv;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public interface ICSVBuilder {
    public Iterator getCSVFileIterator(Reader reader, Class csvCricketerClass);

    public List getListCsvFile(Reader reader, Class cSVClass);
}
