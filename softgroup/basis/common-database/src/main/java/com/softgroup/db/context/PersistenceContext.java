package com.softgroup.db.context;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;
/**
 * Author: vadym
 * Date: 01.03.17
 * Time: 12:24
 */
@Configuration
@EnableJpaRepositories(basePackages = {
        "com.softgroup.db.repository"
})
@EnableTransactionManagement
@PropertySource(value={"classpath:application.properties"})
public class PersistenceContext {
    @Value("${db.driver}")
    String driver;

    @Value("${db.url}")
    String url;

    @Value("${db.username}")
    String username;

    @Value("${db.password}")
    String password;

    @Value("${hibernate.dialect}")
    String hibernateDialect;

    @Value("${hibernate.hbm2ddl.auto}")
    String hbm2ddlAuto;

    @Value("${hibernate.ejb.naming_strategy}")
    String ejbNamingStrategy;

    @Value("${hibernate.show_sql}")
    String hibernateShowSql;

    @Value("${hibernate.format_sql}")
    String hibernateFormatSql;

    @Value("${hibernate.package_to_scan}")
    String hibernatePackageToScan;


    @Bean(destroyMethod = "close")
    DataSource dataSource() {
        HikariConfig dataSourceConfig = new HikariConfig();
        dataSourceConfig.setDriverClassName(driver);
        dataSourceConfig.setJdbcUrl(url);
        dataSourceConfig.setUsername(username);
        dataSourceConfig.setPassword(password);
        return new HikariDataSource(dataSourceConfig);
    }

    @Bean
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan(hibernatePackageToScan);

        Properties jpaProperties = new Properties();

        jpaProperties.put("hibernate.dialect", hibernateDialect);

        jpaProperties.put("hibernate.hbm2ddl.auto", hbm2ddlAuto);

        jpaProperties.put("hibernate.ejb.naming_strategy", ejbNamingStrategy);

        jpaProperties.put("hibernate.show_sql", hibernateShowSql);

        jpaProperties.put("hibernate.format_sql", hibernateFormatSql);

        entityManagerFactoryBean.setJpaProperties(jpaProperties);

        return entityManagerFactoryBean;
    }
}