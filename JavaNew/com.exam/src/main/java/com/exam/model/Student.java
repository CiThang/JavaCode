package com.exam.model;

public class Student {
    private int id;
    private String fullName;
    private int birthYear;
    private double gpa;

    public Student() {
    }

    public Student(int id, String fullName, int birthYear, double gpa) {
        this.id = id;
        this.fullName = fullName;
        this.birthYear = birthYear;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", fullName=" + fullName + ", birthYear=" + birthYear + ", gpa=" + gpa + "]";
    }
}
