package ru.config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
public class HibernateConfig {

    private Environment environment;

    public HibernateConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public DataSource getDataSource() {

        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        try {
            dataSource.setDriverClass(environment.getProperty("postgresql.driver"));
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

        dataSource.setJdbcUrl(environment.getProperty("postgresql.url"));
        dataSource.setUser(environment.getProperty("postgresql.user"));
        dataSource.setPassword(environment.getProperty("postgresql.pass"));

        dataSource.setInitialPoolSize(getPropertyInt("connection.initPoolSize"));
        dataSource.setMinPoolSize(getPropertyInt("connection.minPoolSize"));
        dataSource.setMaxPoolSize(getPropertyInt("connection.maxPoolSize"));
        dataSource.setMaxIdleTime(getPropertyInt("connection.maxIdleTime"));

        return dataSource;
    }

    private int getPropertyInt(String prop) {
        return Integer.parseInt(environment.getProperty(prop));
    }


    @Bean
    public Properties getHibernateProperties() {
        Properties properties = new Properties();

        properties.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
        properties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));

        return properties;
    }

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

        sessionFactory.setDataSource(getDataSource());
        sessionFactory.setHibernateProperties(getHibernateProperties());
        sessionFactory.setPackagesToScan("ru.entity");

        return sessionFactory;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager getTransactionalManager(SessionFactory sessionFactory) {

        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);

        return txManager;
    }
}
