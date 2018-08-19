package com.peng.springBootUI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

//注意这里必须为Controller
@Controller
public class QiXiController {
    /**
     * http://localhost:8080/qixi/biaobai
     * @param map
     * @return
     */
    //返回的值页面
    //@RequestMapping("/biaobai")
    @GetMapping("/biaobai")
    public String helloHtml(HashMap<String, Object> map) {
        return "/biaobai";
    }
}
