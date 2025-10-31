package com.jad.api;

import java.util.List;

public interface IDataManager extends IDataProcessor {
    void addDataCollector(ISensor sensor);

    void collectAndStoreData();

    List<SensorData> getAllData();
}

