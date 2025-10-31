package com.jad.api;

public enum UserAction {
    ADD_HUMIDITY_SENSOR("addHumiditySensor", "Add a humidity sensor"),
    ADD_TEMPERATURE_SENSOR("addTemperatureSensor", "Add a temperature sensor"),
    ADD_PRESSURE_SENSOR("addPressureSensor", "Add a pressure sensor"),
    ADD_WIND_SPEED_SENSOR("addWindSpeedSensor", "Add a wind speed sensor"),
    DISPLAY("display", "Display dashboard"),
    DISPLAY_ALL("displayAll", "Display all data"),
    REPORT_TEXT("reportText", "Generate a text report"),
    REPORT_CSV("reportCSV", "Generate a CSV report"),
    COLLECT("collect", "Collect data"),
    EXIT("exit", "Exit the application"),
    HELP("help", "Display help");

    private final String userPrompt;
    private final String description;

    UserAction(final String userPrompt, final String description) {
        this.userPrompt = userPrompt;
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public String getUserPrompt() {
        return this.userPrompt;
    }
}

