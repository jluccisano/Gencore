package com.gencore.portal.java.log;

import org.apache.log4j.Logger;

public class RemoteLogger {

    private static final Logger LOG = Logger.getLogger(RemoteLogger.class);

    public void debug(String message) {
        LOG.debug(message);
    }

    public void info(String message) {
        LOG.info(message);
    }

    public void warn(String message) {
        LOG.warn(message);
    }

    public void error(String message) {
        LOG.error(message);
    }

    public void fatal(String message) {
        LOG.fatal(message);
    }
}
