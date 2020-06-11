package com.test.RedisDemo.redis.ascept;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * Created by eaninfj on 2020/6/9.
 */
@Component
@Aspect
@EnableAspectJAutoProxy
public class UserAspect {


    @Around(value = "execution(* com.test.RedisDemo.service.UserServiceImpl.save(..))")
    public Object saveUser(ProceedingJoinPoint joinPoint){

        return null;
    }

}
