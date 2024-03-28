
package dev.arzak21st.covid19tracker.controllers;

import dev.arzak21st.covid19tracker.models.DataRecord;
import dev.arzak21st.covid19tracker.services.DataService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DataController {

    @Autowired
    DataService dataService;

    @GetMapping(path = {"/", "/data"})
    public String getDataRecords(@RequestParam(name = "date", defaultValue = "none") String date, Model model) {

        if(date.equals("none")){

            //date = LocalDate.now().toString(); // The current date
            date = "2023-03-09"; // This is the last update date
        }

        List<DataRecord> dataRecords = dataService.getDataRecords(date);

        model.addAttribute("date", date);
        model.addAttribute("dataRecords", dataRecords);

        return "data";
    }
}
