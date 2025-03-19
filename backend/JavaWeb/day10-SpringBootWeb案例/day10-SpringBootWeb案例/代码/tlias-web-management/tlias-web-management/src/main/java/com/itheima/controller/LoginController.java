package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import com.itheima.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @wwj
 * @date
 */
@Slf4j
@RestController
public class LoginController {
    @Autowired
    private EmpService empService;
@PostMapping("/login")
    public Result login(@RequestBody Emp emp){

    log.info("员工登录:{}",emp);
    Emp e=empService.login(emp);

    //登陆成功则发令牌，
    if(e!=null){
        Map<String,Object> cliams=new HashMap<>();
        cliams.put("id",e.getId());
        cliams.put("name",e.getName());
        cliams.put("username",e.getUsername());
String jwt= JwtUtils.generateJwt(cliams);
log.info("生成的令牌为:{}",jwt);
return Result.success(jwt);

    }

    if(e==null){
        return Result.error("用户名或密码错误");
    }


    return e != null ? Result.success(e):Result.error("用户名或密码错误");
}













}
