package org.withclass.entities;

public class Student {
    public String name;
    public double grade1;
    public double grade2;
    public double grade3;

    public String toString() {
        return "Final Grade: " + this.finalGrade();
    }

    public double finalGrade() {
        return (this.grade1 + this.grade2 + this.grade3);
    }

    public boolean StudentIsApproved() {
        if (this.finalGrade() >= 60) {
            return true;
        } else {
            return false;
        }
    }

    public double missingPoints() {
        return 60 - this.finalGrade();
    }
}
