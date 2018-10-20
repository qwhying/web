package servlet;

// 导入必需的 java 库

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet 学习示例
 * <p>
 * Servlet 生命周期可被定义为从创建直到毁灭的整个过程。以下是 Servlet 遵循的过程：
 * Servlet 通过调用 init () 方法进行初始化。
 * Servlet 调用 service() 方法来处理客户端的请求。
 * Servlet 通过调用 destroy() 方法终止（结束）。
 * 最后，Servlet 是由 JVM 的垃圾回收器进行垃圾回收的。
 *
 * @author qiaoger@126.com
 */

// 扩展 HttpServlet 类  用注解的方式确定访问路径，不用在web.xml中配置
@WebServlet("/hello2")
public class HelloServlet2 extends HttpServlet {

    private String message;
   //初始化
    public void init() throws ServletException {
        // 执行必需的初始化
        super.init();
        System.out.println("HelloServlet2 初始化");
        message = "Hello, I am a pure Servlet 2 !";
    }

    /**
     *
     * service() 方法是执行实际任务的主要方法。
     * Servlet 容器（即 Web 服务器）调用 service() 方法来处理来自客户端（浏览器）的请求，
     * 并把格式化的响应写回给客户端。
     *
     * service() 方法由容器调用，service 方法在适当的时候调用
     * doGet、doPost、doPut、doDelete 等方法。所以，您不用对 service() 方法做任何动作，
     * 您只需要根据来自客户端的请求类型来重写 doGet() 或 doPost() 即可。
     * doGet() 和 doPost() 方法是每次服务请求中最常用的方法。
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        // 设置响应内容类型
        String name = request.getParameter("name");
        System.out.println(request.getParameter("name"));
        response.setContentType("text/html");
        // 业务处理
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + " " + name + "</h1>");
    }

    //销毁的时候执行
    public void destroy() {
        super.destroy();
        System.out.println("HelloServlet2 销毁啦");
    }
}