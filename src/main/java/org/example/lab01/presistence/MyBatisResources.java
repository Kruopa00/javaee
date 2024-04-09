package org.example.lab01.presistence;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.mybatis.cdi.SessionFactoryProvider;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.io.IOException;

@ApplicationScoped
public class MyBatisResources {
    @Produces
    @ApplicationScoped
    @SessionFactoryProvider
    private SqlSessionFactory sqlSessionFactory() {
        try {
            return new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("MyBatisConfig.xml"));
        } catch (IOException e) {
            throw new RuntimeException("MyBatisResources.produceSqlSessionFactory(): ", e);
        }
    }
}
