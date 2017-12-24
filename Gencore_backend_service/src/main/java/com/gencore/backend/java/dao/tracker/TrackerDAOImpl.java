package com.gencore.backend.java.dao.tracker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.hibernate.Hibernate;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.gencore.backend.java.domain.TotalStats;
import com.gencore.backend.java.entity.Device;
import com.gencore.backend.java.entity.GPSLocation;
import com.gencore.backend.java.entity.Course;
import com.gencore.backend.java.entity.UserProfile;

public class TrackerDAOImpl extends HibernateDaoSupport implements TrackerDAO {
    
    private JdbcTemplate jdbcTemplate;

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<GPSLocation> getItinary(String itinaryName) {
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        DetachedCriteria criteria = DetachedCriteria.forClass(GPSLocation.class);
        criteria.add(Restrictions.like("itinaryName", itinaryName));
        List<GPSLocation> locations = hibernateTemplate.findByCriteria(criteria);
        return locations;
    }

    @Override
    public void createGPSLocation(GPSLocation gpsLocation) {
        getHibernateTemplate().saveOrUpdate(gpsLocation); 
    }

    public Device getDeviceByImei(String imei) {

        List list = getHibernateTemplate().find("from Device where imei = ?", imei);

        return (Device) list.get(0);
    }
    
    public void createCourse (Course course) {
        getHibernateTemplate().saveOrUpdate(course);
    }
    

    
    public void updateCourse (Course course) {
        Session s = null;
        try {
            s = getHibernateTemplate().getSessionFactory().openSession( );
            s.beginTransaction();
            s.merge(course);      
            s.getTransaction().commit();
        } catch (Throwable t) {
            logger.error("update Course failed",t);
        } finally {
            s.close();
        }

    }
    

    
    public GPSLocation getStartLocationByCourse ( Course course ) {
      

      Session s = null;
      
      List<GPSLocation> gpsLocation = null;
      
      try {
          
          s = getHibernateTemplate().getSessionFactory().openSession( );

          gpsLocation  = s.createCriteria(GPSLocation.class)
          .createCriteria("course", "mycourse").setMaxResults(1)
          .add(Restrictions.eq("mycourse.id", course.getId()))
          .list();
          
      } catch (Throwable t) {
          logger.error("get start location by course failed", t);
      } finally {
          
          s.close();
      }

      return gpsLocation.get(0);
    }


    public List<Course> getCoursesOfToday() {
        
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        DetachedCriteria criteria = DetachedCriteria.forClass(Course.class);
        
        Date now = new Date();
        
        Date lastTwelveHour = new Date();
        
        long TwelveHourInSecond = 1000 * 60 * 60 * 24;
        
        lastTwelveHour.setTime(now.getTime() - TwelveHourInSecond);
        
        criteria.add(Restrictions.between("endDate",lastTwelveHour , now));

        List<Course> courses = hibernateTemplate.findByCriteria(criteria);
    
        return courses;
    }
    
    public List<Course> getCoursesOfUser(UserProfile user) {      
        HibernateTemplate hibernateTemplate = getHibernateTemplate();
        //List<Course> courses = getHibernateTemplate().find("select courseId , courseType , startDate, endDate, distance from Course where user.id = ?", user.getId());
        List<Course> courses = getHibernateTemplate().find("from Course where user.id = ?", user.getId());        
        return courses;      
    }
    
    public Course getCourseById(String courseId) {
      List list = getHibernateTemplate().find("from Course where courseId = ?", courseId);
      Course course = (Course) list.get(0);
      getHibernateTemplate().initialize(course.getGpsLocations());
      return course;
  }
    
   public List<TotalStats> getTotalDistance() {
        
        List<TotalStats> totalStats = jdbcTemplate.query(
                 "SELECT * FROM total_stats",
                  new RowMapper<TotalStats>(){

                      public TotalStats mapRow(ResultSet rs, int rowNum) throws SQLException {
                          TotalStats total = new TotalStats();
                          total.setType(rs.getString(1));
                          total.setDistance(rs.getDouble(2));
                          return total;
                      }

                  });
         return totalStats;
     }
    
    


}
