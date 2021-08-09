package fillo;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Recordset;
import environment.PropertiesManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FilloDemoTest {

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
        FilloDemo filloDemo = new FilloDemo();
        Connection connection = filloDemo.getConnection(dataSource);
        Assert.assertNotNull(connection);
        connection.close();
    }

    @Test
    public void test_RecordSet_IsNotNull() throws FilloException {
        FilloDemo filloDemo = new FilloDemo();
        String query = "select * from TestCases where TestCaseId in (select TestCaseId from TestConfig where Execute_Flag = 'Y')";
        Recordset recordset = filloDemo.getRecordSet(dataSource, query);
        Assert.assertNotNull(recordset);
    }

    @Test
    public void test_testCaseID_TC001() throws FilloException, IOException {
        FilloDemo filloDemo = new FilloDemo();
        String query = "select * from TestCases where TestCaseId in (select TestCaseId from TestConfig where Execute_Flag = 'Y')";
        String datasource = PropertiesManager.getValue(DATASOURCE_PROP);
        Recordset recordset = filloDemo.getRecordSet(datasource, query);
        Map<String, String> testCaseData = new HashMap<>();
        //series of events for TC001 record in the spreadsheet
        while (recordset.next()) {
            testCaseData.put("TestCaseID", recordset.getField("TestCaseID"));
            testCaseData.put("Keyword", recordset.getField("Keyword"));
            testCaseData.put("Object", recordset.getField("Object"));
            testCaseData.put("Data", recordset.getField("Data"));
            System.out.println(testCaseData);
        }
        //we can assert a number of things
        //total number of steps should be 6
        Assert.assertEquals(6, recordset.getCount());
    }
}