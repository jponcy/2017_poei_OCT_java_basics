package com.tactfactory.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FirstJdbcUse {
    private static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS %tableName%("
            + "id BIGINT AUTO_INCREMENT PRIMARY KEY, "
            + "name VARCHAR(200) NOT NULL"
            + ")ENGINE=innoDB";
    private static final String ERROR_INSERT_BAD_COUNT = "Good for %count% inserts";
    private static final String ERROR_INSERT = ":-(";
    private static final String SUCCESS_INSERT = "All is good";
    private static final String SQL_INSERT = "INSERT INTO %tableName% (name) VALUES "
            + "('mouha'), "
            + "(\"touha\"),"
            + "(\"tous ceux qui sont seuls\")";
    private static final String ERROR_CLOSE_DB = "Impossible to close database.";
    private static final String TABLE_NAME = "toto";
    private static final String SUCCESS_CREATE_CONN = "You made it, take control your database now!";
    private static final String ERROR_FAIL_CREATE_CONN = "Failed to make connection!";

    /**
     * Main program.
     *
     * @param args
     */
    public static void main(String[] args) {
        Connection conn = null;
        final String tableName = TABLE_NAME;

        conn = createConnection(conn);

        if (conn == null) {
            System.err.println(ERROR_FAIL_CREATE_CONN);
            return;
        }

        System.out.println(SUCCESS_CREATE_CONN);
        List<Statement> statements = new ArrayList<>();

        try {
            // Drop table if exists to assure new.
            statements.add(dropTable(conn, tableName));
            statements.add(createTable(conn, tableName));
            statements.add(insertDataIntoTable(conn, tableName));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            statements.forEach(s -> {
                try {
                    if (s != null && !s.isClosed()) {
                        s.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });

            /*// Strict equivalent of :
            for (Statement s : statements) {
                try {
                    if (s != null && !s.isClosed()) {
                        s.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            */
        }

        selectDataFromTable(conn, tableName);

        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println(ERROR_CLOSE_DB);
            e.printStackTrace();
        }
    }

    /**
     * Print data from table.
     *
     * @param conn
     * @param tableName
     */
    private static void selectDataFromTable(Connection conn, String tableName) {
        try (Statement st = conn.createStatement()) {
            ResultSet resultSet = st.executeQuery("SELECT * FROM " + tableName);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println(String.format("Id:%3d --- name: %s", id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Insert data to table.
     * @param conn
     * @param tableName
     * @return
     * @throws SQLException
     */
    private static Statement insertDataIntoTable(Connection conn, final String tableName) throws SQLException {
        Statement statement = conn.createStatement();
        String insertQuery = SQL_INSERT.replace("%tableName%", tableName);

        int count = statement.executeUpdate(insertQuery);

        switch (count) {
        case 3:
            System.out.println(SUCCESS_INSERT);
            break;
        case 0:
            System.err.println(ERROR_INSERT);
            break;

        default:
            System.out.println(ERROR_INSERT_BAD_COUNT.replace("%count%", String.valueOf(count)));
            break;
        }

        return statement;
    }

    /**
     * Creates the table.
     *
     * @param conn
     * @param tableName
     * @return
     * @throws SQLException
     */
    private static Statement createTable(Connection conn, final String tableName) throws SQLException {
        Statement statement = conn.createStatement();
        String query = SQL_CREATE_TABLE.replace("%tableName%", tableName);

        System.out.println(query);

        statement.execute(query);

        return statement;
    }

    /**
     * Drops the table.
     *
     * @param conn
     * @param tableName
     * @return
     * @throws SQLException
     */
    private static Statement dropTable(Connection conn, final String tableName) throws SQLException {
        Statement statement = conn.createStatement();

        statement.execute("DROP TABLE IF EXISTS " + tableName);

        return statement;
    }

    /**
     * Creates the connection to database.
     *
     * @param conn
     * @return
     */
    private static Connection createConnection(Connection conn) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
        }

        try {
            String connectionString = getConnectionString();
            String user = "root";
            String passwd = "jepreferepostgres";
            conn = DriverManager.getConnection(connectionString, user, passwd);

            System.out.println("Tout c'est bien passé.");
        } catch (SQLException e) {
            System.err.println("Connection Failed! Check output console");
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * Generates then returns the connection string to database.
     *
     * @return The connection string.
     */
    private static String getConnectionString() {
        String driver = "jdbc";
        String sgbdr  = "mysql";
        String hostname = "localhost";
        short port = 3306;
        String dbName = "lapi_bar";

        return String.format("%s:%s://%s:%d/%s", driver, sgbdr, hostname,
                port, dbName);
    }
}
