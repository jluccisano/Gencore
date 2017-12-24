package com.gencore.backend.java.ws;

import java.util.Date;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.ws.server.endpoint.AbstractMarshallingPayloadEndpoint;

import com.gencore.backend.java.dao.tracker.TrackerDAO;
import com.gencore.backend.java.entity.Device;
import com.gencore.backend.java.entity.Course;
import com.gencore.backend.java.entity.UserProfile;
import com.gencore.backend.java.ws.jaxb.StartTrackingRequest;
import com.gencore.backend.java.ws.jaxb.StartTrackingResponse;
import com.sun.mail.imap.protocol.UID;

public class StartTrackingEndpoint extends AbstractMarshallingPayloadEndpoint {

    private static final Logger LOG = Logger.getLogger(StartTrackingEndpoint.class);

    private TrackerDAO trackerDAO;

    public TrackerDAO getTrackerDAO() {
        return trackerDAO;
    }

    public void setTrackerDAO(TrackerDAO trackerDAO) {
        this.trackerDAO = trackerDAO;
    }

    public StartTrackingEndpoint(Unmarshaller unmarshaller) {
        setUnmarshaller(unmarshaller);
        setMarshaller((Marshaller) unmarshaller);
    }

    @Override
    protected Object invokeInternal(Object rq) throws Exception {
        
         StartTrackingRequest request = (StartTrackingRequest) rq;
         
         String courseId = UUID.randomUUID().toString();
              
         StringBuffer log = new StringBuffer();
         
         log.append(request.getImei() + " | " );
         log.append(request.getStartDate() + " | " );

         LOG.info(log);
         
         Course run = new Course();
         run.setStartDate(new Date(request.getStartDate()));
         run.setStatus(0);
        // run.setCourseType(runType);
         
         run.setCourseId(courseId);

         Device device = trackerDAO.getDeviceByImei(request.getImei());
         run.setUser(device.getUser());      
         this.trackerDAO.createCourse(run);
         
         StartTrackingResponse response = new StartTrackingResponse();
         response.setRunId(courseId);
         response.setStatus(1);
         
        return response;
    }

}
