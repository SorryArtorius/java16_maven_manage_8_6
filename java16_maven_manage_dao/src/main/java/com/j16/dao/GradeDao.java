package com.j16.dao;

import com.j16.pojo.Grade;

import java.util.List;

public interface GradeDao {

    Grade getGrade(int gradeId);

    List<Grade> gradeList();


    int updateGrade(Grade grade);


    int addGrade(String gradeName);

    int deleteGrade(int gradeId);
}
