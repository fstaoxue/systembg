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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.taoge.zxstbg.database.webtls.dao", sqlSessionFactoryRef = "webtlsSqlSessionFactory")
public class WebtlsDataSourceConfig {
    // 将这个对象放入Spring容器中
    @Bean(name = "webtlsDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.webtls")
    public DataSource getDateSource1() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "webtlsSqlSessionFactory")
    @Primary
    public SqlSessionFactory webtlsSqlSessionFactory(@Qualifier("webtlsDataSource") DataSource datasource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setMapperLocations(
                // 设置mybatis的xml所在位置
                new PathMatchingResourcePatternResolver().getResources("classpath:mapper/webtls/*.xml"));
        return bean.getObject();
    }
    @Bean("webtlsSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate webtlssqlsessiontemplate(
            @Qualifier("webtlsSqlSessionFactory") SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }
}
