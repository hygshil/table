package com.hp.service;

import com.hp.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "TableServlet",urlPatterns = "/TableServlet")
public class TableServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.service(req, resp);
        //输出到前端
        //1.解决乱码问题
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        ArrayList<Student> students = new ArrayList<>();
        Student s1 = new Student();
        s1.setName("张三");
        s1.setAge(15);
        s1.setClass1("15网络");
        Student s2 = new Student();
        s2.setName("李四");
        s2.setAge(22);
        s2.setClass1("17软件");
        Student s3 = new Student();
        s3.setName("王五");
        s3.setAge(33);
        s3.setClass1("16信息");
        Student s4 = new Student();
        s4.setName("叫兽");
        s4.setAge(21);
        s4.setClass1("15网络");
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);


        //开始输出
        PrintWriter writer = resp.getWriter();
        writer.println(students);
        writer.close();
    }
}
