package com.j16.servlet;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.j16.pojo.Grade;
import com.j16.pojo.Student;
import com.j16.service.impl.GradeServiceImpl;
import com.j16.service.impl.StudentServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        Student student = new StudentServiceImpl().getStudent(10000);
//        System.out.println(student);
//
        List<Grade> grade = new GradeServiceImpl().gradeList();
        System.out.println(grade);
    }
}
