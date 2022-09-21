package com.valuemedi.projectenna.controller.v1;

import com.valuemedi.projectenna.Service.CSVService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@ResponseBody
@RequestMapping("api/csv/upload")
public class CsvController {

    CSVService csvService;

    public CsvController(CSVService csvService) {
        this.csvService = csvService;
    }

    @PostMapping
    public String csvUpload(@RequestParam("file")MultipartFile file){
        String message="";

        csvService.Save(file);

        return message;
    }
}