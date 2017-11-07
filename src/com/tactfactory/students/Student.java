package com.tactfactory.students;

public class Student extends Human {
    private int comeYear;
    private String gradient;
    private School school;

    public int getComeYear()
    { return this.comeYear; }
    public void setComeYear(int year)
    { this.comeYear = year; }

    public String getGradient()
    { return this.gradient; }
    public void setGradient(String gradient)
    { this.gradient = gradient; }

    public School getSchool()
    { return this.school; }
    public void setSchool(School school) {
        this.school = school;
    }
}
