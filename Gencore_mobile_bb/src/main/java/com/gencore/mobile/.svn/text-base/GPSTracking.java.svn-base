package com.gencore.mobile;

import java.rmi.RemoteException;

import javax.microedition.location.Criteria;
import javax.microedition.location.Location;
import javax.microedition.location.LocationListener;
import javax.microedition.location.LocationProvider;
import javax.microedition.location.QualifiedCoordinates;

import net.rim.device.api.system.GPRSInfo;

import com.gencore.mobile.bb.GPSLocationType;
import com.gencore.mobile.bb.GPSTrackingService_Stub;

public class GPSTracking {

    public static BBLogger logger = BBLogger.getInstance();
    private LocationProvider provider;
    private int runType;

    private static final int CYCLING_INTERVAL = 3;
    private static final int RUNNING_INTERVAL = 5;
    private static final int WALKING_INTERVAL = 8;

    public GPSTracking(int runType) {

        this.runType = runType;

        resetGPS();

    }

    private void resetGPS() {
        try {

            System.out.println("reset GPS");
            logger.logInformationEvent("reset GPS");

            if (provider != null) {
                provider.setLocationListener(null, 0, 0, 0);
                provider.reset();
                provider = null;

                System.out.println("provider is null");
                logger.logErrorEvent("provider is null");
            }

            Criteria criteria = new Criteria();

            criteria.setHorizontalAccuracy(Criteria.NO_REQUIREMENT);
            criteria.setVerticalAccuracy(Criteria.NO_REQUIREMENT);
            criteria.setCostAllowed(false);
            criteria.setPreferredPowerConsumption(Criteria.POWER_USAGE_MEDIUM);
            criteria.setAltitudeRequired(true);

            provider = LocationProvider.getInstance(criteria);

            provider.setLocationListener(new MyLocationListener(), getIntervalByRunType(runType), -1, -1);

        } catch (Exception e) {

            System.out.println(e.toString());
            logger.logErrorEvent(e.toString());
            e.printStackTrace();
        }

    }

  
    
    private class MyLocationListener implements LocationListener {

        private int i = 0;
        
        public void locationUpdated(LocationProvider provider, Location location) {

            System.out.println("location updated");
            logger.logInformationEvent("location updated");
            


            if (location != null && location.isValid()) {
                QualifiedCoordinates qc = location.getQualifiedCoordinates();
           
                i++;
                logger.logInformationEvent("i: " + i);
                
                    try {                     
                        
                        GPSTrackingService_Stub stub = new GPSTrackingService_Stub();
                        
                        GPSLocationType gpsLocation = new GPSLocationType();

                        gpsLocation.setAltitude(qc.getAltitude());
                        gpsLocation.setLattitude(qc.getLatitude());
                        gpsLocation.setLongitude(qc.getLongitude());
                        gpsLocation.setTimestamp(System.currentTimeMillis());

                        System.out.println("new location updated " + "|" + qc.getLatitude() + ";" + qc.getLongitude() + "|");
                        logger.logInformationEvent( "new location updated " + "|" + qc.getLatitude() + ";" + qc.getLongitude() + "|");

                        
                        if (i == 10) {
                            
                            //Send to server only 10 interval

                            try {
                                stub.sendGPSLocation(GPRSInfo.imeiToString(GPRSInfo.getIMEI()), gpsLocation);
                                logger.logInformationEvent("send Location To the server");
                            } catch (RemoteException e) {
                                logger.logInformationEvent(e.toString());
                                System.out.println(e.toString());
                            }
                            i = 0;
                        }
                        
                        //Store all to the sqlite

                        //SQLiteManager.createDataBase();
                        SQLiteManager.insertGPSLocation(gpsLocation);                      
                        
                    } catch (Exception e) {
                        logger.logInformationEvent(e.toString());
                        System.out.println(e.toString());
                    }                  
                   
                } else {
                    System.out.println("location is not valid");
                    logger.logInformationEvent("location is not valid");
            }
        }

        public void providerStateChanged(LocationProvider provider, int newState) {
            logger.logInformationEvent("state changed: " + newState);
            GPSTracking.this.resetGPS();
        }
    }

    public int getRunType() {
        return runType;
    }

    public void setRunType(int runType) {
        this.runType = runType;
    }

    private int getIntervalByRunType(int runType) {

        int interval = 0;

        switch (runType) {

        case 0:
            interval = CYCLING_INTERVAL;
            break;

        case 1:
            interval = RUNNING_INTERVAL;
            break;

        case 2:
            interval = WALKING_INTERVAL;
            break;

        }
        
        return interval;
    }

}
