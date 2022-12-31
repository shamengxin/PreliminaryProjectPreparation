package com.shamengxin.servlet;

import com.shamengxin.domain.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("进入到servlet03");

        Student s=new Student("A0001","zs",20);

        //{"id":"?","name":"?","age":?}
        String str="{\"id\":\""+s.getId()+"\",\"name\":\""+s.getName()+"\",\"age\":"+s.getAge()+"}";

        PrintWriter out = response.getWriter();
        out.print(str);
        out.close();

    }
}
