package com.example.android.upr9;

public class Course {

    private String name;
    private float score;
    private boolean passed;
    private String color;

    public Course(String name, float score, boolean passed, String color) {
        this.name = name;
        this.score = score;
        this.passed = passed;
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public float getScore() {
        return score;

    }
    public boolean isPassed() {
        return passed;
    }

    public String getColor() {
        return color;
    }

}
