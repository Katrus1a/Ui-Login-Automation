package com.epam.automation.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface LoggerStrategy {
    void log(String message);
}

class FileLogger implements LoggerStrategy {
    private static final Logger logger = LoggerFactory.getLogger(FileLogger.class);

    @Override
    public void log(String message) {
        logger.info(message);
    }
}
