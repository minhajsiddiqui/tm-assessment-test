package com.filesloader.tm.contracts;

import java.io.File;
import java.nio.file.Path;
import java.util.List;

public interface IFileReader {
    public List<String[]> readFile(Path file);
}