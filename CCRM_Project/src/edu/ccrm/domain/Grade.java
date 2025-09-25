package edu.ccrm.domain;

/**
 * Enum representing letter grades and their corresponding grade points.
 * Demonstrates an enum with a constructor and fields.
 */
public enum Grade {
    S(10.0), A(9.0), B(8.0), C(7.0), D(6.0), E(5.0), F(0.0);

    private final double gradePoints;

    /**
     * Constructor for the enum.
     * @param gradePoints The numerical point value for the grade.
     */
    Grade(double gradePoints) {
        this.gradePoints = gradePoints;
    }

    public double getGradePoints() {
        return gradePoints;
    }
}
