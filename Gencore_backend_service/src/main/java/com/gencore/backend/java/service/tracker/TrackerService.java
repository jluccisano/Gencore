package com.gencore.backend.java.service.tracker;

import java.util.List;

import com.gencore.backend.java.domain.TotalStats;
import com.gencore.backend.java.entity.GPSLocation;
import com.gencore.backend.java.entity.Course;
import com.gencore.backend.java.entity.UserProfile;

public interface TrackerService {

    List<GPSLocation> getItinary(String itinaryName);

    void createGPSLocation(GPSLocation gpsLocation);
    
    List<Course> getCoursesOfToday ();
    
    List<Course> getCoursesOfUser (UserProfile user);
    
    Course getCourseById (String courseId);
    
    List<TotalStats> getTotalDistance();
}
