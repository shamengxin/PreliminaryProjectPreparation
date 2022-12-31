package com.shamengxin.servlet;

import com.shamengxin.domain.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("进入到servlet04");

        Student s1=new Student("A0001","zs",20);
        Student s2=new Student("A0002","ls",23);

        //{"id":"?","name":"?","age":?}
        //{"s1":{"id":"?","name":"?","age":?},"s2":{"id":"?","name":"?","age":?}}
        String str="{\"s1\":{\"id\":\""+s1.getId()
                +"\",\"name\":\""+s1.getName()
                +"\",\"age\":"+s1.getAge()
                +"},\"s2\":{\"id\":\""+s2.getId()
                +"\",\"name\":\""+s2.getName()
                +"\",\"age\":"+s2.getAge()+"}}";

        PrintWriter out = response.getWriter();
        out.print(str);
        out.close();

    }
}
