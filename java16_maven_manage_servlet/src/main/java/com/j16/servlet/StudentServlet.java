package com.j16.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.j16.pojo.Student;
import com.j16.service.impl.GradeServiceImpl;
import com.j16.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


@WebServlet("/studentServlet")
public class StudentServlet extends HttpServlet {
    private void showInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        int index = 1;
        if (req.getParameter("pageIndex") != null) {
            index = Integer.parseInt(req.getParameter("pageIndex"));
        }
        PageInfo<Student> students = new StudentServiceImpl().getStudents(index, 5);
        String json = JSON.toJSONString(students);
        resp.getWriter().write(json);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tag = "";
        if (req.getParameter("tag") != null) {
            tag = req.getParameter("tag");
        }

        if ("show".equals(tag)) {
            showInfo(req, resp);
        } else if ("del".equals(tag)) {
            String studentNo = req.getParameter("studentNoList");
            List list = Arrays.asList(studentNo.split(","));
            if (new StudentServiceImpl().batchDeletion(list) > 0) {
                resp.sendRedirect("index.html");
            }

        } else if ("edit".equals(tag)) {
            req.getSession().setAttribute("studentNo", req.getParameter("studentNo"));
            resp.sendRedirect("studentEdit.html");
        } else if ("editShow".equals(tag)) {
            int studentNo = Integer.parseInt((String) req.getSession().getAttribute("studentNo"));
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("student", new StudentServiceImpl().getStudent(studentNo));
            jsonObject.put("grades", new GradeServiceImpl().gradeList());
            resp.getWriter().write(JSON.toJSONString(jsonObject));
        } else if ("add".equals(tag)) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("grades", new GradeServiceImpl().gradeList());
            resp.getWriter().write(JSON.toJSONString(jsonObject));
        } else if ("addJump".equals(tag)) {
            resp.sendRedirect("studentAdd.html");
        } else if ("dell".equals(tag)) {
            int studentNo = Integer.parseInt(req.getParameter("studentNo"));
            new StudentServiceImpl().deleteStudent(studentNo);
            resp.sendRedirect("index.html");
        }else if ("index".equals(tag)) {
            resp.sendRedirect("index.html");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tag = "";
        if (req.getParameter("tag") != null) {
            tag = req.getParameter("tag");
        }

        if ("edit".equals(tag)) {
            Student student = new Student();
            int studentNo = Integer.parseInt(req.getParameter("studentNo"));
            String studentName = req.getParameter("studentName");
            String studentPwd = req.getParameter("studentPwd");
            String studentSex = req.getParameter("studentSex");
            int studentGradeId = Integer.parseInt(req.getParameter("studentGrade"));
            String studentPhone = req.getParameter("studentPhone");
            String studentAddress = req.getParameter("studentAddress");
            String studentBornDate = req.getParameter("studentBornDate");
            String studentEmail = req.getParameter("studentEmail");
            String studentIdentityCard = req.getParameter("studentIdentityCard");
            student.setStudentNo(studentNo);
            student.setStudentName(studentName);
            student.setLoginPwd(studentPwd);
            student.setSex(studentSex);
            student.setGrade(new GradeServiceImpl().getGrade(studentGradeId));
            student.setPhone(studentPhone);
            student.setAddress(studentAddress);
            student.setBornDate(studentBornDate);
            student.setIdentityCard(studentIdentityCard);
            student.setEmail(studentEmail);
            if (new StudentServiceImpl().updateStudent(student) > 0) {
                System.out.println("成功");
                resp.sendRedirect("index.html");
            }
        } else if ("add".equals(tag)) {
            Student student = new Student();
            String studentName = req.getParameter("studentName");
            String studentPwd = req.getParameter("studentPwd");
            String studentSex = req.getParameter("studentSex");
            int studentGradeId = Integer.parseInt(req.getParameter("studentGrade"));
            String studentPhone = req.getParameter("studentPhone");
            String studentAddress = req.getParameter("studentAddress");
            String studentBornDate = req.getParameter("studentBornDate");
            String studentEmail = req.getParameter("studentEmail");
            String studentIdentityCard = req.getParameter("studentIdentityCard");
            student.setStudentName(studentName);
            student.setLoginPwd(studentPwd);
            student.setSex(studentSex);
            student.setGrade(new GradeServiceImpl().getGrade(studentGradeId));
            student.setPhone(studentPhone);
            student.setAddress(studentAddress);
            student.setBornDate(studentBornDate);
            student.setIdentityCard(studentIdentityCard);
            student.setEmail(studentEmail);
            new StudentServiceImpl().insertStudent(student);
            resp.sendRedirect("index.html");

        }
    }
}
