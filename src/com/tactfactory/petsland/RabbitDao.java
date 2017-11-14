package com.tactfactory.petsland;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class RabbitDao extends AbstractDao {
    private static final String SQL_SELECT_ALL = "SELECT * FROM " + getTableName();
    private static final String SQL_INSERT_RABBIT = "INSERT INTO " + getTableName()
            + " (name, birthdate, color) VALUES (?, ?, ?)";

    /**
     * Finds then returns all rabbits from DB.
     *
     * @return
     */
    public List<Rabbit> findAll() {
        List<Rabbit> result = new LinkedList<>();

        try (
            Connection connection = this.createConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL)
        ) {
            statement.execute();
            ResultSet rabbit = statement.getResultSet();

            while (rabbit.next()) {
                result.add(new Rabbit(
                        rabbit.getString("name"),
                        rabbit.getString("birthdate"),
                        rabbit.getString("color")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    private void tune(PreparedStatement st, Rabbit rabbit) throws SQLException {
        st.setString(1, rabbit.getColor());
        st.setString(2, rabbit.getBirthdateAsString());
        st.setString(3, rabbit.getName());
    }

    public void insert(Rabbit rabbit) {
        try (
            Connection connection = createConnection();
            PreparedStatement statementInsert = connection.prepareStatement(SQL_INSERT_RABBIT)
        ) {
            this.tune(statementInsert, rabbit);

            statementInsert.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(List<Rabbit> entities) {
        try (
            Connection connection = createConnection();
            PreparedStatement statementInsert = connection.prepareStatement(SQL_INSERT_RABBIT)
        ) {
            for (Rabbit rabbit : entities) {
                this.tune(statementInsert, rabbit);
                statementInsert.addBatch();
            }

            statementInsert.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static final String getTableName() {
        return "rabbit";
    }
}
