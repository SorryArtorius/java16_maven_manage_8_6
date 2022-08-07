package com.j16.service.impl;

import com.j16.dao.GradeDao;
import com.j16.dao.StudentDao;
import com.j16.pojo.Grade;
import com.j16.service.GradeService;
import com.j16.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GradeServiceImpl implements GradeService {

    public List<Grade> gradeList() {
        SqlSession session = MyBatisUtil.createSqlSession();
        try {
            GradeDao gradeDao = session.getMapper(GradeDao.class);
            return gradeDao.gradeList();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    public Grade getGrade(int gradeId) {
        SqlSession session = MyBatisUtil.createSqlSession();
        try {
            GradeDao gradeDao = session.getMapper(GradeDao.class);
            return gradeDao.getGrade(gradeId);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    public int updateGrade(Grade grade) {
        SqlSession session = MyBatisUtil.createSqlSession();
        try {
            GradeDao gradeDao = session.getMapper(GradeDao.class);
            return gradeDao.updateGrade(grade);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return 0;
    }

    public int addGrade(String gradeName) {
        SqlSession session = MyBatisUtil.createSqlSession();
        try {
            GradeDao gradeDao = session.getMapper(GradeDao.class);
            return gradeDao.addGrade(gradeName);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return 0;
    }

    public int deleteGrade(int gradeId) {
        SqlSession session = MyBatisUtil.createSqlSession();
        try {
            GradeDao gradeDao = session.getMapper(GradeDao.class);
            return gradeDao.deleteGrade(gradeId);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return 0;
    }
}
