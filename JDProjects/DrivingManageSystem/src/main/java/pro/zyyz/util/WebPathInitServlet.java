package pro.zyyz.util;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns = {},loadOnStartup = 2)
public class WebPathInitServlet extends HttpServlet {
    public static String ctx;

    public static String getCtx() {
        return ctx;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        //在整体应用上下文当中存储了一个ctx的值，用他来引用上下文路径
        config.getServletContext().setAttribute("ctx",config.getServletContext().getContextPath());
        ctx = config.getServletContext().getContextPath();
        super.init(config);
    }
}
