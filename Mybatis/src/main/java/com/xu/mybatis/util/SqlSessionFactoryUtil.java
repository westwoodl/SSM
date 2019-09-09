package com.xu.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtil {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapperConfig.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getInstance(String classpath) throws IOException {
        //加载mybatis配置文件
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        InputStream is = Resources.getResourceAsStream(classpath);

        sqlSessionFactory = ssfb.build(is);
        return sqlSessionFactory;
    }

    public static SqlSessionFactory getInstance() throws IOException {
        return getInstance("SqlMapperConfig.xml");
    }


}
