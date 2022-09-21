package com.valuemedi.projectenna.domain;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvHelper {
    public static String TYPE = "text/csv";
    public static String[] HEADERs = { "code",	"name",	"batch","stock","deal","free","mrp"	,"rate"	,"exp","company","supplier"
    };

    public static boolean hasCSVFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public static List<Supplier> csvToTutorials(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Supplier> suppliers = new ArrayList<>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

//            for (CSVRecord csvRecord : csvRecords) {
//                Tutorial tutorial = new Tutorial(
//                        Long.parseLong(csvRecord.get("Id")),
//                        csvRecord.get("Title"),
//                        csvRecord.get("Description"),
//                        Boolean.parseBoolean(csvRecord.get("Published"))
//                );
//
//                tutorials.add(tutorial);
//            }

            return suppliers;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

}