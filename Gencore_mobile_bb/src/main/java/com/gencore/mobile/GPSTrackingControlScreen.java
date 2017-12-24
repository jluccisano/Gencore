package com.gencore.mobile;

import java.io.IOException;
import java.rmi.RemoteException;

import net.rim.device.api.system.GPRSInfo;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.MainScreen;

import com.gencore.mobile.bb.GPSLocationArray;
import com.gencore.mobile.bb.GPSTrackingService_Stub;
import com.gencore.mobile.bb.StartTrackingResponse;

final class GPSTrackingControlScreen extends MainScreen {

    public static BBLogger logger = BBLogger.getInstance();

    
    private String log;
    private int runType;
    private ButtonField btnPlay;
    private ButtonField btnStop;
    private StartTrackingResponse response = null;

    public GPSTrackingControlScreen(int runType) {

        this.runType = runType;

        btnPlay = new ButtonField("Play");
        btnPlay.setChangeListener(new PlayButtonListener());

        btnStop = new ButtonField("Stop");
        btnStop.setChangeListener(new StopButtonListener());

        HorizontalFieldManager _fieldManagerBottom = new HorizontalFieldManager();

        _fieldManagerBottom.add(btnPlay);
        _fieldManagerBottom.add(btnStop);
        
        add(_fieldManagerBottom);
        
        System.out.println("création de la vue de contrôle");
        
        try {
            if (SQLiteManager.checkIfDataBaseNotExit()) {
                logger.logInformationEvent("The database doesn't exist");
                SQLiteManager.createDataBase();
            }
        } catch (IOException e) {
            logger.logErrorEvent("error lors du check de la database " + e.getMessage());
        }
        
       // SQLiteManager.createDataBase();
        
        SQLiteManager.cleanGpsLocation();
    }

    final class PlayButtonListener implements FieldChangeListener {

        private boolean isPause;

        public void fieldChanged(Field field, int context) {

            if (isPause) {
                btnPlay.setLabel("Play");
                isPause = false;
            } else {
                isPause = true;
                btnPlay.setLabel("Pause");
            }

            // Send first WebService
            startTracking();

            // Commencer à envoyer des données toutes les 10 secondes
            new GPSTracking(runType);

        }
    }

    final class StopButtonListener implements FieldChangeListener {
        public void fieldChanged(Field field, int context) {

            // Stop tracking

            // Get all data store
            GPSLocationArray gpsLocationArray = new GPSLocationArray();
            gpsLocationArray.setGpsLocations(SQLiteManager.getGpsLocations());

            Long time = new Long(System.currentTimeMillis());
            // Send all data
            GPSTrackingService_Stub stub = null;
            try {
                stub = new GPSTrackingService_Stub();
                stub.stopTracking(response.getRunId(), time, GPRSInfo.imeiToString(GPRSInfo.getIMEI()), gpsLocationArray);
                System.out.println("envoi du stop tracking: " + gpsLocationArray.getGpsLocations().length);
                logger.logInformationEvent("envoi du stop tracking: " + gpsLocationArray.getGpsLocations().length);
            
            } catch (RemoteException e) {
                logger.logErrorEvent("stop tracking failed");
            }

        }
    }

    public void startTracking() {
        GPSTrackingService_Stub stub = null;
       
        try {
            
            stub = new GPSTrackingService_Stub();
            response = stub.startTracking(System.currentTimeMillis(), GPRSInfo.imeiToString(GPRSInfo.getIMEI()));
            logger.logInformationEvent("runId response: " + response.getRunId() + " status: " + response.getStatus());
            System.out.println("envoi du start tracking");
            logger.logInformationEvent("envoi du start tracking");
        } catch (RemoteException e) {
            logger.logErrorEvent("start tracking failed" + e.getMessage() + e.toString());
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    public int getRunType() {
        return runType;
    }

    public void setRunType(int runType) {
        this.runType = runType;
    }

}
