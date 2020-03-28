package com.filesloader.tm;

import com.filesloader.tm.contracts.Constants;
import com.filesloader.tm.contracts.IFileController;
import com.filesloader.tm.contracts.IFileReader;
import com.filesloader.tm.controller.LoaderDaemonController;
import com.filesloader.tm.service.CSVFileReader;
import com.filesloader.tm.service.FileMonitoringService;

import java.io.IOException;
import java.util.Map;

/**
 * File Loader Daemon
 */
public final class App {

    /** File Loader Daemon App
     * @param args The arguments of the program.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException{       

        Map<String, String> props = FileLoaderDaemonProp.getInstance().getPropValues();

        IFileReader fileReader = new CSVFileReader();
        IFileController fileController = new LoaderDaemonController();

        Thread fileMonitoringThread = new FileMonitoringService(props.get(Constants.FILE_PATH), fileReader, fileController);
        fileMonitoringThread.start();        
    }
}
