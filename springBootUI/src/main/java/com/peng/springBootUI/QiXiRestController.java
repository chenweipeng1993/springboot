package com.peng.springBootUI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qixi")
public class QiXiRestController {
    //http://localhost:8080/qixi/qixi/biaobai
    @GetMapping(path = "/biaobai")
    public String biaobai(){
        return "表白";
    }
}
