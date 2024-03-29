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
    public void datasource_is_not_null_test() {
        Assert.assertNotNull(dataSource);
    }

    @Test
    public void connection_is_not_null_test() throws FilloException {
        FilloDemo filloDemo = new FilloDemo(dataSource);
        Connection connection = filloDemo.getConnection();
        Assert.assertNotNull(connection);
        connection.close();
    }

    @Test
    public void recordset_is_not_null_test() throws FilloException {
        FilloDemo filloDemo = new FilloDemo(dataSource);
        String query = "select * from testcases where testcaseid in (select testcaseid from testconfig where execute_flag = 'Y')";
        Recordset recordset = filloDemo.getRecordSet(query);
        Assert.assertNotNull(recordset);
    }

    @Test
    public void testcase_tc001_test() throws IOException, FilloException {
        String query = "select * from testcases where testcaseid in (select testcaseid from testconfig where execute_flag = 'Y')";
        List<Map<String, String>> testStepsList = FilloHelper.getStepsList(query);
        //we can assert a number of things
        //total number of steps should be 12
        Assert.assertEquals(24, testStepsList.size());
    }

}