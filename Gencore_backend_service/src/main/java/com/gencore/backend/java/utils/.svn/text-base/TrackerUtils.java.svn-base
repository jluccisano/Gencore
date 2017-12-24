package com.gencore.backend.java.utils;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.gencore.backend.java.ws.jaxb.GPSLocationType;

import flex.messaging.io.ArrayList;

public class TrackerUtils {

    private static Logger LOG = Logger.getLogger(TrackerUtils.class);
    
    public static void main (String args[]) {
        
        List<GPSLocationType> gpsLocations = new ArrayList();
        
        GPSLocationType point1 = new GPSLocationType();
        point1.setAltitude(253);
        point1.setLattitude(43.61151);
        point1.setLongitude(1.33264);
        Date date1 = new Date(2010,12,2,9,4,21);
        point1.setTimestamp(date1.getTime());
        
        GPSLocationType point2 = new GPSLocationType();
        point1.setAltitude(199);
        point1.setLattitude(43.535924);
        point1.setLongitude(1.513584);
        Date date2 = new Date(2010,12,2,9,33,53);
        point1.setTimestamp(date2.getTime());
        
        gpsLocations.add(point1);
        gpsLocations.add(point2);
        
        Double distance = getCalculateDistance(gpsLocations);
        Long duration = getDuration(date1, date2);
        Double speed = getSpeedAverage(distance, duration);
        Double km = getKmAverage(distance,duration);
        
        System.out.println("dist: " + distance  + " ; duration: " + duration + " ; speed: " + speed + " ; km: " + km);
        
    }
    
    public static Double getCalculateDistance(List<GPSLocationType> gpsLocations) {

        // Calcul de la distance parcourue
        double distance = 0;

        for (int d = 0; d < gpsLocations.size() - 1; d++) {

            GPSLocationType point1 = gpsLocations.get(d);
            GPSLocationType point2 = gpsLocations.get(d + 1);

            distance = TrackerUtils.getDistanceBetween2Coordinates(point1.getLattitude(), point1.getLongitude(), point2
                    .getLattitude(), point2.getLongitude())
                    + distance;
        }

        LOG.info(distance);
        
        return distance;
    }

    public static Double getDistanceBetween2Coordinates(Double lat1, Double long1, Double lat2, Double long2) {

        double d = 0;

        try {

            double a = Math.PI / 180;
            double rLat1 = lat1 * a;
            double rLat2 = lat2 * a;
            double rLong1 = long1 * a;
            double rLong2 = long2 * a;

            double t1 = Math.sin(rLat1) * Math.sin(rLat2);
            double t2 = Math.cos(rLat1) * Math.cos(rLat2);
            double t3 = Math.cos(rLong1 - rLong2);
            double t4 = t2 * t3;
            double t5 = t1 + t4;
            double rad_dist = Math.atan(-t5 / Math.sqrt(-t5 * t5 + 1)) + 2 * Math.atan(1);

            d = (rad_dist * 3437.74677 * 1.1508) * 1.6093470878864446;

        } catch (NullPointerException e) {

        }

        LOG.info(d);
        return d;
    }

    public static Long getDuration(Date startDate, Date endDate) {

        long duration = 0;
        try {

            duration = endDate.getTime() - startDate.getTime();

        } catch (NullPointerException e) {

        }

        LOG.info(duration);
        
        // return duration in ms
        return duration;

    }

    public static Double getSpeedAverage(Double distance, Long duration) {

        double avgSpeed = 0;

        try {

            double duration_to_hours = (double) duration / (double) (1000 * 60 * 60);

            // return km/h
            avgSpeed = (double) distance / (double) duration_to_hours;

        } catch (NullPointerException e) {

        }

        return avgSpeed;
    }

    public static Double getKmAverage(Double distance, Long duration) {

        double avgKm = 0;

        try {

            double duration_to_minutes = (double) duration / (double) (1000 * 60);

            // return km/h
            avgKm = (double) duration_to_minutes / (double) distance;

        } catch (NullPointerException e) {

        }

        return avgKm;
    }

}
