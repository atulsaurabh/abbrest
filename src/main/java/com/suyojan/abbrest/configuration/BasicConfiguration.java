package com.suyojan.abbrest.configuration;


import com.suyojan.abbrest.service.FileReadWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.FileReader;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactory",
        transactionManagerRef =  "transactionManager",
        basePackages = "com.suyojan.abbrest.repository"
)
public class BasicConfiguration
{

    @Autowired
    private FileReadWriteService fileReadWriteService;
    @Value("${insdir}")
    private String insdir;
    @Bean
    @Primary
    public DataSource dataSource()
    {
        Logger.getGlobal().log(Level.INFO,"HOME="+insdir);
        DbParam configuration=fileReadWriteService.getDatabaseParam(insdir);
        System.out.println(configuration.getDbName());
        DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://"+configuration.getDbIp()+
                ":"+configuration.getDbPort()+
                "/"+configuration.getDbName();
        driverManagerDataSource.setUrl(url);
        driverManagerDataSource.setUsername(configuration.getDbUser());
        driverManagerDataSource.setPassword(configuration.getDbPassword());
        return driverManagerDataSource;
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory()
    {
        LocalContainerEntityManagerFactoryBean entityManagerFactory =
                new LocalContainerEntityManagerFactoryBean();

        entityManagerFactory.setDataSource(dataSource());
        HibernateJpaVendorAdapter vendorAdapter=new HibernateJpaVendorAdapter();
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);

        Properties properties = new Properties();
        properties.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
        // properties.put("hibernate.show_sql","true");
        //properties.put("hibernate.format_sql","true");
        properties.put("hibernate.hbm2ddl.auto","update");
        entityManagerFactory.setJpaProperties(properties);

        return entityManagerFactory;
    }

    @Bean
    @Primary
    public JpaTransactionManager transactionManager()
    {
        JpaTransactionManager transactionManager=new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    @Bean
    @Primary
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation()
    {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
