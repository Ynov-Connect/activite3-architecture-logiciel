package com.jad.api;

import com.jad.model.SensorData;
import com.jad.model.SensorType;

import java.util.List;

public interface IDataStorage {
    List<SensorData> getAllStoredData();

    List<SensorData> getAllDataBySensorType(SensorType sensorType);
}

