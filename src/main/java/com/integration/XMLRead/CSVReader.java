package com.integration.XMLRead;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import de.siegmar.fastcsv.reader.CsvParser;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvRow;

/**
 * Hello world!
 *
 */
public class CSVReader 
{
    public static void main( String[] args )
    {
    	File file = new File("C:\\Users\\vibsharma\\Documents\\FAST-2\\Dun\\extracts\\Account.csv");
    	CsvReader csvReader = new CsvReader();

    	try (CsvParser csvParser = csvReader.parse(file, StandardCharsets.UTF_8)) {
    	    CsvRow row;
    	    while ((row = csvParser.nextRow()) != null) {
    	       // System.out.println("Read line: " + row);
    	       // System.out.println("First column of line: " + row.getField(0));
    	    	System.out.println(row.getOriginalLineNumber());
    	    }
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
