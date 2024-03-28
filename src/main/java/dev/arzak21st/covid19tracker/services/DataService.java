
package dev.arzak21st.covid19tracker.services;

import dev.arzak21st.covid19tracker.models.DataRecord;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;

@Service
public class DataService {

//    @PostConstruct // Tells Spring to execute this method right after constructing this Service (DataService)
    public List<DataRecord> getDataRecords(String date) {

        List<DataRecord> dataRecords = null;

        boolean dateIsValid = validateDate(date);
        if(dateIsValid) {

            String formattedDate = formatDate(date);
            if(formattedDate != null) {

                String data = fetchData(formattedDate);
                if(data != null) {

                    dataRecords = mapData(data);
                }
            }
        }

        return dataRecords;
    }

    private boolean validateDate(String date) {

        boolean dateIsValid = false;

        // My very complicated validation code
        String datePattern = "\\d{4}-\\d{2}-\\d{2}"; // "yyyy-MM-dd"
        if(date.matches(datePattern)) {
            dateIsValid = true;
        }

        return dateIsValid;
    }

    private String formatDate(String date) {

        String formattedDate = null;

        try {

            // Format the date from "yyyy-MM-dd" to "MM-dd-yyyy"
            LocalDate localDate = LocalDate.parse(date);
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
            formattedDate = localDate.format(dateTimeFormatter);
        }
        catch(Exception exception) {
            exception.printStackTrace();
        }

        return formattedDate;
    }

    private String fetchData(String date) {

        String data = null;
        StringBuilder dataBuilder = new StringBuilder();

        try {

            // Prepare and open the connection to the server
            String urlString = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_daily_reports/" + date + ".csv";
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Check if the connection is successful
            int responseCode = connection.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_OK) { // 200

                // Read the response from the server
                InputStream inputStream = connection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = bufferedReader.readLine();
                while(line != null) {

                    dataBuilder.append(line + "\n");
                    line = bufferedReader.readLine();
                }

                if(dataBuilder.length() > 0) {
                    data = dataBuilder.toString();
                }
            }
            else { // 404...

                // Alert the user
                System.out.println("Failed to fetch data from: " + urlString);
                System.out.println("Response Code: " + responseCode);
            }
        }
        catch(Exception exception) {
            exception.printStackTrace();
        }

        return data;
    }

    private List<DataRecord> mapData(String data) {

        List<DataRecord> dataRecords = null;
        List<DataRecord> tempDataRecords = new ArrayList<>();

        try {

            // Parse the data into iterable records
            StringReader stringReader = new StringReader(data);
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(stringReader);

            // Prepare each record and add it to the List (tempDataRecords)
            for(CSVRecord record : records) {

                String provinceState = record.get("Province_State");
                String countryRegion = record.get("Country_Region");
                String lastUpdate = record.get("Last_Update");

                int confirmed = 0;
                if(!record.get("Confirmed").equals("")) {
                    confirmed = Integer.parseInt(record.get("Confirmed"));
                }

                int deaths = 0;
                if(!record.get("Deaths").equals("")) {
                    confirmed = Integer.parseInt(record.get("Deaths"));
                }

                int recovered = 0;
                if(!record.get("Recovered").equals("")) {
                    confirmed = Integer.parseInt(record.get("Recovered"));
                }

                DataRecord dataRecord = new DataRecord(provinceState, countryRegion, lastUpdate, confirmed, deaths, recovered);
                tempDataRecords.add(dataRecord);
            }

            if(tempDataRecords.size() > 0) {
                dataRecords = tempDataRecords;
            }
        }
        catch(Exception exception) {
            exception.printStackTrace();
        }

        return dataRecords;
    }
}
