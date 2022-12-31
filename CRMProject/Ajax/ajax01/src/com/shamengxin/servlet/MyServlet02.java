package com.shamengxin.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("进入到servlet02");
        //{"str1":"aaa","str2":"bbb"}
        String str="{\"str1\":\"aaa\",\"str2\":\"bbb\"}";

        PrintWriter out = response.getWriter();
        out.print(str);
        out.close();

    }
}
