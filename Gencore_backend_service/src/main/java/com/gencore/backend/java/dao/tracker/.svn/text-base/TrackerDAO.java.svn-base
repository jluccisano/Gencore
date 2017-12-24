package com.gencore.backend.java.dao.tracker;

import java.util.List;

import com.gencore.backend.java.domain.TotalStats;
import com.gencore.backend.java.entity.Device;
import com.gencore.backend.java.entity.GPSLocation;
import com.gencore.backend.java.entity.Course;
import com.gencore.backend.java.entity.UserProfile;

public interface TrackerDAO {

    List<GPSLocation> getItinary(String itinaryName);

    void createGPSLocation(GPSLocation gpsLocation);
    
    Device getDeviceByImei(String imei);
    
    void createCourse (Course course);

    
    void updateCourse (Course course);
    
    List<Course> getCoursesOfToday();
    
    GPSLocation getStartLocationByCourse ( Course course );
    
    List<Course> getCoursesOfUser(UserProfile user);
    
    Course getCourseById(String courseId);
    
    List<TotalStats> getTotalDistance();
    

}
