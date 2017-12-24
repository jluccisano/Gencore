package com.gencore.backend.java.service.tracker.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.gencore.backend.java.dao.tracker.TrackerDAO;
import com.gencore.backend.java.domain.TotalStats;
import com.gencore.backend.java.entity.GPSLocation;
import com.gencore.backend.java.entity.Course;
import com.gencore.backend.java.entity.UserProfile;
import com.gencore.backend.java.service.admin.UserService;
import com.gencore.backend.java.service.admin.impl.UserServiceImpl;
import com.gencore.backend.java.service.tracker.TrackerService;

public class TrackerServiceImpl implements TrackerService {

    private TrackerDAO trackerDAO;
    
       
    public TrackerDAO getTrackerDAO() {
        return trackerDAO;
    }

    public void setTrackerDAO(TrackerDAO trackerDAO) {
        this.trackerDAO = trackerDAO;
    }

    @Override
    public List<Course> getCoursesOfUser (UserProfile user) {
        return trackerDAO.getCoursesOfUser(user);
    }
    
    @Override
    public Course getCourseById (String courseId) {
        return trackerDAO.getCourseById(courseId);
    }

    @Override
    public List<GPSLocation> getItinary(String itinaryName) {
        return trackerDAO.getItinary(itinaryName);
    }

    @Override
    public void createGPSLocation(GPSLocation gpsLocation) {
        this.trackerDAO.createGPSLocation(gpsLocation);
    }
    
    
    public List<GPSLocation> getAllGPSLocationsByCourse ( String courseName ) {
        
        return null;
    }
    
    public List<Course> getAllCourseByUser ( UserProfile user) {
        
        return null;
    }
    
    public void getStartLocationOfCourse() {
        
    }
    
    public List<Course> getCoursesOfToday () {
        return trackerDAO.getCoursesOfToday();
    }
    
    public List<TotalStats> getTotalDistance() {
        return trackerDAO.getTotalDistance();
    }
    

}
