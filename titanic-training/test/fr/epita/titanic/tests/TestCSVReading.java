package fr.epita.titanic.tests;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import fr.epita.titanic.datamodel.Passenger;
import fr.epita.titanic.services.GenericCSVReader;

public class TestCSVReading {

    public static final String DELIM = ",";
    public static final String ESCAPE_CHAR = "\"";

    public static void main(String[] args) throws IOException {

        GenericCSVReader csvReader = new GenericCSVReader(DELIM, ESCAPE_CHAR);
        //unit test
        List<String> columnsValues = csvReader.extractColumnValues("892,3,\"Kelly, ,Mr. James\",male,34.5,0,0,330911,7.8292,,Q");
        System.out.println(columnsValues);
        //unit test
        columnsValues = csvReader.extractColumnValues("\"Kelly, ,Mr. James\",892,3,male,34.5,0,0,330911,7.8292,,Q");
        System.out.println(columnsValues);
        System.out.println(columnsValues.size());

        //global test
        List<String> lines = Files.readAllLines(Path.of("S:\\Work\\ae\\Epita\\workspaces\\2021-t3-java-uml-ais\\titanic-training\\test.csv"));
        List<String> errorLines = new ArrayList<>();
        for (String line : lines){
            try {
                System.out.println(csvReader.extractColumnValues(line));
            }catch (Exception e){
                errorLines.add(line);
            }
        }
        lines = Files.readAllLines(Path.of("S:\\Work\\ae\\Epita\\workspaces\\2021-t3-java-uml-ais\\titanic-training\\train.csv"));

        for (String line : lines){
            try {
                System.out.println(csvReader.extractColumnValues(line));
            }catch (Exception e){
                errorLines.add(line);
            }
        }

        System.out.println("errors: " +errorLines);



    }






    public static boolean detectEscapedColumn(String remainingString, String delim, String escapeString) {
        boolean match = true;
        String startToken  = delim + escapeString;
        for (int i = 0; i < delim.length(); i++) {
            if (i <= remainingString.length() - 1) {
                match &= startToken.charAt(i) == remainingString.charAt(i);
            } else {
                return false;
            }
        }
        return match;
    }

}
