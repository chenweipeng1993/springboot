package com.peng.springboot.springbootdemo.controller;

import com.peng.springboot.springbootdemo.domain.Girl;
import com.peng.springboot.springbootdemo.domain.Result;
import com.peng.springboot.springbootdemo.repository.GirlRepository;
import com.peng.springboot.springbootdemo.service.GirlService;
import com.peng.springboot.springbootdemo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class GirlController {
    private static final Logger logger = LoggerFactory.getLogger(GirlController.class);
    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;
    //查看
    @GetMapping(value = "/girls")
    public List<Girl> girlsList(){
        return girlRepository.findAll();
    }
    //新增
    @PostMapping(value = "/girls")
    public Girl girlAdd(@RequestParam("cupSize")String cupSize,@RequestParam("age")Integer age){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }
    //查看
    //localhost:8084/springbootdemo/girls/1?age=12&cupSize=C
    @GetMapping(value = "/girls/{id}")
    public Girl findGirlById(@PathVariable("id")Integer id,@PathParam("age") Integer age,@PathParam("cupSize")String cupSize){
        System.out.println("age:"+age);
        System.out.println("cupSize:"+cupSize);
        return girlRepository.findById(id).get();
    }
    //更新
    //body传入的头部需要换
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id")Integer id,
                           @RequestParam("age")Integer age,
                           @RequestParam("cupSize")String cupSize){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }
    //添加-校验
    //localhost:8084/springbootdemo/girls2/1
    /*@PostMapping(value = "/girls2")
    public Girl girlUpdate2(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            logger.info(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        return girlRepository.save(girl);
    }*/
    /*@PostMapping(value = "/girls2")
    public Result<Girl> girlUpdate2(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            Result result = new Result();
            result.setCode(1);
            result.setMsg(bindingResult.getFieldError().getDefaultMessage());
            result.setData(null);
            return result;
        }
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(girlRepository.save(girl));
        return result;
    }*/
    @PostMapping(value = "/girls2")
    public Result<Girl> girlUpdate2(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            //后置返回的增强中记录了返回的值，使用的是obj.toString()，如果返回空的话会报错的
            //return  null;
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(girlRepository.save(girl));
    }
    //删除
    //localhost:8084/springbootdemo/girls/1
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id")Integer id){
        girlRepository.deleteById(id);
    }
    //通过age来查询
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlsListByAge(@PathVariable("age")Integer age){
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void addTwo(){
        girlService.inserTwo();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void girlsGetAgeById(@PathVariable("id")Integer id) throws Exception {
        girlService.getAgeById(id);
    }
}
