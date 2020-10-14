package procamp;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SummerProductsReader {

    public List<RatingSummary> readCsv(String file){
        List<RatingSummary> ratingSummaryList = new ArrayList<>();

        try(FileReader filereader = new FileReader(file); CSVReader csvReader = new CSVReader(filereader)) {
            List<String[]> allData = csvReader.readAll();

            List<String> header = Arrays.asList(allData.get(0));

            for (int i = 1; i < allData.size(); i++) {
                String[] row = allData.get(i);
                ratingSummaryList.add(new RatingSummary(
                        Float.valueOf(row[header.indexOf("price")]),
                        parseInt(row[header.indexOf("rating_count")]),
                        parseInt(row[header.indexOf("rating_five_count")]),
                        row[header.indexOf("origin_country")]));
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ratingSummaryList;
    }

    private Integer parseInt(String intToParse) {
        try {
            return Integer.valueOf(intToParse);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
