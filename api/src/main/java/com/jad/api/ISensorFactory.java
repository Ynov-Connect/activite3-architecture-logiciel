package com.jad.api;

public interface ISensorFactory {
    ISensor make(SensorType sensorType);
}

