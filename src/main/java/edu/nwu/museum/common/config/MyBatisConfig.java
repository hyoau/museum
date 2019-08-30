package edu.nwu.museum.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(value = {"edu.nwu.Museum.dao"})
public class MyBatisConfig {
}
