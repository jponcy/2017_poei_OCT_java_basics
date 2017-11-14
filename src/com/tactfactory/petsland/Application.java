package com.tactfactory.petsland;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * See package-info about instructions.
 */
public class Application {
    private static final List<Rabbit> fixturesData;
    private static final int FIXTURE_LIMIT = 50;

    static {
        fixturesData = new ArrayList<>();
        String[] colors = {"silver", "pink", "green", "cyan", "navy", "magenta"};
        LocalDate birthdate = LocalDate.now();

        for (int i = 1; i <= FIXTURE_LIMIT; ++ i) {
            String color = colors[(new Random()).nextInt(colors.length)];
            Rabbit rabbit = new Rabbit("Rabbit n°" + i, birthdate, color);

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
        RabbitDao dao = new RabbitDao();
        List<Rabbit> rabbits = dao.findAll();

        for (Rabbit rabbit : rabbits) {
            System.out.println(String.format(" - %s\n\tbirthdate: %s\n\tcolor: %s",
                    rabbit.getName(),
                    rabbit.getBirthdateAsString(),
                    rabbit.getColor()));
        }
    }

    /**
     * Creates the table.
     */
    private static void createDb() {
        RabbitDao rabbitDao = new RabbitDao();

        if ((new DatabaseManager()).rebuildDatabaseSchema()) {
            System.out.println("Database rebuild.");
            rabbitDao.insert(fixturesData);
        } else {
            System.err.println("Impossible to rebuild Database.");
            System.exit(42);
        }
    }
}
