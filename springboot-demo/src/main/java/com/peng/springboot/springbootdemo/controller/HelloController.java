package com.peng.springboot.springbootdemo.controller;

import com.peng.springboot.springbootdemo.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

//这个方法相当于@Controller和@ResponseBody 返回json
@RestController
public class HelloController {
    @Value("${cupSize}")
    private String cupSize;
    @Value("${age}")
    private Integer age;
    @Value("${content}")
    private String content;
    @Autowired
    private GirlProperties girlProperties;
    @RequestMapping(value = {"/hello","hi"},method = RequestMethod.GET)
    //@GetMapping(value = "/hello") 简写
    public String sayHello(){
        return "Hello World SpringBoot!";
    }
    @RequestMapping(value = "/value")
    public String value(){
        return "age:"+age+",cupSize:"+cupSize;
    }
    @RequestMapping(value = "/value2",method = RequestMethod.GET)
    public String value2(){
        return "content:"+content;
    }
    @RequestMapping(value = "/value3",method = RequestMethod.GET)
    public String value3(){
        return "girlProperties:"+girlProperties.getCupSize()+girlProperties.getAge();
    }

    //http://localhost:8084/springbootdemo/restHello/12?name=haha
    @GetMapping(value = "/restHello/{id}")
    public String restHello(@PathVariable(value = "id") Integer id, @PathParam("name") String name){
        return "id:"+id+",name:"+name;
    }
}
