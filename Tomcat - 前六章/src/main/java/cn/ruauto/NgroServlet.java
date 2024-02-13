package cn.ruauto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zYu
 * @version 1.0
 * @create 2024-01-28 15:14
 */
@WebServlet( urlPatterns ={"/ngro"})
public class NgroServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        System.out.println(method);
        resp.getOutputStream().write("ok".getBytes());
    }
}
