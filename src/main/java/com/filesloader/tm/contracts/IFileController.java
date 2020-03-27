package com.filesloader.tm.contracts;

import java.util.List;
import java.util.Map;

public interface IFileController {
    public void insertFileIntoDB(Map<String, List<String[]>> filesContent);
}