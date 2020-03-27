package com.filesloader.tm.service;

import java.io.IOException;
import java.nio.file.*;
import java.time.temporal.IsoFields;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.filesloader.tm.contracts.IFileController;
import com.filesloader.tm.contracts.IFileReader;

public class FileMonitoringService extends Thread {

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
        //"/home/minhaj/Documents/tm-assessment-files");

        final WatchKey watchKey = directory.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);

        Map<String, List<String[]>> filesContent = new HashMap<String, List<String[]>>();

        while (true) {
            for (final WatchEvent<?> event : watchKey.pollEvents()) {
                System.out.println(event.kind());
                final Path file = directory.resolve((Path) event.context());

                System.out.println(file.getFileName());

                System.out.println(file + " was last modified at " + file.toFile().lastModified());

                // TODO: Read all three files one by one here
                final List<String[]> data = _fileReader.readFile(file);

                filesContent.put(file.getFileName().toString(), data);

                pushFileToDB(filesContent);

                // Call Dao to Insert Data in MySQL DB
                // Then delete all those files.
            }

            // if(isFileReadyToBePushed) {
            //     pushFileToDB(filesContent);
            // }
        }
    }

    private void pushFileToDB(Map<String, List<String[]>> filesContent) {

        try {
            _fileController.insertFileIntoDB(filesContent);
        } finally {
            isFileReadyToBePushed = false;
        }

    }

    @Override
    public void run() {
        try {
            startMonitoring();
        } catch (final IOException e) {
            // TODO: Use logger
            e.printStackTrace();
        }
    }
}
