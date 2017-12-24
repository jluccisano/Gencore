package com.gencore.mobile;

import net.rim.device.api.ui.UiApplication;

public class Main extends UiApplication {

    static BBLogger logger = BBLogger.getInstance();

    public static void main(String[] args) {

        Main app = new Main();
        app.enterEventDispatcher();
        logger.logInformationEvent("start application");
    }

    public Main() {
        System.out.println("main view has been created");
        logger.logInformationEvent("main view has been created");
        
        pushScreen(new GPSTrackingConfigurationScreen());


    }

}
