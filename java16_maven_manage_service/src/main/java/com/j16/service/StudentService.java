package com.j16.service;

import com.github.pagehelper.PageInfo;
import com.j16.pojo.Student;

import java.util.List;

public interface StudentService {

    PageInfo<Student> getStudents(int index,int page);

    List<Student> getStudentList();


    int batchDeletion(List list);

    Student getStudent(int studentNo);

    int updateStudent(Student student);


    int insertStudent(Student student);


    int deleteStudent(int studentNo);
}
