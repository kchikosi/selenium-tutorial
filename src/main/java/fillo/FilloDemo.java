package fillo;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * keyword driven testing framework
 */
public class FilloDemo {
    private static final Logger logger = LogManager.getLogger(Fillo.class);
    final Fillo fillo = new Fillo();
    Connection connection = null;
    private final String dataSource;

    public FilloDemo(String dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection() throws FilloException {
        try {
            connection = fillo.getConnection(dataSource);
        } catch (FilloException e) {
            logger.error(e.getMessage());
            throw e;
        }
        return connection;
    }

    public Recordset getRecordSet(String query) throws FilloException {
        Recordset recordSet;
        try {
            recordSet = getConnection().executeQuery(query);
        } catch (FilloException e) {
            logger.error(e.getMessage());
            throw e;
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return recordSet;
    }
}
