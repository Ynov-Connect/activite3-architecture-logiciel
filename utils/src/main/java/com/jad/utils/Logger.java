package com.jad.utils;

import com.jad.api.ILogger;
import com.jad.api.LogType;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Logger implements ILogger {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public void logInfo(String message) {
        this.log(LogType.INFO, message);
    }

    @Override
    public void log(LogType logType, String message) {
        System.out.println(MessageFormat.format("[{0}] {1} : {2}",
                                                logType.getLogType(),
                                                LocalDateTime.now().format(Logger.DATE_TIME_FORMATTER),
                                                message));
    }

    @Override
    public void logWarning(String message) {
        this.log(LogType.WARNING, message);
    }

    @Override
    public void logError(String message) {
        this.log(LogType.ERROR, message);
    }
}
