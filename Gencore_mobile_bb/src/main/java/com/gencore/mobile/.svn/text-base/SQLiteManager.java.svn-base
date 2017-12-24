package com.gencore.mobile;

import java.io.IOException;

import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;

import net.rim.device.api.database.Database;
import net.rim.device.api.database.DatabaseFactory;
import net.rim.device.api.database.Row;
import net.rim.device.api.database.Statement;
import net.rim.device.api.io.URI;

import com.gencore.mobile.bb.GPSLocationType;

public class SQLiteManager {

    public static BBLogger logger = BBLogger.getInstance();
    
    static Database d;


    private static String CREATE_SCHEMA = "CREATE TABLE IF NOT EXISTS gpslocation "
            + "(id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "latitude DOUBLE,longitude DOUBLE,"
            + "altitude FLOAT,time TIMESTAMP)";

    public static String INSERT_GPSLOCATION = "INSERT INTO gpslocation ('latitude','longitude','altitude','time') "
            + "VALUES (?,?,?,?)";

    // SDCard path
    public static String DATABASE_PATH = "file:///SDCard/luccitTracker/db/GpsLocationDB.db";
    
    // Intern memory
    //public static String DATABASE_PATH = "file:///store/home/user/GpsLocationDB.db";

    public static String SELECT_COUNT_GPSLOCATION = "SELECT count(id) FROM gpslocation";

    public static String SELECT_GPSLOCATION = "SELECT * FROM gpslocation";

    public static String CLEAN_GPSLOCATION = "DELETE FROM gpslocation";

    public static boolean checkIfDataBaseNotExit() throws IOException { 
        
        boolean result = false;
        FileConnection fc = null;
        
        try 
        {
             fc = (FileConnection)Connector.open(DATABASE_PATH);
             // If no exception is thrown, then the URI is valid, but the file may or may not exist.
             if (!fc.exists())
             {
                 result = true;
             } else {
                 
                 logger.logInformationEvent("The database is already exist");
                 result = false;
             }
            
            
         }
         catch (IOException ioe) 
         {
            logger.logErrorEvent("Impossible to check database " + ioe.getMessage());
            System.out.println(ioe.getMessage() );
         } finally {
             fc.close();
         }
         return result;

    }
    public static void createDataBase() {

       
        try {
            URI myURI = URI.create(DATABASE_PATH);
            d = DatabaseFactory.create(myURI);
            Statement st = d.createStatement(CREATE_SCHEMA);

            st.prepare();
            st.execute();
            st.close();
            d.close();

            System.out.println("create database");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.logErrorEvent(e.getMessage());
        }

    }

    public static void deleteDatabase() {

        try {
            URI myURI = URI.create(DATABASE_PATH);
            DatabaseFactory.delete(myURI);

            System.out.println("delete database");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.logErrorEvent(e.getMessage());
        }

    }

    public static void insertGPSLocation(GPSLocationType gpsLocation) {

        try {
            URI myURI = URI.create(DATABASE_PATH);
            d = DatabaseFactory.open(myURI);

            Statement st = d.createStatement(INSERT_GPSLOCATION);

            st.prepare();

            st.bind(1, gpsLocation.getLattitude());
            st.bind(2, gpsLocation.getLongitude());
            st.bind(3, gpsLocation.getAltitude());
            st.bind(4, gpsLocation.getTimestamp());

            st.execute();
            st.reset();
            st.close();
            d.close();

            System.out.println("insert data: " + gpsLocation.getLattitude() + "," + gpsLocation.getLongitude());
            logger.logInformationEvent("insert data: " + gpsLocation.getLattitude() + "," + gpsLocation.getLongitude());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.logSevereErrorEvent(e.toString());
           
        }

    }

    public static void cleanGpsLocation() {

        try {
            URI myURI = URI.create(DATABASE_PATH);
            d = DatabaseFactory.open(myURI);

            Statement st = d.createStatement(CLEAN_GPSLOCATION);
            st.prepare();
            st.execute();
            st.close();
            d.close();

            System.out.println("clean table");
            logger.logInformationEvent("clean database");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.logErrorEvent("clean database failed");

        }

    }

    public static Integer getCountOfGpsLocation() {

        Integer result = null;
        try {
            URI myURI = URI.create(DATABASE_PATH);
            
            logger.logInformationEvent("uri: " + myURI.getPath());
            d = DatabaseFactory.open(myURI);
            
            logger.logInformationEvent("uri: " + d.getFile());

            Statement st = d.createStatement(SELECT_COUNT_GPSLOCATION);

            st.prepare();
            net.rim.device.api.database.Cursor c = st.getCursor();

            Row r;
            boolean first = c.first();
            System.out.println("positionné: " + first + " , " + c.getPosition());
            
            logger.logInformationEvent("positionné: " + first + " , " + c.getPosition());
            r = c.getRow();

            System.out.println(r.getInteger(0));
            
            logger.logInformationEvent("resultSet: " + r.getInteger(0));

            result = new Integer(r.getInteger(0));
            
            logger.logInformationEvent("result: " + result);

            st.close();
            d.close();

            System.out.println("get count: " + result);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.logInformationEvent("error " + e.getMessage());
        }

        return result;
    }

    public static GPSLocationType[] getGpsLocations() {

        GPSLocationType[] result = null;

        try {
            
            Integer count = getCountOfGpsLocation();
            logger.logInformationEvent("count: " + count);
            
            
            URI myURI = URI.create(DATABASE_PATH);
            d = DatabaseFactory.open(myURI);

            Statement st = d.createStatement(SELECT_GPSLOCATION);

            st.prepare();
            net.rim.device.api.database.Cursor c = st.getCursor();

            result = new GPSLocationType[count.intValue()];

            Row r;
            int i = 0;
            while (c.next()) {
                r = c.getRow();
                

                GPSLocationType current = new GPSLocationType();
                current.setLattitude(r.getDouble(1));
                current.setLongitude(r.getDouble(2));
                current.setAltitude(r.getFloat(3));
                current.setTimestamp(r.getLong(4));

                result[i] = current;
                
                i++;
                
            }
            if (i == 0) {

                logger.logInformationEvent("No data in the table");

                System.out.println("No data in the People table");
            }
            st.close();
            d.close();

            System.out.println("taille gpsLocations" + result.length);
            logger.logInformationEvent("taille gpsLocations" + result.length);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.logInformationEvent(e.toString());
        }

        return result;

    }

}
