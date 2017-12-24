package com.gencore.mobile;

import net.rim.device.api.system.EventLogger;

public class BBLogger {

    private static long GUID = 0x71866f95487c7091L;
    private static String APP_NAME = "BBLogger";
    
    private static BBLogger instance = null;
     
    protected BBLogger() {
        EventLogger.register(GUID, APP_NAME, EventLogger.VIEWER_STRING);
    }
    
    public static BBLogger getInstance() {
       if(instance == null) {
          instance = new BBLogger();
       }
       return instance;
    }
    
    private void logEvent(String msg, int level) {
        EventLogger.logEvent(GUID, msg.getBytes(), level);
    }

    public void logDebugEvent(String msg) {
        logEvent(msg, EventLogger.DEBUG_INFO);
    }

    public  void logInformationEvent(String msg) {
        logEvent(msg, EventLogger.INFORMATION);
    }

    public  void logWarningEvent(String msg) {
        logEvent(msg, EventLogger.WARNING);
    }

    public  void logErrorEvent(String msg) {
        logEvent(msg, EventLogger.ERROR);
    }

    public  void logSevereErrorEvent(String msg) {
        logEvent(msg, EventLogger.SEVERE_ERROR);
    }

    public  void logAlwaysEvent(String msg) {
        logEvent(msg, EventLogger.ALWAYS_LOG);
    }
}
