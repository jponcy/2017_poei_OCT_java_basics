package com.tactfactory.petsland;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {
    protected static final String DRIVER      = "jdbc";
    protected static final String SGBDR       = "mysql";
    protected static final String HOSTNAME    = "localhost";
    protected static final short  PORT        = 3306;
    protected static final String DB_NAME     = "lapi_bar";
    protected static final String USER        = "root";
    protected static final String PASSWD      = "jepreferepostgres";

    private static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + RabbitDao.getTableName() + "("
            + "        id        BigInt NOT NULL AUTO_INCREMENT,"
            + "        name      Varchar (50) NOT NULL ,"
            + "        birthdate Date ,"
            + "        color     Varchar (20) NOT NULL ,"
            + "        PRIMARY KEY (id )"
            + ")ENGINE=InnoDB;";

    private static final String SQL_DROP_DB = "DROP DATABASE IF EXISTS " + DB_NAME;
    private static final String SQL_CREATE_DB = "CREATE DATABASE " + DB_NAME;

    private static volatile DatabaseManager instance;
    private final Connection connection;

    private DatabaseManager() {
        this.connection = this.createConnection();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();

        if (!(this.connection == null || this.connection.isClosed())) {
            this.connection.close();
        }
    }

    public static DatabaseManager getInstance() {
        if (DatabaseManager.instance == null) {
            DatabaseManager.instance = new DatabaseManager();
        }

        return DatabaseManager.instance;
    }

    public static Connection getConnection() {
        return DatabaseManager.getInstance().connection;
    }

    /**
     * Creates the connection to database.
     *
     * @see DatabaseManager::DB_NAME
     * @return
     */
    public Connection createConnection() {
        return createConnection(DB_NAME);
    }

    /**
     * Creates the connection to database.
     *
     * @return
     */
    private Connection createConnection(String dbName) {
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            System.exit(0);
        }

        try {
            String connectionString = (dbName == null
                    ? String.format("%s:%s://%s:%d", DRIVER, SGBDR, HOSTNAME, PORT)
                    : String.format("%s:%s://%s:%d/%s", DRIVER, SGBDR, HOSTNAME, PORT, dbName));
            connection = DriverManager.getConnection(connectionString, USER, PASSWD);
        } catch (SQLException e) {
            System.err.println("Connection Failed! Check output console");
            e.printStackTrace();
            System.exit(0);
        }

        return connection;
    }

    public boolean rebuildDatabaseSchema() {
        boolean success = true;

        // Use local connection and not final to reset db.
        try (Connection connection = createConnection(null)) {
            connection.prepareStatement(SQL_DROP_DB).execute();
            connection.prepareStatement(SQL_CREATE_DB).execute();
        } catch (SQLException e) {
            e.printStackTrace();
            success = false;
        }

        try (
            PreparedStatement statementSchema = this.connection.prepareStatement(SQL_CREATE_TABLE);
        ) {
            statementSchema.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            success = false;
        }

        return success;
    }
}
