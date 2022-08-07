package com.j16.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.j16.pojo.Grade;
import com.j16.service.impl.GradeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/gradeServlet")
public class GradeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tag = "";
        if (req.getParameter("tag") != null) {
            tag = req.getParameter("tag");
        }

        if ("show".equals(tag)){
            resp.sendRedirect("grade.html");
        }else if ("showGrade".equals(tag)) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("grades",new GradeServiceImpl().gradeList());
            resp.getWriter().write(JSON.toJSONString(jsonObject));
        }else if ("add".equals(tag)) {
            resp.sendRedirect("gradeAdd.html");
        }else if ("del".equals(tag)) {
            int gradeId = Integer.parseInt(req.getParameter("gradeId"));
            new GradeServiceImpl().deleteGrade(gradeId);
            resp.sendRedirect("grade.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tag = "";
        if (req.getParameter("tag") != null) {
            tag = req.getParameter("tag");
        }

        if ("edit".equals(tag)) {
            Grade grade = new Grade();
            int gradeId = Integer.parseInt(req.getParameter("studentGrade"));
            String gradeName = req.getParameter("gradeName");
            grade.setGradeId(gradeId);
            grade.setGradeName(gradeName);
            new GradeServiceImpl().updateGrade(grade);
            resp.sendRedirect("grade.html");
        }else if ("add".equals(tag)) {
            new GradeServiceImpl().addGrade(req.getParameter("gradeName"));
            resp.sendRedirect("grade.html");
        }
    }
}
