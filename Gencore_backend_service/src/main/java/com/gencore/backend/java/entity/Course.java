package com.gencore.backend.java.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Transient;

public class Course {

    private Long id;
    private String courseId;
    private CourseType courseType;
    private UserProfile user;
    private Date startDate;
    private Date endDate;
    private Double distance;
    private Double speedAverage;
    private Double kmAverage;
    private Integer status;
    private GPSLocation startLocation;
    private Set<GPSLocation> gpsLocations;
    
    
    //Transient
//    @Transient
//    private long duration;
    
    
    public Long getId() {
        return id;
        
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCourseId() {
        return courseId;
    }
    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }
    public CourseType getCourseType() {
        return courseType;
    }
    public void setCourseType(CourseType runType) {
        this.courseType = runType;
    }
    public UserProfile getUser() {
        return user;
    }
    public void setUser(UserProfile user) {
        this.user = user;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public Double getDistance() {
        return distance;
    }
    public void setDistance(Double distance) {
        this.distance = distance;
    }
    public Double getSpeedAverage() {
        return speedAverage;
    }
    public void setSpeedAverage(Double speedAverage) {
        this.speedAverage = speedAverage;
    }
    public Double getKmAverage() {
        return kmAverage;
    }
    public void setKmAverage(Double kmAverage) {
        this.kmAverage = kmAverage;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public GPSLocation getStartLocation() {
        return startLocation;
    }
    public void setStartLocation(GPSLocation startLocation) {
        this.startLocation = startLocation;
    }
    public Set<GPSLocation> getGpsLocations() {
        return gpsLocations;
    }
    public void setGpsLocations(Set<GPSLocation> gpsLocations) {
        this.gpsLocations = gpsLocations;
    }
//    public long getDuration() {
//        return duration;
//    }
//    public void setDuration(long duration) {
//        this.duration = duration;
//    }

    
    
    
    
   

}
