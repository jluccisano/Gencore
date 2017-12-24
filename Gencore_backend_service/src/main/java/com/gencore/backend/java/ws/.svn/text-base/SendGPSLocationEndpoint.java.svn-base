package com.gencore.backend.java.ws;

import org.apache.log4j.Logger;
import org.springframework.oxm.Unmarshaller;
import org.springframework.ws.server.endpoint.AbstractMarshallingPayloadEndpoint;

import com.gencore.backend.java.dao.tracker.TrackerDAO;

public class SendGPSLocationEndpoint extends AbstractMarshallingPayloadEndpoint {

    private static final Logger LOG = Logger.getLogger(SendGPSLocationEndpoint.class);

    private TrackerDAO trackerDAO;

    public TrackerDAO getTrackerDAO() {
        return trackerDAO;
    }

    public void setTrackerDAO(TrackerDAO trackerDAO) {
        this.trackerDAO = trackerDAO;
    }

    public SendGPSLocationEndpoint(Unmarshaller unmarshaller) {
        setUnmarshaller(unmarshaller);
    }

    @Override
    protected Object invokeInternal(Object rq) throws Exception {
        // TODO Auto-generated method stub
        // CoordinateRequest request = (CoordinateRequest) rq;
        //        
        // StringBuffer log = new StringBuffer();
        // log.append(request.getCoordinate().getLattitude() + " | " );
        // log.append(request.getCoordinate().getLongitude() + " | " );
        // log.append(request.getCoordinate().getAltitude() + " | " );
        // log.append(request.getCoordinate().getImei() + " | " );
        // log.append(request.getCoordinate().getTimestamp() + " | " );
        // log.append(request.getCoordinate().getItinaryName());
        //
        // LOG.debug(log);
        //
        // GPSLocation gpsLocation = new GPSLocation();
        // gpsLocation.setLattitude(request.getCoordinate().getLattitude());
        // gpsLocation.setLongitude(request.getCoordinate().getLongitude());
        // gpsLocation.setAltitude(request.getCoordinate().getAltitude());
        //        
        // Date timestamp = new Date();
        // timestamp.setTime(request.getCoordinate().getTimestamp());
        //        
        // gpsLocation.setDate(timestamp);
        // gpsLocation.setImei(request.getCoordinate().getImei());
        // // gpsLocation.setItinaryName(request.getCoordinate().getItinaryName());
        //
        // this.trackerDAO.createGPSLocation(gpsLocation);

        return null;
    }

}
