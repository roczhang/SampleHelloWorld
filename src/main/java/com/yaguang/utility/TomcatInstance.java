package com.yaguang.utility;


import org.apache.catalina.Context;
import org.apache.catalina.loader.WebappLoader;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import java.io.File;
import java.net.MalformedURLException;

/**
 * Created by I076057 on 8/3/2016.
 */

public class TomcatInstance {


    private static final  String  CataLinaHome = "F:\\bin\\apache-tomcat-7.0.59";




    public static void main(String[] args)
     {

          System.out.println("catalina " + CataLinaHome);
          System.out.println("ClassPath" + System.getenv("ClassPATH"));
          String key= "java.class.path";
          System.out.println("java.classpath" +   System.getProperty(key));



         try
         {
             Tomcat instance =  getTomcatInstance();

             instance.start();

             instance.getServer().await();

             instance.stop();


         }
         catch ( Exception e)
         {
             System.out.println( e.getStackTrace());
         }

     }


     private static Tomcat getTomcatInstance() throws ServletException {
         Tomcat instance = new Tomcat();

         //set catalina home
         //System.setProperty("catalina.home", CataLinaHome );
         instance.setBaseDir(CataLinaHome);
         instance.setPort(8092);


         // url and basedir
         String appBase = System.getProperty("user.dir") + "\\build\\libs\\SampleHelloWorld";
         Context context = instance.addWebapp("hello", appBase);


         WebappLoader loader = new WebappLoader( context.getClass().getClassLoader());
         String webClassPath = System.getProperty("user.dir") + "\\build\\classes\\main";
         try {
             loader.addRepository(new File( webClassPath ).toURI().toURL().toString());
         } catch (MalformedURLException e) {
             e.printStackTrace();
         }
         context.setLoader(loader);




         context.setLoader(loader);


         return instance;
    }

}
