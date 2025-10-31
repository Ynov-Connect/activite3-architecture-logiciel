package com.jad.api;

public enum LogType {
    INFO("INFO"),
    WARNING("WARNING"),
    ERROR("ERROR");

    private final String logType;

    LogType(String logType) {
        this.logType = logType;
    }

    public String getLogType() {
        return this.logType;
    }
}

