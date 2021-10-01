package fillo;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import environment.PropertiesManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.*;

/**
 * Utility to perform operation on a spreadsheet using Fillo framework
 * @author KC
 * @version 1.0
 */
public class FilloUtils {
    private static final Logger logger = LogManager.getLogger(FilloUtils.class);

    /**
     * Reads a list of steps required to perform an operation from spreadsheet
     * @param query sql statement
     * @return list of steps
     */
    public static List<Map<String, String>> getStepsList(String query) throws IOException, FilloException {
        List<Map<String, String>> testStepsList = new ArrayList<>();
        String dataSource = PropertiesManager.getValue("fillo.test.datasource");
        Connection connection = new Fillo().getConnection(dataSource);
        Recordset recordset = connection.executeQuery(query);
        try {
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
        return testStepsList;
    }

    /**
     * Search through list of steps for a particular column and return the value
     * @param testStepsList arraylist of steps
     * @param columnName user interface widget in spreadsheet
     * @return value equivalent to a user entry via the user-interface
     */
    public static Optional<String> getDataByColumnName(List<Map<String, String>> testStepsList, String columnName) {
        return testStepsList.stream()
                .filter(s -> s.get("Object").contains(columnName))
                .map(u -> u.get("Data"))
                .findFirst();
    }
}
