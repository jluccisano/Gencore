package com.gencore.backend.test.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gencore.backend.test.BaseTest;
import com.mysql.jdbc.Connection;

public class UserRoleDbTest extends BaseTest {

    private static final String TABLE_NAME = "T_ROLE";
    private static final int ROW_COUNT = 1;

    @Before
    public void init() throws Exception {
        DatabaseOperation.CLEAN_INSERT.execute(getConnection(), getDataSet());
    }

    @After
    public void after() throws Exception {
        // DatabaseOperation.DELETE.execute(getConnection(), getDataSet());
    }

    private IDatabaseConnection getConnection() throws Exception {
        Connection con = (Connection) getTestDataSource().getConnection();

        IDatabaseConnection connection = new DatabaseConnection(con);
        DatabaseConfig config = connection.getConfig();

        config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new MySqlDataTypeFactory());
        config.setProperty(DatabaseConfig.FEATURE_CASE_SENSITIVE_TABLE_NAMES, false);
        return connection;
    }

    private IDataSet getDataSet() throws Exception {
        // get insert data
        FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
        IDataSet dataSet = builder.build(new File(
                "src/test/resources/com/gencore/backend/test/resources/dataset/UserRoleDataSet.xml"));
        return dataSet;
    }

    @Test
    public void testCheckDataLoaded() throws Exception {
        // On récupère notre jeu de données
        IDataSet databaseDataSet = getDataSet();
        // On vérifie que le jeu de données n'est pas nul.
        assertNotNull(databaseDataSet);
        // On compte combien d'enregistrement contient la table
        int rowCount = databaseDataSet.getTable(TABLE_NAME).getRowCount();
        // On le compare avec le nombre d'enregistrement connu
        assertEquals("Le nombre d'enregistrements dans la table \"" + TABLE_NAME + "\" ne correspond pas", ROW_COUNT,
                rowCount);
    }

}
