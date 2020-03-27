package com.filesloader.tm;

import com.filesloader.tm.contracts.IFileController;
import com.filesloader.tm.contracts.IFileReader;
import com.filesloader.tm.controller.LoaderDaemonController;
import com.filesloader.tm.service.CSVFileReader;
import com.filesloader.tm.service.FileMonitoringService;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 */
public final class App {

    /**
     * @param args The arguments of the program.
     * @throws IOException
     */
    public static void main(String[] args) {       

        String folderPath = "/home/minhaj/Documents/tm-assessment-files";
        IFileReader fileReader = new CSVFileReader();
        IFileController fileController = new LoaderDaemonController();

        Thread fileMonitoringThread = new FileMonitoringService(folderPath, fileReader, fileController);
        fileMonitoringThread.start();

        

    }
}
