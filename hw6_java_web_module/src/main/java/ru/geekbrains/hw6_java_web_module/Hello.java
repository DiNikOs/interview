/**
 * @author Ostrovskiy Dmitriy
 * @created 10.05.2020
 * hello
 * @version v1.0
 */
package ru.geekbrains.hw6_java_web_module;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/hello") // example №3 without web.xml
public class Hello extends HttpServlet {

    private ServletConfig config;
    @Override
    public void init (ServletConfig config) throws ServletException
    {
        this.config = config;
    }
    @Override
    public void destroy() {

    }
    @Override
    public ServletConfig getServletConfig()
    {
        return config;
    }
    @Override
    public String getServletInfo()
    {
        return "Hello Servlet";
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
//        example №1
//        PrintWriter pw = resp.getWriter();
//        pw.println("<H1>Hello World example 1!!!</H1>");

//        example №2
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
