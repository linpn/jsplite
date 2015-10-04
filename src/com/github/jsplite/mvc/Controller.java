package com.github.jsplite.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * MVC用来向jsp指定的控制类接口
 */
public interface Controller {

    /**
     * 接收客户端的请求
     */
    public void execute(HttpServletRequest request, HttpServletResponse response, ModelView model) throws Exception;

}
