package com.gencore.backend.java.ws;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.oxm.Unmarshaller;
import org.springframework.ws.server.endpoint.AbstractMarshallingPayloadEndpoint;

import com.gencore.backend.java.dao.tracker.TrackerDAO;
import com.gencore.backend.java.entity.Device;
import com.gencore.backend.java.entity.GPSLocation;
import com.gencore.backend.java.entity.Course;
import com.gencore.backend.java.utils.TrackerUtils;
import com.gencore.backend.java.ws.jaxb.GPSLocationType;
import com.gencore.backend.java.ws.jaxb.StopTrackingRequest;

public class StopTrackingEndpoint extends AbstractMarshallingPayloadEndpoint {

    private static final Logger LOG = Logger.getLogger(StopTrackingEndpoint.class);

    private TrackerDAO trackerDAO;

    public TrackerDAO getTrackerDAO() {
        return trackerDAO;
    }

    public void setTrackerDAO(TrackerDAO trackerDAO) {
        this.trackerDAO = trackerDAO;
    }

    public StopTrackingEndpoint(Unmarshaller unmarshaller) {
        setUnmarshaller(unmarshaller);
    }

    @Override
    protected Object invokeInternal(Object rq) throws Exception {
     
        StopTrackingRequest request = (StopTrackingRequest) rq;
        

        StringBuffer log = new StringBuffer();
        log.append(request.getImei() + " | " );
        log.append(request.getRunId() + " | " );
        log.append(request.getEndDate() + " | " );
        log.append(request.getGpsLocations() != null ? request.getGpsLocations().getGpsLocations().size() : "0 Element");

        LOG.info(log);
        
        //Retrieve the run associated
        Device device = trackerDAO.getDeviceByImei(request.getImei());
        
        Course run = trackerDAO.getCourseById(request.getRunId());
        
        
        //run.setDistance(distance)
        run.setStatus(1);
        run.setEndDate(new Date(request.getEndDate()));
   
        List<GPSLocationType> gpsLocations =  request.getGpsLocations().getGpsLocations();

        
       for ( GPSLocationType gpsLocationType : gpsLocations) {
            
            GPSLocation gpsLocation = new GPSLocation();
            gpsLocation.setAltitude(gpsLocationType.getAltitude());
            gpsLocation.setAcquisitionDate(new Date(gpsLocationType.getTimestamp()));

            gpsLocation.setLattitude(gpsLocationType.getLattitude());
            gpsLocation.setLongitude(gpsLocationType.getLongitude());
            gpsLocation.setRun(run);
            
            trackerDAO.createGPSLocation(gpsLocation);
        }
       
       long duration = TrackerUtils.getDuration(run.getStartDate(), run.getEndDate());
       double distance = TrackerUtils.getCalculateDistance(gpsLocations);
       double speedAverage = TrackerUtils.getSpeedAverage(distance, duration);
       double kmAverage = TrackerUtils.getKmAverage(distance, duration);
       
       //Calculation stats of run
       run.setDistance(distance);
       run.setSpeedAverage(speedAverage);
       run.setKmAverage(kmAverage);
       
       
       trackerDAO.updateCourse(run);
       
       GPSLocation startLocation  = trackerDAO.getStartLocationByCourse(run);
       
       if (startLocation != null) {
           run.setStartLocation(startLocation);
       }        
        trackerDAO.updateCourse(run);
    
        return null;
    }

}
