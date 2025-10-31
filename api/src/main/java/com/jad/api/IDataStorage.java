package com.jad.api;

import java.util.List;

public interface IDataStorage {
    List<SensorData> getAllStoredData();

    List<SensorData> getAllDataBySensorType(SensorType sensorType);
}

