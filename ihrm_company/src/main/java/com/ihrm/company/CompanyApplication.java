package com.ihrm.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import com.ihrm.common.utils.IdWorker;

//配置springboot扫描包
@SpringBootApplication(scanBasePackages = "com.ihrm.company")
//配置jpa注解扫描
@EntityScan(value = "com.ihrm   ")
public class CompanyApplication {
    public static void main(String[] args) {
        SpringApplication.run(CompanyApplication.class,args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }
}
