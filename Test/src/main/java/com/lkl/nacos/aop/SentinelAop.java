package com.lkl.nacos.aop;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lkl.nacos.annotation.SentinelAnnotation;
import com.lkl.nacos.util.Constant;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SentinelAop {
    @Pointcut("@annotation(com.lkl.nacos.annotation.SentinelAnnotation)")
    public void sentinelPointCut(){

    }

    @Around("sentinelPointCut() && @annotation(sentinelAnnotation)")
    public Object around(ProceedingJoinPoint joinPoint, SentinelAnnotation sentinelAnnotation) throws Throwable{
        try(Entry entry = SphU.entry(Constant.SENTINEL_SOURCE_NAME_HELLO_WORLD)) {
            System.out.println("==========成功通过哨兵=========");
            Object[] args = joinPoint.getArgs();
            return joinPoint.proceed(args);
        }catch (BlockException e){
            System.out.println("===========被哨兵拦截======");
            e.printStackTrace();
            return sentinelAnnotation.failedVal();
        }
    }
}
