package com.jad.api;

import com.jad.model.SensorType;

public interface ISensorFactory {
    ISensor make(SensorType sensorType);
}

