package com.j16.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.j16.dao.StudentDao;
import com.j16.pojo.Student;
import com.j16.service.StudentService;
import com.j16.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    public PageInfo<Student> getStudents(int index,int page) {
        SqlSession session = MyBatisUtil.createSqlSession();
        try {
            StudentDao studentDao = session.getMapper(StudentDao.class);
            PageHelper.startPage(index,page);
            List<Student> students = studentDao.getStudents();
            return new PageInfo<Student>(students);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    public List<Student> getStudentList() {
        SqlSession session = MyBatisUtil.createSqlSession();
        try {
            StudentDao studentDao = session.getMapper(StudentDao.class);
            return studentDao.getStudentList();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }


    public int batchDeletion(List list) {
        SqlSession session = MyBatisUtil.createSqlSession();
        try {
            StudentDao studentDao = session.getMapper(StudentDao.class);
            return studentDao.batchDeletion(list);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return 0;
    }


    public Student getStudent(int studentNo) {
        SqlSession session = MyBatisUtil.createSqlSession();
        try {
            StudentDao studentDao = session.getMapper(StudentDao.class);
            return studentDao.getStudent(studentNo);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }


    public int updateStudent(Student student) {
        SqlSession session = MyBatisUtil.createSqlSession();
        try {
            StudentDao studentDao = session.getMapper(StudentDao.class);
            return studentDao.updateStudent(student);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return 0;
    }


    public int insertStudent(Student student) {
        SqlSession session = MyBatisUtil.createSqlSession();
        try {
            StudentDao studentDao = session.getMapper(StudentDao.class);
            return studentDao.insertStudent(student);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return 0;
    }

    public int deleteStudent(int studentNo) {
        SqlSession session = MyBatisUtil.createSqlSession();
        try {
            StudentDao studentDao = session.getMapper(StudentDao.class);
            return studentDao.deleteStudent(studentNo);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return 0;
    }
}
