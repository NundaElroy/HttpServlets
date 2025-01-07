package org.example;

import jakarta.servlet.Servlet;
import org.apache.catalina.Context;

import org.apache.catalina.startup.Tomcat;


/*
 * Context represents the  web app that's running on the server
 * contextPath is the path that the app is available at
 * doc base is the location of the web apps static files
 * */

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);


        Context ctx = tomcat.addContext("", null);



        // This is where we register your StudentServlet
        // It's like @Controller in Spring, but manual


         Tomcat.addServlet(ctx,"studentServlet", new StudentServlet());




        // This maps URLs that start with /students/ to your servlet
        // It's like @RequestMapping in Spring

        ctx.addServletMappingDecoded("/students/*", "studentServlet");

        // Start the server
        tomcat.start();
       // Keep it running (like how Spring Boot app stays running)
        tomcat.getServer().await();


    }
}