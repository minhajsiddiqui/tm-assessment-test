package com.filesloader.tm.service;

import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.filesloader.tm.contracts.IFileController;
import com.filesloader.tm.contracts.IFileReader;

import org.apache.log4j.Logger;

public class FileMonitoringService extends Thread {

    final static Logger logger = Logger.getLogger(FileMonitoringService.class);

    private final String _folderPath;
    private final IFileReader _fileReader;
    private final IFileController _fileController;

    boolean isFileReadyToBePushed = false;

    public FileMonitoringService(final String folderPath, final IFileReader fileReader,
            final IFileController fileController) {
        _folderPath = folderPath;
        _fileReader = fileReader;
        _fileController = fileController;
    }

    public void startMonitoring() throws IOException {

        final WatchService watchService = FileSystems.getDefault().newWatchService();

        final Path directory = Paths.get(_folderPath);

        final WatchKey watchKey = directory.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

        Map<String, List<String[]>> filesContent = new HashMap<String, List<String[]>>();

        while (true) {
            for (final WatchEvent<?> event : watchKey.pollEvents()) {
                System.out.println(event.kind());
                final Path file = directory.resolve((Path) event.context());

                logger.info("Reading file content => " + file);

                // TODO: Read all three files one by one here
                final List<String[]> data = _fileReader.readFile(file);

                filesContent.put(file.getFileName().toString(), data);

                logger.info("Pushing data to DB Started");

                _fileController.insertFileIntoDB(filesContent);

                logger.info("Pushing data to DB Completed");

                logger.info("Deleting file ==> " + file);

                if (file.toFile().delete()) {
                    logger.info("File Deleted ==> " + file);
                } else {
                    logger.error("Unable to Delete file  ==> " + file);
                }                
            }
        }
    }

    @Override
    public void run() {
        try {
            startMonitoring();
        } catch (final IOException e) {
            // TODO: Use logger
            e.printStackTrace();
            
            logger.error(e);
        }
    }
}
