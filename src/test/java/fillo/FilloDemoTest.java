package fillo;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Recordset;
import environment.PropertiesManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.*;

public class FilloDemoTest {
    private static final Logger logger = LogManager.getLogger(FilloDemoTest.class);

    private static final String DATASOURCE_PROP = "fillo.test.datasource";
    private String dataSource;

    @Before
    public void initialize() throws IOException {
        dataSource = PropertiesManager.getValue(DATASOURCE_PROP);
    }

    @Test
    public void test_Datasource_IsNotNull() {
        Assert.assertNotNull(dataSource);
    }

    @Test
    public void test_Connection_IsNotNull() throws FilloException {
        FilloDemo filloDemo = new FilloDemo(dataSource);
        Connection connection = filloDemo.getConnection();
        Assert.assertNotNull(connection);
        connection.close();
    }

    @Test
    public void test_RecordSet_IsNotNull() throws FilloException {
        FilloDemo filloDemo = new FilloDemo(dataSource);
        String query = "select * from testcases where testcaseid in (select testcaseid from testconfig where execute_flag = 'Y')";
        Recordset recordset = filloDemo.getRecordSet(query);
        Assert.assertNotNull(recordset);
    }

    @Test
    public void test_testCaseID_TC001() throws IOException {
        FilloDemo filloDemo = new FilloDemo(dataSource);
        String query = "select * from testcases where testcaseid in (select testcaseid from testconfig where execute_flag = 'Y')";
        Recordset recordset = null;
        List<Map<String, String>> testStepsList = new ArrayList<>();
        try {
            recordset = filloDemo.getRecordSet(query);
            //series of events for TC001 record in the spreadsheet
            while (recordset.next()) {
                Map<String, String> testCaseStep = new HashMap<>();
                testCaseStep.put("TestCaseID", recordset.getField("TestCaseID"));
                testCaseStep.put("Keyword", recordset.getField("Keyword"));
                testCaseStep.put("Object", recordset.getField("Object"));
                testCaseStep.put("Data", recordset.getField("Data"));
                testStepsList.add(testCaseStep);
            }
        } catch (FilloException e) {
            logger.error(e.getMessage());
        } finally {
            if (recordset != null) {
                recordset.close();
            }
        }
        logger.info("Test steps list data : " + testStepsList);
        //we can assert a number of things
        //total number of steps should be 6
        Assert.assertEquals(6, testStepsList.size());
    }
}