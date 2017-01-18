package com.github.linpn.jsplite.mvc;

import com.github.linpn.jsplite.http.JspliteHttpRequest;
import com.github.linpn.jsplite.http.JspliteHttpResponse;


/**
 * MVC用来向jsp指定的控制类接口
 *
 * @author Linpn
 */
public interface Controller {

    /**
     * 接收客户端的请求
     *
     * @param request  扩展的request请求
     * @param response 扩展的response请求
     * @param model    传回jsp的数据
     */
    void execute(JspliteHttpRequest request, JspliteHttpResponse response, ModelView model);

}
