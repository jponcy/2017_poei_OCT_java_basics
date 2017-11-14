package com.tactfactory.petsland;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * See package-info about instructions.
 */
public class Application {
    private static final String INSERT_FAIL     = "Inserts fail";
    private static final String INSERT_SUCCESS  = "Inserts success";

    private static final String DRIVER      = "jdbc";
    private static final String SGBDR       = "mysql";
    private static final String HOSTNAME    = "localhost";
    private static final short  PORT        = 3306;
    private static final String DB_NAME     = "lapi_bar";
    private static final String TABLE_NAME  = "rabbit";
    private static final String USER        = "root";
    private static final String PASSWD      = "jepreferepostgres";

    private static final String SQL_DROP_DB = "DROP DATABASE IF EXISTS " + DB_NAME;
    private static final String SQL_CREATE_DB = "CREATE DATABASE " + DB_NAME;
    private static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
            + "        id        BigInt NOT NULL AUTO_INCREMENT,"
            + "        name      Varchar (50) NOT NULL ,"
            + "        birthdate Date ,"
            + "        color     Varchar (20) NOT NULL ,"
            + "        PRIMARY KEY (id )"
            + ")ENGINE=InnoDB;";
    private static final String SQL_INSERT_RABBIT = "INSERT INTO " + TABLE_NAME
            + " (name, birthdate, color) VALUES (?, ?, ?)";

    private static final List<Map<String, String>> fixturesData;
    private static final int FIXTURE_LIMIT = 50;

    static {
        fixturesData = new ArrayList<>();
        DateTimeFormatter datetimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String[] colors = {"silver", "pink", "green", "cyan", "navy", "magenta"};

        for (int i = 1; i <= FIXTURE_LIMIT; ++ i) {
            Map<String, String> rabbit = new HashMap<>();

            String birthdate = LocalDate.now().format(datetimeFormatter);
            String color = colors[(new Random()).nextInt(colors.length)];

            rabbit.put("name", "Rabbit n°" + i);
            rabbit.put("birthdate", birthdate);
            rabbit.put("color", color);

            fixturesData.add(rabbit);
        }
    }

    /**
     * Start endpoint.
     *
     * @param args
     */
    public static void main(String[] args) {
        createDb();

        showData();
    }

    private static void showData() {
        try (
            Connection connection = createConnection(DB_NAME);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM " + TABLE_NAME)
        ) {
            statement.execute();
            ResultSet rabbit = statement.getResultSet();

            while (rabbit.next()) {
                System.out.println(String.format(" - %s\n\tbirthdate: %s\n\tcolor: %s",
                        rabbit.getString("name"),
                        rabbit.getString("birthdate"),
                        rabbit.getString("color")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates the connection to database.
     *
     * @return
     */
    private static Connection createConnection(String dbName) {
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

    /**
     * Creates the table.
     */
    private static void createDb() {
        try (Connection connection = createConnection(null)) {
            connection.prepareStatement(SQL_DROP_DB).execute();
            connection.prepareStatement(SQL_CREATE_DB).execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (
            Connection connection = createConnection(DB_NAME);
            PreparedStatement statementSchema = connection.prepareStatement(SQL_CREATE_TABLE);
            PreparedStatement statementInsert = connection.prepareStatement(SQL_INSERT_RABBIT)
        ) {
            int insertCount = 0;
            statementSchema.executeUpdate();
            System.out.println("Table created.");


            for (Map<String, String> rabbit : fixturesData) {
                String color = rabbit.get("color");
                String birthdate = rabbit.get("birthdate");
                String name = rabbit.get("name");

                statementInsert.setString(1, name);
                statementInsert.setString(2, birthdate);
                statementInsert.setString(3, color);

                //insertCount += statementInsert.executeUpdate();
                statementInsert.addBatch();

                System.out.println(String.format("Create rabbit => %s;%s;%s", name, birthdate, color));
            }

            int[] counts = statementInsert.executeBatch();

            for (int count : counts) {
                insertCount += count;
            }

            if (insertCount == fixturesData.size() && fixturesData.size() == FIXTURE_LIMIT) {
                System.out.println(INSERT_SUCCESS);
            } else {
                System.err.println(INSERT_FAIL);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
