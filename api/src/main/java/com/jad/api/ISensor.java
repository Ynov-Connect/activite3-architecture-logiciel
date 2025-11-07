package com.jad.api;

import com.jad.model.SensorData;
import com.jad.model.SensorType;

public interface ISensor {
    SensorType getSensorType();

    SensorData getSensorData();
}

