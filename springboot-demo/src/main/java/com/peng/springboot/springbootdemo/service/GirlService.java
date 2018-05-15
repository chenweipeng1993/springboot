package com.peng.springboot.springbootdemo.service;

import com.peng.springboot.springbootdemo.domain.Girl;
import com.peng.springboot.springbootdemo.enums.ResultEnum;
import com.peng.springboot.springbootdemo.exception.GirlException;
import com.peng.springboot.springbootdemo.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;
    //事务的注解-和数据库的引擎有关
    @Transactional
    public void inserTwo(){
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("BBBB");
        girlB.setAge(19);
        girlRepository.save(girlB);

    }

    public Integer getAgeById(Integer id) throws Exception {
        Girl girl = girlRepository.findById(id).get();
        Integer age = girl.getAge();
        if(age<10){
            /*throw new GirlException(100,"你还在上小学吧");*/
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age>=10 && age<=16){
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
        return age;
    }

}
