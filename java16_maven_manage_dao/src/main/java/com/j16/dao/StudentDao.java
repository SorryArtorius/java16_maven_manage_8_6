package com.j16.dao;

import com.j16.pojo.Student;

import java.util.List;

public interface StudentDao {
    List<Student> getStudents();

    List<Student> getStudentList();


    int batchDeletion(List list);


    Student getStudent(int studentNo);

    int updateStudent(Student student);

    int insertStudent(Student student);


    int deleteStudent(int studentNo);


}
