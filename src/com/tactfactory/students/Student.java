package com.tactfactory.students;

import java.util.ArrayList;
import java.util.List;

public class Student extends Human {
    private int comeYear;
    private String gradient;
    private School school;
    private List<ClassLesson> lessons = new ArrayList<>();

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

    public List<ClassLesson> getLessons()
    { return lessons; }
    public void setLessons(List<ClassLesson> lessons)
    {
        this.lessons.clear();

        for (ClassLesson classLesson : lessons) {
            classLesson.addStudent(this);
        }
    }
    public void addLesson(ClassLesson lesson)
    {
        if (!this.lessons.contains(lesson)) {
            this.lessons.add(lesson);
            lesson.addStudent(this);
        }
    }
    public void removeLesson(ClassLesson lesson)
    {
        if (this.lessons.contains(lesson)) {
            this.lessons.remove(lesson);
            lesson.removeStudent(this);
        }
    }
}
