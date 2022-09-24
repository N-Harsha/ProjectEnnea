package com.valuemedi.projectenna.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Service
public class CSVServiceImpl implements CSVService {
    @Override
    public String Save(MultipartFile file) {
        File savefile = new File("src/main/resources/Inventory.csv");
        InputStream initialStream;
        byte[] buffer;
        try {
            initialStream = file.getInputStream();
            buffer = new byte[initialStream.available()];
            initialStream.read(buffer);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
        try (OutputStream outStream = new FileOutputStream(savefile)) {
            outStream.write(buffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
