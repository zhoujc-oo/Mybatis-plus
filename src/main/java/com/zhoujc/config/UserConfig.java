package com.zhoujc.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zhoujc
 * @Date 2022/2/26
 */
@Configuration
@MapperScan("cnm.zhoujc.dao.UserMapper")
public class UserConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        //定义mapper拦截器
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //添加具体拦截器
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }

}
