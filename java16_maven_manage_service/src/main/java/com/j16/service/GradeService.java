package com.j16.service;

import com.j16.pojo.Grade;

import java.util.List;

public interface GradeService {

    List<Grade> gradeList();


    Grade getGrade(int gradeId);


    int updateGrade(Grade grade);


    int addGrade(String gradeName);

    int deleteGrade(int gradeId);
}
