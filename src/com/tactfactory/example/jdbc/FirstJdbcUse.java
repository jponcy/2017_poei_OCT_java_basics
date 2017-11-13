package com.tactfactory.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstJdbcUse {
    public static void main(String[] args) {
        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
        }

        try {
            String connectionString = getCntString();
            String user = "root";
            String passwd = "jepreferepostgres";
            conn = DriverManager.getConnection(connectionString, user, passwd);

            System.out.println("Tout c'est bien passé.");
        } catch (SQLException e) {
            System.err.println("Connection Failed! Check output console");
            e.printStackTrace();
        }

        if (conn == null) {
            System.err.println("Failed to make connection!");
        } else {
            System.out.println("You made it, take control your database now!");
            Statement statement = null;

            try {
                statement = conn.createStatement();
                String query = "CREATE TABLE IF NOT EXISTS toto("
                        + "id BIGINT PRIMARY KEY AUTO_INCREMENT, "
                        + "name VARCHAR NOT NULL"
                        + ")ENGINE=innoDB";

                if (statement.execute(query)) {
                    System.out.println("Table created");

                    String insertQuery = "INSERT INTO toto (name) VALUES "
                            + "('mouha'), "
                            + "(\"touha\"),"
                            + "(\"tous ceux qui sont seuls\")";
                    int count = statement.executeUpdate(insertQuery);

                    switch (count) {
                    case 3:
                        System.out.println("All is good");
                        break;
                    case 0:
                        System.err.println(":-(");
                        break;

                    default:
                        System.out.println("Good for " + count + " inserts");
                        break;
                    }
                } else {
                    System.err.println("Table NOT created");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Impossible to close database.");
            e.printStackTrace();
        }
    }

    /**
     * Generates then returns the connection string to database.
     *
     * @return The connection string.
     */
    private static String getCntString() {
        String driver = "jdbc";
        String sgbdr  = "mysql";
        String hostname = "localhost";
        short port = 3306;
        String dbName = "lapi_bar";

        return String.format("%s:%s://%s:%d/%s", driver, sgbdr, hostname,
                port, dbName);
    }
}
