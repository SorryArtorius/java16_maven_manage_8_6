package com.j16.pojo;

public class Grade {
    private int gradeId;

    private String gradeName;

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }


    @Override
    public String toString() {
        return "Grade{" +
                "gradId=" + gradeId +
                ", gradName='" + gradeName + '\'' +
                '}';
    }
}
