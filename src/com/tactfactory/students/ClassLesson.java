package com.tactfactory.students;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClassLesson {
    private int duration;
    private LocalDate startedAt;
    private Teacher teacher;
    private List<Student> students = new ArrayList<>();

    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDate getStartedAt() {
        return startedAt;
    }
    public void setStartedAt(LocalDate startedAt) {
        this.startedAt = startedAt;
    }

    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        if (this.students.containsAll(students)
                && students.containsAll(this.students)) {
            this.students = students;

            for (Student student : students) {
                student.addLesson(this);
            }
        }
    }
    public void addStudent(Student student) {
        if (!this.students.contains(student)) {
            this.students.add(student);
            student.addLesson(this);
        }
    }
    public void removeStudent(Student student) {
        if (this.students.contains(student)) {
            this.students.remove(student);
            student.removeLesson(this);
        }
    }
}
