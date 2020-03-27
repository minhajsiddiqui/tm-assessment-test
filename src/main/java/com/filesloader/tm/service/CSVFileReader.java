package com.filesloader.tm.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.filesloader.tm.contracts.IFileReader;


//TODO: In future we can make it more generic to read any file
// And conver it into List<T> i:e = IFileReader<T>
public class CSVFileReader implements IFileReader {

    @Override
    public List<String[]> readFile(Path file) {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        List<String[]> fileObjectList = new ArrayList<>();

        try {

            br = new BufferedReader(new FileReader(file.toFile()));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] row = line.split(cvsSplitBy);

                fileObjectList.add(row);

                System.out.println(row);
            }

            // Removing header
            fileObjectList.remove(0);

            return fileObjectList;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}