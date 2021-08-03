package com.hp.service;

import com.alibaba.fastjson.JSON;
import com.hp.bean.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "GetServlet",urlPatterns = "/GetServlet")
public class GetServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.service(req, resp);
    //service 可以接受get请求，也可以接受post请求
        //web,controller是提供json数据的，那么我们需要一个处理json的lib包
        //这个lib包叫做fastjson,阿里巴巴出品，很厉害的
        //学习json和fastjson
        //使用fastjson把对象转换成json数据
        ArrayList<Student> students = new ArrayList<>();
        Student s1 = new Student();
        s1.setId(001);
        s1.setAge(21);
        s1.setName("小乔");
        students.add(s1);

        Student s2 = new Student();
        s2.setId(004);
        s2.setAge(22);
        s2.setName("大乔");
        students.add(s2);

        Student s3 = new Student();
        s3.setId(003);
        s3.setAge(23);
        s3.setName("貂蝉");
        students.add(s3);

        String s = JSON.toJSONString(students);
        System.out.println(s);  //把对象转换成了json格式的字符串

        //输出到前端
        //1.解决乱码问题
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        //开始输出
        PrintWriter writer = resp.getWriter();
        writer.println(s);
        writer.close();
    }
}
