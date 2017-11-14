package com.tactfactory.petsland;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * See package-info about instructions.
 */
public class Application {
    private static String DRIVER    = "jdbc";
    private static String SGBDR     = "mysql";
    private static String HOSTNAME  = "localhost";
    private static short  PORT      = 3306;
    private static String DB_NAME   = "lapi_bar";
    private static String USER      = "root";
    private static String PASSWD    = "jepreferepostgres";

    private static final String SQL_CREATE_TABLE = "CREATE TABLE rabbit("
            + "        id        BigInt NOT NULL ,"
            + "        name      Varchar (50) NOT NULL ,"
            + "        birthdate Date ,"
            + "        color     Varchar (20) NOT NULL ,"
            + "        PRIMARY KEY (id )"
            + ")ENGINE=InnoDB;";

    /**
     * Start endpoint.
     *
     * @param args
     */
    public static void main(String[] args) {
        createDb();
    }

    /**
     * Creates the connection to database.
     *
     * @return
     */
    private static Connection createConnection() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            System.exit(0);
        }

        try {
            String connectionString = String.format("%s:%s://%s:%d/%s", DRIVER, SGBDR, HOSTNAME, PORT, DB_NAME);
            connection = DriverManager.getConnection(connectionString, USER, PASSWD);
        } catch (SQLException e) {
            System.err.println("Connection Failed! Check output console");
            e.printStackTrace();
            System.exit(0);
        }

        return connection;
    }

    /**
     * Creates the table.
     */
    private static void createDb() {
        try (
            Connection connection = createConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_CREATE_TABLE)
        ) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
