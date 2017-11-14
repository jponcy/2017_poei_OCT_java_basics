package com.tactfactory.petsland;

import java.sql.Connection;

public abstract class AbstractDao {
    protected Connection createConnection() {
        return DatabaseManager.createConnection();
    }
}
