package com.taoge.zxstbg.database.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.taoge.zxstbg.database.zxstbg.dao", sqlSessionFactoryRef = "zxstbgSqlSessionFactory")
public class ZxstbgDataSourceConfig {
    @Bean(name = "zxstbgDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.zxstbg")
    public DataSource getDateSource2() {
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "zxstbgSqlSessionFactory")
    public SqlSessionFactory zxstbgSqlSessionFactory(@Qualifier("zxstbgDataSource") DataSource datasource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath:mapper/zxstbg/*.xml"));
        return bean.getObject();
    }
    @Bean("zxstbgSqlSessionTemplate")
    public SqlSessionTemplate zxstbgsqlsessiontemplate(
            @Qualifier("zxstbgSqlSessionFactory") SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }
}
