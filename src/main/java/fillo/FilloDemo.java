package fillo;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FilloDemo {
    private static final Logger logger = LogManager.getLogger(Fillo.class);
    final Fillo fillo = new Fillo();
    Connection connection = null;
    private String dataSource;

    public Connection getConnection(String dataSource) throws FilloException {
        try {
            connection = fillo.getConnection(dataSource);
        } catch (FilloException e) {
            logger.error(e.getMessage());
            throw new FilloException("File not found" + e.getMessage());
        }
        return connection;
    }

    public Recordset getRecordSet(String dataSource, String query) throws FilloException {
        Recordset recordSet;
        try {
            recordSet = getConnection(dataSource).executeQuery(query);
        } catch (FilloException e) {
            logger.error(e.getMessage());
            throw new FilloException(e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return recordSet;
    }
}
