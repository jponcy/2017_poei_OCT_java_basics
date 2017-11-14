package com.tactfactory.petsland;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Rabbits are clients into our system.
 *
 * See docs/petsland_mcd
 */
public class Rabbit {
    private static final DateTimeFormatter dateFormatter
            = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private Integer id;
    private String name;
    private LocalDate birthdate;
    private String color;

    /**
     * The class constructor.
     *
     * @param name
     * @param birthdate
     * @param color
     */
    public Rabbit(String name, LocalDate birthdate, String color) {
        this.setName(name);
        this.setBirthdate(birthdate);
        this.setColor(color);
    }

    /**
     * The second class constructor.
     *
     * @param name
     * @param birthdate
     * @param color
     */
    public Rabbit(String name, String birthdate, String color) {
        this(name, LocalDate.parse(birthdate, dateFormatter), color);
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    private void setName(String name) {
        this.name = name;
    }

    /**
     * @return the birthdate
     */
    public LocalDate getBirthdate() {
        return birthdate;
    }

    /**
     * @return the birthdate
     */
    public String getBirthdateAsString() {
        return this.birthdate.format(Rabbit.dateFormatter);
    }

    /**
     * @param birthdate
     *            the birthdate to set
     */
    private void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color
     *            the color to set
     */
    private void setColor(String color) {
        this.color = color;
    }
}
