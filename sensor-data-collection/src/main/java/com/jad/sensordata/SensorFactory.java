package com.jad.sensordata;

import com.jad.api.ISensor;
import com.jad.api.ISensorFactory;
import com.jad.model.SensorType;

public class SensorFactory implements ISensorFactory {
    @Override
    public ISensor make(SensorType sensorType) {
        return switch (sensorType) {
            case TEMPERATURE -> new TemperatureSensor();
            case HUMIDITY -> new HumiditySensor();
            case PRESSURE -> new PressureSensor();
            case WIND_SPEED -> new WindSpeedSensor();
        };
    }
}
