package com.github.jsplite;

import com.github.jsplite.mvc.Controller;
import com.github.jsplite.mvc.ModelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


/**
 * MVC用来向jsp指定哪个控制(controller)类
 *
 * @author lpn
 */
public final class Jsplite {

    /**
     * controller缓存池
     */
    private static Map<String, Controller> pool = new HashMap<String, Controller>();

    /**
     * 为JSP指定哪个controller类
     *
     * @param request
     * @param response
     * @param bean
     */
    public static void inherits(String bean,
                                HttpServletRequest request, HttpServletResponse response) throws Exception {
        //设置HTML头信息
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);

        //获取controller
        Controller controller = pool.get(bean);
        if (controller == null) {
            controller = (Controller) Class.forName(bean).getConstructor().newInstance();
            pool.put(bean, controller);
        }

        //执行方法
        String func = request.getParameter("func");
        ModelView model = new ModelView();
        if (func == null || func.trim().equals("")) {
            //页面请求
            controller.execute(request, response, model);
            for (Map.Entry<String, Object> value : model) {
                request.setAttribute(value.getKey(), value.getValue());
            }
        } else {
            //Ajax请求
            Method method = controller.getClass().getMethod(func, HttpServletRequest.class, HttpServletResponse.class, ModelView.class);
            method.invoke(controller, request, response, model);
            response.getWriter().println(model);
        }
    }

}
