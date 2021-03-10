package by.epam.hospital.utils;

import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {

    private static final Logger logger = Logger.getLogger(DatabaseManager.class);

    public static Connection getConnection() {
        Connection conn = null;
        try {
            logger.debug("Try to get connection");
            Context envCtx = (Context) (new InitialContext().lookup("java:/comp/env"));
            DataSource ds = (DataSource) envCtx.lookup("jdbc/hospital");
            conn = ds.getConnection();
        } catch (NamingException e) {
            logger.error("NamingException: ", e);
        } catch (SQLException e) {
            logger.error("SQLException, try to get connection failed: ", e);
        }
        logger.debug(conn);
        return conn;
    }

    public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            logger.error("SQLException thrown when try to close connection: ", e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                logger.error("SQLException thrown when try to close statement: ", e);
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                } catch (SQLException e) {
                    logger.error("SQLException thrown when try to close resultSet: ", e);
                }
            }
        }
    }
}