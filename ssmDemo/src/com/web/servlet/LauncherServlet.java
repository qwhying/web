/**
 * @author qiaoger 2015-12-04
 * @author qiaoger@126.com
 */
package com.web.servlet;

import com.web.exception.WebException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author qiaoger@126.com  网站配置工具类 负责 初始化配置 网站关闭处理
 *  需要导入 javax.servlet.jar
 */

public class LauncherServlet extends HttpServlet {
    public void init() throws ServletException {
        super.init();
        InputStream is = null;
        try {
            System.err.println("开始启动 测试网站......");
            // 这里可以进行一些初始化的操作
            System.err.println("进行初始化操作:");
            System.err.println("读取配置文件示例：");
            // *******************以下进行简单的读取配置文件示例操作********************************
            try {
                String path = this.getServletContext().getRealPath(
                        "WEB-INF/web.properties");
                is = new FileInputStream(path);
                if (is == null)
                    throw new WebException("不能打开web.properties");
                Properties p = new Properties();
                p.load(is);
                String web_name = p.getProperty("web_name");
                String author = p.getProperty("author");
                String date = p.getProperty("date");
                System.err.println("-----以下是配置文件web.properties信息:-----");
                System.err.println("WEB应用名称：" + web_name);
                System.err.println("作者：" + author);
                System.err.println("日期：" + date);
                System.err.println("-----------------------------------------");
            } catch (Exception e) {
                e.printStackTrace();

                throw new ServletException(e);
            } finally {
                if (is != null)
                    try {
                        is.close();
                    } catch (Exception e) {
                    }
            }
            // *******************************************************************
            System.err.println("这个位置进行初始化工作....");
            System.err.println("初始化工作完毕，OK !");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Launch system error: " + e, e);
        }
    }

    public void destroy() {
        System.out.println("准备关闭ssm_demo ...");
        System.out.println("进行关闭前的清理操作（模拟）......");
        super.destroy();
        System.out.println("关闭成功  OK !");
    }
}
