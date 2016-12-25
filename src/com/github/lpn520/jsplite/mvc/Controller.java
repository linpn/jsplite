package com.github.lpn520.jsplite.mvc;

import com.github.lpn520.jsplite.http.JspliteHttpRequest;
import com.github.lpn520.jsplite.http.JspliteHttpResponse;


/**
 * MVC用来向jsp指定的控制类接口
 *
 * @author Linpn
 */
public interface Controller {

    /**
     * 接收客户端的请求
     */
    void execute(JspliteHttpRequest request, JspliteHttpResponse response, ModelView model) throws Exception;

}
