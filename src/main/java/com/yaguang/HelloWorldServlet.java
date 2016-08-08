/**
 * Created by I076057 on 8/3/2016.
 */

package com.yaguang;


import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloWorldServlet extends HttpServlet {


    @Override
    protected  void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

        doPost(req, resp);

    }


    @Override
    protected  void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

            req.setCharacterEncoding( "UTF-8");
            String name =  req.getParameter("Name");

            resp.setHeader("Content-type","application/json");

            ServletOutputStream stream = resp.getOutputStream();

            String json = "{ \"name\":" + name + "}";

            byte[] bytes = json.toLowerCase().getBytes("UTF-8");

            stream.write(bytes, 0, bytes.length);

            stream.flush();

            return ;
    }



}
